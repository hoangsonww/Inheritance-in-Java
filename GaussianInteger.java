/**
 * A class that represents Gaussian Integers
 * @author David Nguyen
 * @since  11/14/2022
 */
public class GaussianInteger implements GaussianIntegerInterface {

    //A field representing the real part
    private ArbitraryWholeNumbers real;
    //A field representing the imaginary part
    private ArbitraryWholeNumbers imaginary;

    /**
     * Creates a Gaussian Integer.
     * Assigns the class's fields the values that the constructor got when a GaussianInteger object is created.
     * @param real      An ArbitraryWholeNumbers that represents a real part
     * @param imaginary An ArbitraryWholeNumbers that represents an imaginary part
     */
    public GaussianInteger(ArbitraryWholeNumbers real, ArbitraryWholeNumbers imaginary) {
        this.real = real;
        this.imaginary = imaginary;
    }

    /**
     * A method that retrieves the real part of a gaussian integer.
     * @return A whole number that represents the real part of a gaussian integer
     */
    public ArbitraryWholeNumbers getRealPart() {
        return real;
    }

    /**
     * A method that retrieves the imaginary part of a gaussian integer.
     * @return A whole number that represents the imagainary part of a gaussian integer
     */
    public ArbitraryWholeNumbers getImaginaryPart() {
        return imaginary;
    }

    /**
     * A method that retrieves the imaginary part of the complex number.
     * @param  number Any GaussianInteger object that is given as input
     * @return A Gaussian Integer that is the result of the addition between this Gaussian Integer and the input number
     */
    public GaussianInteger add(GaussianIntegerInterface number) {
        ArbitraryWholeNumbers newReal = this.getRealPart().add(this.getRealPart(), number.getRealPart());
        ArbitraryWholeNumbers newImaginary = this.getImaginaryPart().add(this.getImaginaryPart(), number.getImaginaryPart());
        GaussianInteger result = new GaussianInteger (newReal, newImaginary);
        return result;
    }

    /**
     * A method that compares any two gaussian integers.
     * @param value1 Any GaussianInteger object that is given as input
     * @param value2 Any GaussianInteger object that is given as input
     * @return A boolean (true or false) depending on equality of these two numbers
     */
    public boolean equals (GaussianIntegerInterface value1, GaussianIntegerInterface value2) {
        return (value1.getRealPart().equals(value2.getRealPart())) && (value1.getImaginaryPart().equals(getImaginaryPart()));
    }

    /**
     * A method that returns the string representation of this gaussian integer.
     * @return A String that is the proper string representation of the gaussian integer
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