/**
 * A class that represents Arbitrary Whole Numbers
 * @author David Nguyen
 * @since  11/14/2022
 */
public class ArbitraryWholeNumbers extends ArbitraryFloatingPointNumbers {

    // A boolean field that indicates whether the number is less than 0 or not
    private boolean isNegative;
    // An array that stores the digits of the floating point number
    private int[] digits;

    /**
     * Creates an Arbitrary Whole Number.
     * Assigns the class's fields the values that the constructor got when a Arbitrary Whole Number object is created.
     * Passes the fields to the superclass (Arbitrary Floating Point Number).
     * @param isNegative A boolean indicating whether the current number is negative or not
     * @param digits     An array that represents the digits of an arbitrary floating point number
     */
    public ArbitraryWholeNumbers(boolean isNegative, int[] digits) {
        super(isNegative, digits);
        this.isNegative = isNegative;
        this.digits = digits;
    }

    /**
     * Determines whether the current arbitrary whole number is negative or not.
     * Returns true if the current number is negative.
     * Returns false if the current number is NOT negative.
     * @return A boolean that indicates whether the current number is negative.
     */
    public boolean isNegativeNumber() {
        if (isNegative)
            return true;
        else
            return false;
    }

    /**
     * An overridden toString method that creates the string representation of an arbitrary whole number given.
     * @return A string that is the proper string representation of an arbitrary whole number given
     */
    public String toString() {
        StringBuilder result = new StringBuilder();
        // Append '-' sign to the beginning of the number if the number is negative
        if (this.isNegative == true) {
            result.append('-');
        }
        // A new array that is same as digits but has all leading zeros removed.
        int[] array = removeLeadingZero(digits);
        // Append every element of the array that has all leading zeros removed to the resulting string
        for (int i = (array.length - 1); i >= 0; i--) {
            result.append(array[i]);
        }
        return result.toString();
    }

    /**
     * A helper method to remove leading zeros.
     * @param  array Any given int array that needs its leading zeros removed
     * @return An array that has all its leading zeros removed
     */
    public int[] removeLeadingZero(int[] array) {
        // A variable that stores the numbers of leading zeros
        int numLeadingZero = 0;
        // A variable that stores whether the current digit in the array is a non-zero
        boolean isNonZero = false;
        // A variable storing the index for the following 'while' loop
        int i = array.length - 1;
        /* A loop that determines the number of leading zeros.
         * The nonZero variable will also be set when the first non-zero is met to indicates the end of loop
         * Condition: The index must be more than or equal to 0 and the isNonZero variable must be FALSE
         */
        while (i >= 0 && !isNonZero) {
            if (array[i] == 0) {
                numLeadingZero++;
                isNonZero = false;
                i--;
            }
            else
                isNonZero = true;
        }
        // A variable that stores the length of the new array
        int newLength = array.length - numLeadingZero;
        // An array of type int that stores the new array
        int[] newArray = new int[newLength];
        // A variable storing the index of the old (given) array
        int index1 = array.length - numLeadingZero - 1;
        // A variable storing the index of the new array
        int index2 = newArray.length - 1;
        /* A loop that copies every element from old, original array to the new array
         * Condition: index of both arrays must be more than or equal to 0
         */
        while (index1 >= 0 && index2 >= 0) {
            newArray[index2] = array[index1];
            index1--;
            index2--;
        }
        return newArray;
    }

    /**
     * A helper method that converts all arrays to strings.
     * @param  array Any given arrays of type int
     * @return A String that is the string representation of the given array
     */
    public String arrayToString(int[] array) {
        // A variable of type StringBuilder that stores the output string
        StringBuilder output = new StringBuilder();
        /* A loop that appends every element of the given array into the output string
         * Condition: index must be less than length of array */
        for (int i = 0; i < array.length; i++) {
            if (array[i] != 0)
                output.append(array[i]);
        }
        return output.toString();
    }

    /**
     * An overridden equals method that determines if two whole numbers are equal to each other
     * This can be done by comparing the contents of the two string representations of the two numbers
     * @param o Any given object
     * @return Returning true or false depending on these numbers' equality
     */
    public boolean equals(Object o) {
        if (o instanceof ArbitraryWholeNumbers) {
            ArbitraryWholeNumbers number = (ArbitraryWholeNumbers) o;
            // A variable storing this number's digits with leading zeros removed
            int[] newArray1 = removeLeadingZero(this.digits);
            // A variable storing input, given number's digits with leading zeros removed
            int[] newArray2 = removeLeadingZero(number.digits);
            // A variable storing the string representation of this ArbitraryWholeNumbers
            String s1 = arrayToString(newArray1);
            // A variable storing the string representation of the given ArbitraryWholeNumbers
            String s2 = arrayToString(newArray2);
            return (this.isNegativeNumber() == number.isNegativeNumber() && s1.equals(s2));
        }
        return false;
    }

    /**
     * A method to add two arbitrary whole numbers and return the string representation of the result
     * @param     value1                        Any given value of type ArbitraryWholeNumbers
     * @param     value2                        Any given value of type ArbitraryWholeNumbers
     * @exception UnsupportedOperationException Throw this exception when given input numbers have different signs
     * @return    A new object of type ArbitraryWholeNumbers that has all the numbers added up
     */
    public ArbitraryWholeNumbers add (ArbitraryWholeNumbers value1, ArbitraryWholeNumbers value2) {
        // A variable to keep track of the carry
        int carry = 0;
        // A variable to set the length of the array
        int length = 0;
        // Remove Leading Zeros of both input values
        // Array1 is a new array of type int that is the digits of value1 that has been removed all leading zeros
        int[] newArray1 = removeLeadingZero(value1.digits);
        // Array2 is a new array of type int that is the digits of value2 that has been removed all leading zeros
        int[] newArray2 = removeLeadingZero(value2.digits);
        /* Setting length of resulting array to the maximum length between the two newArrays.
         */
        if (newArray1.length > newArray2.length)
            length = newArray1.length + 1;
        else
            length = newArray2.length + 1;
        // An array of type int storing a new array with the same length as the result array for input value2's digits
        int[] array1 = new int[length];
        // Copying all digits from value1's original digits array (with leading 0's removed) to this array (array1)
        for (int i = 0; i < newArray1.length; i++) {
            array1[i] = newArray1[i];
        }
        // An array of type int storing a new array with the same length as the result array for input value2's digits
        int[] array2 = new int[length];
        // Copying all digits from value1's original digits array (with leading 0's removed) to this array (array1)
        for (int i = 0; i < newArray2.length; i++) {
            array2[i] = newArray2[i];
        }
        // An array storing the resulting array from adding
        int[] result = new int[length];
        // A variable storing index of result's digits array
        int i = 0;
        // A temporary variable storing the sum of the addition of each corresponding pair of digits
        int s = 0;
        // If the values for adding have different signs, throw an UnsupportedOperationException
        if (value1.isNegativeNumber() == value2.isNegativeNumber()) {
            /* A loop that adds every corresponding pair of digits from the two arrays and stores them in the result array
             * Condition: index must be less than or equal to the result array's length */
            while (i < result.length) {
                s = array1[i] + array2[i] + carry;
                if (s >= 10) {
                    carry = 1;
                    result[i] = s - 10;
                }
                else {
                    carry = 0;
                    result[i] = s;
                }
                i++;
            }
        }
        else
            throw new UnsupportedOperationException("Invalid inputs");
        // A whole number object storing the output of the addition, which will also be returned
        ArbitraryWholeNumbers output = new ArbitraryWholeNumbers(false, result);
        // If the inputs are negative, the result must also have isNegative set to true
        if (value1.isNegativeNumber())
            output.isNegative = true;
        return output;
    }
}
