/**
 * A class that represents Complex Numbers
 * @author David Nguyen
 * @since  11/14/2022
 */
public class ComplexNumber implements ComplexNumberInterface{

    // A field representing the real part
    private ArbitraryFloatingPointNumbers real;
    // A field representing the imaginary part
    private ArbitraryFloatingPointNumbers imaginary;

    /**
     * Creates a Complex Number.
     * Assigns the class's fields the values that the constructor got when a ComplexNumber object is created.
     * @param real      An ArbitraryFloatingPointNumbers that represents a real part
     * @param imaginary An ArbitraryFloatingPointNumbers that represents an imaginary part
     */
    public ComplexNumber (ArbitraryFloatingPointNumbers real, ArbitraryFloatingPointNumbers imaginary) {
        this.real = real;
        this.imaginary = imaginary;
    }

    /**
     * A method that retrieves the real part of the complex number.
     * @return A floating point number that represents the real part of a complex number
     */
    public ArbitraryFloatingPointNumbers getRealPart() {
        return real;
    }

    /**
     * A method that retrieves the imaginary part of the complex number.
     * @return ArbitraryFloatingPointNumbers A floating point number that represents the imaginary part of a complex number
     */
    public ArbitraryFloatingPointNumbers getImaginaryPart() {
        return imaginary;
    }

    /**
     * A method that retrieves the imaginary part of the complex number.
     * @param  number Any ComplexNumber object that is given as input
     * @return A Complex Number that is the result of the addition between this ComplexNumber and the input number
     */
    public ComplexNumber add(ComplexNumberInterface number) {
        ArbitraryFloatingPointNumbers newReal = this.getRealPart().add(this.getRealPart(), number.getRealPart());
        ArbitraryFloatingPointNumbers newImaginary = this.getImaginaryPart().add(this.getImaginaryPart(), number.getImaginaryPart());
        ComplexNumber result = new ComplexNumber (newReal, newImaginary);
        return result;
    }

    /**
     * A method that compares any two complex numbers.
     * @param value1 Any ComplexNumber object that is given as input
     * @param value2 Any ComplexNumber object that is given as input
     * @return A boolean (true or false) depending on equality of these two numbers
     */
    public boolean equals(ComplexNumber value1, ComplexNumber value2) {
        return (value1.getRealPart().equals(value2.getRealPart())) && (value1.getImaginaryPart().equals(getImaginaryPart()));
    }

    /**
     * A method that returns the string representation of this complex number.
     * @return A String that is the proper string representation of the complex number
     */
    public String toString() {
        String output = new String();
        if (!getImaginaryPart().isNegativeNumber()) {
            output = (getRealPart() + " + " + getImaginaryPart() + "i");
        }
        else
            output = (getRealPart() + " " + getImaginaryPart() + "i");
        return output;
    }
}