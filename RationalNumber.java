/**
 * A class that represents Rational Numbers
 * @author David Nguyen
 * @since  11/14/2022
 */
public class RationalNumber implements RationalNumberInterface{

    //A field representing the real part
    private ArbitraryWholeNumbers numerator;
    //A field representing the imaginary part
    private ArbitraryWholeNumbers denominator;

    /**
     * Creates a Rational Number.
     * Assigns the class's fields the values that the constructor got when a RationalNumber object is created.
     * @param numerator   An ArbitraryWholeNumbers that represents the numerator
     * @param denominator An ArbitraryWholeNumbers that represents the denominator
     */
    public RationalNumber (ArbitraryWholeNumbers numerator, ArbitraryWholeNumbers denominator) {
        this.numerator = numerator;
        this.denominator = denominator;
    }

    /**
     * A method that retrieves the numerator of the rational number.
     * @return A whole number that represents the numerator of the rational number
     */
    public ArbitraryWholeNumbers getNumerator() {
        return numerator;
    }

    /**
     * A method that retrieves the denominator of the rational number.
     * @return A whole number that represents the denominator of the rational number
     */
    public ArbitraryWholeNumbers getDenominator() {
        return denominator;
    }

    /**
     * Overriding the getNumber() method that is inherited from class RealNumber.
     * Retrieving the number of the rational number - Retrieving the real part of the rational number, which is the
     * number itself, by returning either null if the denominator is not 1, as the rational cannot be represented in one
     * whole number, or returns the numerator if the denominator is 1
     * @return A whole number that represents the denominator of the rational number
     */
    public ArbitraryWholeNumbers getNumber() {
        return numerator;
    }

    /**
     * Overriding the getRealPart() method that is inherited from class RealNumber.
     * Retrieving the real part of the rational number, which is the number itself, by returning either null if the
     * denominator is not 1, as the rational cannot be represented in one whole number, or returns the numerator if
     * the denominator is 1
     * @return A whole number that represents the rational number
     */
    public ArbitraryWholeNumbers getRealPart() {
        return numerator;
    }

    /**
     * Overriding the getImaginaryPart() method that is inherited from class RealNumber.
     * Retrieving the imaginary part of the rational number, which is assumed to be null because a rational number cannot
     * be imaginary
     * @return null
     */
    public ArbitraryWholeNumbers getImaginaryPart() {
        return (new ArbitraryWholeNumbers (false, new int[] {0}));
    }

    /**
     * A method that computes the sum of this Rational Number and any input Rational Number.
     * @param  number Any RationalNumber object that is given as input
     * @return A RationalNumber object that is the sum of these two natural numbers
     */
    public RationalNumber add(RationalNumberInterface number) {
        if (this.getDenominator().equals(number.getDenominator())) {
            ArbitraryWholeNumbers newNumerator = this.getNumerator().add(this.getNumerator(), number.getNumerator());
            return (new RationalNumber (newNumerator, number.getDenominator()));
        }
        else
            throw new UnsupportedOperationException("Invalid inputs");
    }

    /**
     * A method that compares this Rational Number and any given input Rational Number
     * @param value1 Any given RationalNumber number
     * @param value2 Any given RationalNumber number
     * @return A boolean (true or false) depending on the equality of these two numbers
     */
    public boolean equals (RationalNumber value1, RationalNumber value2) {
        return (value1.getNumerator().equals(value2.getNumerator())) && (value1.getDenominator().equals(getDenominator()));
    }

    /**
     * A method that creates a string representation of this Rational Number
     * @return A String that is the string representation of this Rational Number
     */
    public String toString () {
        return (getNumerator() + " / " + getDenominator());
    }
}