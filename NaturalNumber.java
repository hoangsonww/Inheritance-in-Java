/**
 * A class that represents Natural Numbers
 * @author David Nguyen
 * @since  11/14/2022
 */
public class NaturalNumber implements NaturalNumberInterface{

    //A field representing the real part
    private ArbitraryWholeNumbers number;

    /**
     * Creates a Natural Number. A natural number is a whole number that is not negative
     * Assigns the class's fields the values that the constructor got when a NaturalNumber object is created.
     * @param number An ArbitraryWholeNumbers that represents the input integer
     */
    public NaturalNumber(ArbitraryWholeNumbers number) {
        if (!number.isNegativeNumber())
            this.number = number;
        else {
            throw new UnsupportedOperationException("Please enter a positive natural number!");
        }
    }

    /**
     * A method that retrieves the number of the natural number.
     * @return A whole number that represents the natural number
     */
    public ArbitraryWholeNumbers getNumber() {
        return number;
    }

    /**
     * Overriding the getRealPart() method inherited from class GaussianInteger.
     * A method that retrieves the imaginary part of the Gaussian Integer - which should be 0 because an integer number
     * cannot have any imaginary parts.
     * @return A whole number that represents the imaginary part of an integer number
     */
    public ArbitraryWholeNumbers getImaginaryPart() {
        return (new ArbitraryWholeNumbers (false, new int[] {0}));
    }

    /**
     * Overriding the getRealPart() method inherited from class GaussianInteger.
     * A method that retrieves the real part of a natural number - which that natural number itself
     * @return A whole number that represents a natural number
     */
    public ArbitraryWholeNumbers getRealPart() {
        return number;
    }

    /**
     * Overriding the getNumerator() method inherited from class RationalNumber.
     * A method that retrieves the numerator of a natural number - which is the number itself if the
     * denominator is 1, and the denominator must also be 1 in this case
     * @return A whole number that represents a natural number
     */
    public ArbitraryWholeNumbers getNumerator() {
        return number;
    }

    /**
     * Overriding the getDenominator() method inherited from class RationalNumber.
     * A method that retrieves the denominator of a natural number - which should be 1 and always 1 for a natural number
     * to be correctly represented
     * @return A whole number that represents a natural number
     */
    public ArbitraryWholeNumbers getDenominator() {
        return (new ArbitraryWholeNumbers (false, new int[] {1}));
    }

    /**
     * A method that computes the sum of this Natural Number and any input Natural Number.
     * @param  number Any NaturalNumber object that is given as input
     * @return A NaturalNumber object that is the sum of these two natural numbers
     */
    public NaturalNumber add(NaturalNumberInterface number) {
        ArbitraryWholeNumbers sum = this.getNumber().add(number.getNumber(), this.getNumber());
        NaturalNumber result = new NaturalNumber (sum);
        return result;
    }

    /**
     * A method that compares this Natural Number and any given input Natural Number.
     * @param value Any given natural number
     * @return A boolean (true or false) depending on the equality of these two numbers
     */
    public boolean equals(NaturalNumber value) {
        return (this.getNumber().equals(value.getNumber()));
    }

    /**
     * A method that creates a string representation of the give natural number
     * @return A String that is the string representation of the given natural number
     */
    public String toString() {
        return this.getNumber().toString();
    }
}