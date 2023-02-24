/**
 * An interface that represents Real Numbers
 * @author David Nguyen
 * @since  11/14/2022
 */
public interface RealNumberInterface extends ComplexNumberInterface {

    /**
     * An abstract method that retrieves the number part of the integer number.
     * @return A whole number that represents the number part of the integer number
     */
    ArbitraryFloatingPointNumbers getNumber();

}