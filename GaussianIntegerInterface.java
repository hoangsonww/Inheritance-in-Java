/**
 * An interface that represents Gaussian Integers
 * @author David Nguyen
 * @since  11/14/2022
 */
public interface GaussianIntegerInterface extends ComplexNumberInterface {

    /**
     * An abstract method that retrieves the real part of the gaussian integers.
     * @return A whole number that represents the real part of the gaussian integers
     */
    ArbitraryWholeNumbers getRealPart();

    /**
     * An abstract method that retrieves the imaginary part of the gaussian integers.
     * @return A whole number that represents the imaginary part of the gaussian integers
     */
    ArbitraryWholeNumbers getImaginaryPart();
}