/**
 * A class that represents Real Numbers
 * @author David Nguyen
 * @since  11/14/2022
 */
public class RealNumber implements RealNumberInterface {

    //A field representing a real, floating-point number
    private ArbitraryFloatingPointNumbers number;

    /**
     * Creates a Real Number.
     * Assigns the class's fields the values that the constructor got when a RealNumber object is created.
     * @param number An ArbitraryFloatingPointNumbers that represents the number
     */
    public RealNumber (ArbitraryFloatingPointNumbers number) {
        this.number = number;
    }

    /**
     * A method that retrieves the number of the real number.
     * @return A floating point number that represents the number of the real number.
     */
    public ArbitraryFloatingPointNumbers getNumber() {
        return number;
    }

    /**
     * Overriding the getRealPart() method inherited from class ComplexNumber.
     * A method that retrieves the real part of the real number - which is the number itself
     * @return A floating point number that represents the number of the real number
     */
    public ArbitraryFloatingPointNumbers getRealPart() {
        return number;
    }

    /**
     * Overriding the getImaginaryPart() method inherited from class ComplexNumber
     * A method that retrieves the imaginary part of the real number - which should be 0 because a real number cannot
     * have any imaginary parts
     * @return A floating point number that represents the number of the real number
     */
    public ArbitraryFloatingPointNumbers getImaginaryPart() {
        return (new ArbitraryWholeNumbers (false, new int[] {0}));
    }

    /**
     * A method that computes the sum of this Real Number and any input Real Number
     * @param  number Any RealNumber object that is given as input
     * @return A RealNumber object that is the sum of the two real numbers
     */
    public RealNumber add(RealNumberInterface number) {
        ArbitraryFloatingPointNumbers sum = this.getNumber().add(this.getNumber(), number.getNumber());
        RealNumber result = new RealNumber (sum);
        return result;
    }

    /**
     * A method that compares this RealNumber and any given input RealNumber
     * @param value1 Any given RealNumber number
     * @param value2 Any given RealNumber number
     * @return A boolean (true or false) depending on the equality of these two numbers
     */
    public boolean equals (RealNumber value1, RealNumber value2) {
        return (value1.getNumber().equals(value2.getNumber()));
    }

    /**
     * A method that creates a string representation of this Real Number
     * @return A String that is the string representation of this Real Number
     */
    public String toString() {
        return number.toString();
    }
}