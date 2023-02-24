/**
 * A class that represents Integer Numbers
 * @author David Nguyen
 * @since  11/14/2022
 */
public class IntegerNumber implements IntegerNumberInterface{

    //A field representing the real part
    private ArbitraryWholeNumbers number;

    /**
     * Creates a Integer Number.
     * Assigns the class's fields the values that the constructor got when a IntegerNumber object is created.
     * @param number An ArbitraryWholeNumbers that represents the input integer
     */
    public IntegerNumber(ArbitraryWholeNumbers number) {
        this.number = number;
    }

    /**
     * A method that retrieves the number part of the integer number.
     * @return A whole number that represents the number part of an integer number
     */
    public ArbitraryWholeNumbers getNumber() {
        return number;
    }

    /**
     * Overriding the getNumerator() method inherited from class RationalNumber.
     * Retrieves the numerator of the integer number - which should always be the number itself to correctly represent the
     * integer number. The denominator in this case must also be 1.
     * @return A whole number that represents the number part of an integer number
     */
    public ArbitraryWholeNumbers getNumerator() {
        return number;
    }

    /**
     * Overriding the getDenominator() method inherited from class RationalNumber
     * Retrieves the denominator of the integer number - which should always be the number of 1 to correctly represent the
     * integer number
     * @return A whole number that represents the number part of an integer number
     */
    public ArbitraryWholeNumbers getDenominator() {
        return (new ArbitraryWholeNumbers (false, new int[] {1}));
    }

    /**
     * Overriding the getRealPart() method inherited from class GaussianInteger
     * A method that retrieves the real part of the integer number - which should be the integer number itself
     * @return A whole number that represents the real part of an integer number
     */
    public ArbitraryWholeNumbers getRealPart() {
        return number;
    }

    /**
     * Overriding the getImaginaryPart() method inherited from class GaussianInteger.
     * A method that retrieves the imaginary part of the Gaussian Integer - which should be 0 because an integer number.
     * cannot have any imaginary parts
     * @return A whole number that represents the imaginary part of an integer number
     */
    public ArbitraryWholeNumbers getImaginaryPart() {
        return (new ArbitraryWholeNumbers (false, new int[] {0}));
    }

    /**
     * A method that retrieves the imaginary part of the integer number.
     * @param  number1 Any IntegerNumber object that is given as input
     * @param  number2 Any IntegerNumber object that is given as input
     * @return An Integer Number that is the result of the addition between this Gaussian Integer and the input number
     */
    public IntegerNumber add(IntegerNumberInterface number1, IntegerNumberInterface number2) {
        ArbitraryWholeNumbers result = number1.getNumber().add(number1.getNumber(), number2.getNumber());
        IntegerNumber output = new IntegerNumber(result);
        return output;
    }

    /**
     * A method that compares the two integer numbers.
     * @param  value1 Any IntegerNumber object that is given as input
     * @param  value2 Any IntegerNumber object that is given as input
     * @return An Integer Number that is the result of the addition between this Integer Number and the input number
     */
    public boolean equals(IntegerNumberInterface value1, IntegerNumberInterface value2) {
        return (value1.getNumber().equals(value2.getNumber()));
    }

    /**
     * A method that returns the string representation of this integer number.
     * @return A string that is the string represenation of this integer number
     */
    public String toString() {
        return getNumber().toString();
    }
}