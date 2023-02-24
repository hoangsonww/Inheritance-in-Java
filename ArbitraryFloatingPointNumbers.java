/**
 * A class that represents Arbitrary Floating Point Numbers
 * @author David Nguyen
 * @since  11/14/2022
 */
public class ArbitraryFloatingPointNumbers {

    // An int field that indicates the precision of the current Arbitrary Floating Point Number
    private int precision;
    // A boolean field that indicates whether the current Arbitrary Floating Point Number is negative or not
    private boolean isNegative;
    // An array of type int that stores the digits of a Arbitrary Floating Point Number
    private int[] digits;

    /**
     * Creates an Arbitrary Floating Point Number.
     * Assigns the class's fields the values that the constructor got when a Arbitrary Floating Point Number object is created.
     * @param  precision  An integer indicating how many digits to the right of the decimal point that the number has
     * @param  isNegative A boolean indicating whether the current number is negative or not
     * @param  digits     An array that represents the digits of an arbitrary floating point number
     */
    public ArbitraryFloatingPointNumbers(int precision, boolean isNegative, int[] digits) {
        this.precision = precision;
        this.isNegative = isNegative;
        this.digits = digits;
    }

    /**
     * Creates an Arbitrary Floating Point Number that has precision of 0 (a whole number).
     * Assigns the class's fields the values that the constructor got when a Arbitrary Floating Point Number object is created.
     * @param  isNegative A boolean indicating whether the current number is negative or not
     * @param  digits     An array that represents the digits of an arbitrary floating point number
     */
    public ArbitraryFloatingPointNumbers(boolean isNegative, int[] digits) {
        this.precision = 0;
        this.isNegative = isNegative;
        this.digits = digits;
    }

    /**
     * Determines whether the current arbitrary floating point number is negative or not.
     * Returns true if the current arbitrary floating point number is negative.
     * Returns false if the current arbitrary floating point number is NOT negative.
     * @return A boolean that indicates whether the current number is negative.
     */
    public boolean isNegativeNumber() {
        if (isNegative)
            return true;
        else
            return false;
    }

    /**
     * Returns the precision of the current arbitrary floating point number
     * @return An integer that shows the precision of the arbitrary floating point number
     */
    public int getPrecision() {
        return precision;
    }

    /**
     * Returns an array that has no leading zeros.
     * @param  array Any given array
     * @return An array that has no leading zeros
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
     * Converts a Arbitrary Floating Point Number object into its string representation
     * @return A String that is the string representation of the given Arbitrary Floating Point Number
     */
    public String toString() {
        // A variable (object) of type StringBuilder that stores the output, resulting string
        StringBuilder result = new StringBuilder();
        // Append '-' sign to the beginning of the number if the number is negative
        if (this.isNegative == true) {
            result.append('-');
        }
        /* A new array of type int that stores the digits of the current arbitrary floating point number after removing
         * all leading zeros
         */
        int[] array = removeLeadingZero(digits);
        /* Append each of the number in the digits array to the string representation of the number based on 3 cases:
         * If the length of the array is greater than current number's precision, append each digit normally
         * If the length of the array is equal to current number's precision, append 0. in front of number and then append
         * each digits normally.
         * If the length of the array is less than current number's precision, append 0. in front of number until the first
         * number in digits array is reached and then append each digits normally.
         */
        if (array.length > this.precision) {
            for (int i = (array.length - 1); i >= 0; i--) {
                result.append(array[i]);
                if (i == (getPrecision())) {
                    result.append('.');
                }
            }
        }
        else if (array.length == this.getPrecision()) {
            result.append('0').append('.');
            for (int i = (array.length - 1); i >= 0; i--) {
                result.append(array[i]);
            }
        }
        else {
            result.append('0').append('.');
            for (int i = 0; i < (this.getPrecision() - array.length); i++) {
                result.append('0');
            }
            for (int i = (array.length - 1); i >= (this.getPrecision() - array.length - 1); i--) {
                if (array[i] != '0')
                    result.append(array[i]);
            }
        }
        return result.toString();
    }

    /**
     * A helper method that converts all arrays to strings
     * @param  array  Any given arrays of type int
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
     * An overridden equals method that determines if two floating point numbers are equal to each other
     * This can be done by comparing the contents of the two string representations of the two numbers
     * @param o Any given object
     * @return Returning true or false depending on these numbers' equality
     */
    public boolean equals(Object o) {
        if (o instanceof ArbitraryFloatingPointNumbers) {
            // Typecasting given object to ArbitraryFloatingPointNumbers
            ArbitraryFloatingPointNumbers number = (ArbitraryFloatingPointNumbers) o;
            // A variable storing the string representation of the given ArbitraryFloatingPointNumbers
            String s1 = arrayToString(number.digits);
            // A variable storing the string representation of this ArbitraryFloatingPointNumbers
            String s2 = arrayToString(this.digits);
            return (this.isNegativeNumber() == number.isNegativeNumber() && s1.equals(s2));
        }
        return false;
    }

    /**
     * A helper method that helps determine the number of digits to the left of the decimal point of any Arbitrary
     * Floating Point Numbers
     * @param  value Any given ArbitraryFloatingPointNumbers-type object
     * @return An integer that represents the number of digits to the left of the decimal point of the given number
     */
    public int leftDecimals(ArbitraryFloatingPointNumbers value) {
        // A new array of type int that stores the given value's digits array but after being removed all leading zeros
        int[] newArray = removeLeadingZero(value.digits);
        return newArray.length - value.precision;
    }

    /**
     * A method to add two arbitrary whole numbers and return the string representation of the result
     * @param     value1                        Any given value of type ArbitraryFloatingPointNumbers
     * @param     value2                        Any given value of type ArbitraryFloatingPointNumbers
     * @exception UnsupportedOperationException Throw this exception when given input numbers have different signs
     * @return A new object of type ArbitraryFloatingPointNumbers that has all the numbers added up
     */
    public ArbitraryFloatingPointNumbers add(ArbitraryFloatingPointNumbers value1, ArbitraryFloatingPointNumbers value2) {
        // A variable to keep track of the carry
        int carry = 0;
        // A variable to set the length of the array
        int length = 0;
        // Remove Leading Zeros of both input values
        // Array1 is a new array of type int that is the digits of value1 that has been removed all leading zeros
        int[] newArray1 = removeLeadingZero(value1.digits);
        // Array2 is a new array of type int that is the digits of value2 that has been removed all leading zeros
        int[] newArray2 = removeLeadingZero(value2.digits);
        /* Setting length of resulting array to be one more than the sum of the maximum number of digits to the left of the
         * decimal point of value1 and value2 and the maximum digits to the right of the decimal point of value1 and value2.
         */
        if (leftDecimals(value1) >= leftDecimals(value2) && value1.getPrecision() >= value2.getPrecision())
            length = leftDecimals(value1) + value1.precision + 1;
        else if (leftDecimals(value1) >= leftDecimals(value2) && value1.getPrecision() <= value2.getPrecision())
            length = leftDecimals(value1) + value2.precision + 1;
        else if (leftDecimals(value1) <= leftDecimals(value2) && value1.getPrecision() >= value2.getPrecision())
            length = leftDecimals(value2) + value1.precision + 1;
        else if (leftDecimals(value1) <= leftDecimals(value2) && value1.getPrecision() <= value2.getPrecision())
            length = leftDecimals(value2) + value2.precision + 1;
        /* A new array with the same length as the result array to store input value1's digits, after being removed all
         * leading zeros and put in right position (by calling the helper method above) */
        int[] array1 = new int[length];
        /* A new array with the same length as the result array to store input value2's digits, after being removed all
         * leading zeros and put in right position (by calling the helper method above) */
        int[] array2 = new int[length];
        // A variable storing the precision of the resulting value
        int precisionOutput = 0;
        // A temporary variable for storing the placement for adding
        int numPlacement = 0;
        // Setting the precision of the output number to the equal to the greater precision value of the two inputs
        // Re-ordering the digits arrays so that their decimal points line up with each other
        /* If precision of value1 is greater than value2's, then add the digits of value2 to the newer array2 array so that
         * its decimal point must line up with value1's decimal point */
        if (value1.getPrecision() > value2.getPrecision()) {
            precisionOutput = value1.getPrecision();
            numPlacement = value1.getPrecision() - value2.getPrecision();
            // A loop that puts every element of the original digits array of value1 to the newer array1 to prepare number for adding
            for (int i = 0; i < newArray1.length; i++) {
                array1[i] = newArray1[i];
            }
            // Variables as indexes for the following 'while' loop
            int i = numPlacement;
            int j = 0;
            // A loop that puts every element of the original digits array of value2 to the newer array2 to prepare number for adding
            while (i < array2.length && j < newArray2.length) {
                array2[i] = newArray2[j];
                i++;
                j++;
            }
        }
        // Otherwise, do the same thing as above but in reverse order
        else {
            precisionOutput = value2.getPrecision();
            numPlacement = value2.getPrecision() - value1.getPrecision();
            // A loop that puts every element of value2's digits array to the newer array2 to prepare number for adding
            for (int i = 0; i < newArray2.length; i++) {
                array2[i] = newArray2[i];
            }
            // Variables that serve as indexes for the following 'while' loop
            int i = numPlacement;
            int j = 0;
            // A loop that puts every element of value1's digits array to the newer array1 to prepare number for adding
            while (i < array1.length && j < newArray1.length) {
                array1[i] = newArray1[j];
                i++;
                j++;
            }
        }
        // An array of type int that stores the result of the addition
        int[] result = new int[length];
        // A variable storing index for adding
        int i = 0;
        // A temporary variable storing the sum of the addition of each corresponding pair of digits
        int s = 0;
        // If the values for adding have different signs, throw an UnsupportedOperationException
        if ((value1.isNegativeNumber() == value2.isNegativeNumber())) {
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
        // An arbitrary floating point number storing the output of the addition
        ArbitraryFloatingPointNumbers output = new ArbitraryFloatingPointNumbers(precisionOutput, false, result);
        /* If the inputs are negative, the result must also have isNegative set to true
         * Otherwise, it will be kept as false */
        if (value1.isNegativeNumber())
            output.isNegative = true;
        return output;
    }
}