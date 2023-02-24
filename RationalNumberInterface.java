/**
 * An interface that represents Rational Numbers
 * @author David Nguyen
 * @since  11/14/2022
 */
public interface RationalNumberInterface extends RealNumberInterface {

    /**
     * An abstract method that retrieves the numerator part of the rational numbers.
     * @return A whole number that represents the numerator part of the rational numbers
     */
    ArbitraryWholeNumbers getNumerator();

    /**
     * An abstract method that retrieves the denominator part of the rational numbers.
     * @return A whole number that represents the denominator part of the grational numbers
     */
    ArbitraryWholeNumbers getDenominator();

}