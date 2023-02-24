/**
 * An interface that represents Complex Numbers
 * @author David Nguyen
 * @since  11/14/2022
 */
public interface ComplexNumberInterface {

    /**
     * An abstract method that retrieves the real part of the complex number.
     * @return A floating point number that represents the real part of the complex number
     */
    ArbitraryFloatingPointNumbers getRealPart();

    /**
     * An abstract method that retrieves the imaginary part of the complex number
     * @return A floating point number that represents the imaginary part of the complex number
     */
    ArbitraryFloatingPointNumbers getImaginaryPart();
}