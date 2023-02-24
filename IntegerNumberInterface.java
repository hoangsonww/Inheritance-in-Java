/**
 * An interface that represents Integer Numbers
 * @author David Nguyen
 * @since  11/14/2022
 */
public interface IntegerNumberInterface extends GaussianIntegerInterface, RationalNumberInterface {

    /**
     * An abstract method that retrieves the number part of the integer number.
     * @return A whole number that represents the number part of the integer number
     */
    ArbitraryWholeNumbers getNumber();

}