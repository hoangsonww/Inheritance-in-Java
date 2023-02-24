import java.util.Arrays;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * A test class for all methods in HW3.
 * All methods have been tested, test cases and other information for the tests are described in the comments below.
 * @author David Nguyen
 * @since  11/14/2022
 */
public class HW3Tester {

/**
 * Testing the ArbitraryFloatingPointNumbers class:
 */

    /**
     * Testing the getPrecision() method with 2 cases:
     */
    @Test
    public void testGetPrecision() {
        int[] a1 = new int[] {9,5,1,4,1,3};
        ArbitraryFloatingPointNumbers value1 = new ArbitraryFloatingPointNumbers (0, true, a1);
        int[] a2 = new int[] {9,5,1,4,1,3,1};
        ArbitraryFloatingPointNumbers value2 = new ArbitraryFloatingPointNumbers (1, false, a2);
        int[] a3 = new int[] {9,5,1,4,1,3,1,4};
        ArbitraryFloatingPointNumbers value3 = new ArbitraryFloatingPointNumbers (4, false, a3);
        // Case 1: Test if this number’s Precision is 0
        assertEquals(0, value1.getPrecision());
        // Case 2: Test if this number’s Precision is 1
        assertEquals(1, value2.getPrecision());
        // Case 3: Test if this number’s Precision is more than 1 (4)
        assertEquals(4, value3.getPrecision());
    }

    /**
     * Testing the isNegativeNumber() method with 2 cases:
     */
    @Test
    public void testIsNegativeFloatingNumber() {
        int[] a1 = new int[] {9,5,1,4,1,3};
        ArbitraryFloatingPointNumbers value1 = new ArbitraryFloatingPointNumbers (5, true, a1);
        int[] a2 = new int[] {9,5,1,4,1,3,1};
        ArbitraryFloatingPointNumbers value2 = new ArbitraryFloatingPointNumbers (5, false, a2);
        // Case 1: Test if this number is negative
        assertEquals(true, value1.isNegativeNumber());
        // Case 2: Test if this number is not negative
        assertEquals(false, value2.isNegativeNumber());
    }

    /**
     * Testing the toString() method with 6 cases:
     */
    @Test
    public void testToStringFloatingPoint() {
        int[] a1 = new int[] {6,7,1};
        ArbitraryFloatingPointNumbers value1 = new ArbitraryFloatingPointNumbers (4, true, a1);
        int[] a2 = new int[] {0,0,0,3,4,5,6,0,0,0};
        ArbitraryFloatingPointNumbers value2 = new ArbitraryFloatingPointNumbers (5, true, a2);
        int[] a3 = new int[] {6,7,1};
        ArbitraryFloatingPointNumbers value3 = new ArbitraryFloatingPointNumbers (3, true, a3);
        int[] a4 = new int[] {6,7,1};
        ArbitraryFloatingPointNumbers value4 = new ArbitraryFloatingPointNumbers (4, false, a4);
        int[] a5 = new int[] {0,0,0,3,4,5,6,0,0,0};
        ArbitraryFloatingPointNumbers value5 = new ArbitraryFloatingPointNumbers (5, false, a5);
        int[] a6 = new int[] {6,7,1};
        ArbitraryFloatingPointNumbers value6 = new ArbitraryFloatingPointNumbers (3, false, a6);
        // Case 1: Test if this number is negative with its precision greater than its digits array’s length
        assertEquals("-0.0176", value1.toString());
        // Case 2: Test if this number is negative with its precision smaller than its digits array’s length
        assertEquals("-65.43000", value2.toString());
        // Case 3: Test if this number is negative with its precision equal to its digits array’s length
        assertEquals("-0.176", value3.toString());
        // Case 4: Test if this number is not negative with its precision greater than its digits array’s length
        assertEquals("0.0176", value4.toString());
        // Case 5: Test if this number is not negative with its precision smaller than its digits array’s length
        assertEquals("65.43000", value5.toString());
        // Case 6: Test if this number is not negative with its precision equal to its digits array’s length
        assertEquals("0.176", value6.toString());
    }

    /**
     * Testing the removeLeadingZero() method with 6 cases:
     */
    @Test
    public void testRemoveLeadingZeroFloatingPoint() {
        int[] a1 = new int[] { 0, 0, 0, 3, 4, 5, 6 };
        int[] a2 = new int[] { 0, 0, 0, 3, 4, 5, 6, 0 };
        int[] a3 = new int[] { 0, 0, 0, 3, 4, 5, 6, 0, 0, 0 };
        int[] a4 = new int[] { 0, 3, 4, 5, 6 };
        int[] a5 = new int[] { 3, 4, 5, 6, 0 };
        int[] a6 = new int[] { 3, 4, 5, 0, 6};
        int[] a7 = new int[] { 3, 4, 5, 6 };
        ArbitraryFloatingPointNumbers value1 = new ArbitraryFloatingPointNumbers (4, true, a1);
        // Case 1: Test 0 - test if the given digits array contains no leading zero
        assertEquals(true, Arrays.equals(value1.removeLeadingZero(a1), a1));
        // Case 2: Test 1 - test if the given digits array contains 1 leading zero
        assertEquals(true, Arrays.equals(value1.removeLeadingZero(a2), a1));
        // Case 3: Test many - test if the given digits array contains many leading zeros
        assertEquals(true, Arrays.equals(value1.removeLeadingZero(a3), a1));
        // Case 4: Test first - test if the first digit of the given digits array is 0
        assertEquals(true, Arrays.equals(value1.removeLeadingZero(a4), a4));
        // Case 5: Test last - test if the last digit of the given digits array is 0
        assertEquals(true, Arrays.equals(value1.removeLeadingZero(a5), a7));
        // Case 6: Test middle - test if the middle digits of the given digits array is 0
        assertEquals(true, Arrays.equals(value1.removeLeadingZero(a6), a6));
    }

    /**
     * Testing the leftDecimals() method with 3 cases:
     */
    @Test
    public void testLeftDecimals() {
        int[] a1 = new int[] {6,7,1};
        ArbitraryFloatingPointNumbers value1 = new ArbitraryFloatingPointNumbers (3, true, a1);
        int[] a2 = new int[] {0,0,0,3,4,5,6};
        ArbitraryFloatingPointNumbers value2 = new ArbitraryFloatingPointNumbers (6, true, a2);
        int[] a3 = new int[] {0,0,0,3,4,5,6};
        ArbitraryFloatingPointNumbers value3 = new ArbitraryFloatingPointNumbers (4, true, a3);
        // Case 1: Test if the number of digits to the left of floating point is 0
        assertEquals(0, value1.leftDecimals(value1));
        // Case 2: Test if the number of digits to the left of floating point is 1
        assertEquals(1, value1.leftDecimals(value2));
        // Case 3: Test if the number of digits to the left of floating point is 3
        assertEquals(3, value1.leftDecimals(value3));
    }

    /**
     * Testing the arrayToString() method with 2 cases:
     */
    @Test
    public void testArrayToStringFloatingPoint() {
        int[] a1 = new int[] { 1 };
        int[] a2 = new int[] { 0, 3, 4, 5, 6 };
        ArbitraryFloatingPointNumbers value1 = new ArbitraryFloatingPointNumbers (4, false, a1);
        // Case 1: Test if a given number to be converted into a string contains 1 digit
        assertEquals("1", value1.arrayToString(a1));
        // Case 2: Test if a given number to be converted into a string contains many digits
        assertEquals("3456", value1.arrayToString(a2));
    }

    /**
     * Testing the equals() method with 2 cases:
     */
    @Test
    public void testEqualsFloatingPoint() {
        int[] a1 = new int[] {9,5,1,4,1,3,1,4};
        ArbitraryFloatingPointNumbers value1 = new ArbitraryFloatingPointNumbers (5, false, a1);
        int[] a2 = new int[] {6,7,1};
        ArbitraryFloatingPointNumbers value2 = new ArbitraryFloatingPointNumbers (3, true, a2);
        int[] a3 = new int[] {9,5,1,4,1,3,1,4};
        ArbitraryFloatingPointNumbers value3 = new ArbitraryFloatingPointNumbers (5, false, a3);
        // Case 1: Test if this number and the number to be compared is not equal:
        assertEquals(false, value1.equals(value2));
        // Case 2: Test if this number and the number to be compared is equal to each other:
        assertEquals(true, value1.equals(value3));
    }

    /**
     * Testing the add() method with 6 cases:
     */
    @Test
    public void testAddFloatingPointNumbers() {
        // Case 1: Test if the addition of a positive number with another number with a bigger precision:
        int[] a1 = new int[] {3,5,1};
        ArbitraryFloatingPointNumbers value1 = new ArbitraryFloatingPointNumbers (2, false, a1);
        int[] a2 = new int[] {5,8,7,2,1};
        ArbitraryFloatingPointNumbers value2 = new ArbitraryFloatingPointNumbers (4, false, a2);
        int[] a3 = new int[] {5,8,0,8,2};
        ArbitraryFloatingPointNumbers value3 = new ArbitraryFloatingPointNumbers (4, false, a3);
        assertEquals(true, value1.add(value1,value2).equals(value3));
        // Case 2: Test if the addition of a positive number with another number with a smaller precision:
        int[] a4 = new int[] {5,8,7,2,1};
        ArbitraryFloatingPointNumbers value4 = new ArbitraryFloatingPointNumbers (4, false, a4);
        int[] a5 = new int[] {3,5,1};
        ArbitraryFloatingPointNumbers value5 = new ArbitraryFloatingPointNumbers (2, false, a5);
        int[] a6 = new int[] {5,8,0,8,2};
        ArbitraryFloatingPointNumbers value6 = new ArbitraryFloatingPointNumbers (4, false, a6);
        assertEquals(true, value4.add(value4,value5).equals(value6));
        // Case 3: Test if the addition of two positive numbers with equal precisions
        int[] a7 = new int[] {5,3,1};
        ArbitraryFloatingPointNumbers value7 = new ArbitraryFloatingPointNumbers (2, false, a7);
        int[] a8 = new int[] {3,5,1};
        ArbitraryFloatingPointNumbers value8 = new ArbitraryFloatingPointNumbers (2, false, a8);
        int[] a9 = new int[] {8,8,2};
        ArbitraryFloatingPointNumbers value9 = new ArbitraryFloatingPointNumbers (2, false, a9);
        assertEquals(true, value7.add(value7,value8).equals(value9));
        // Case 4: Test if the addition of a negative number with another number with a bigger precision
        int[] a10 = new int[] {3,5,1};
        ArbitraryFloatingPointNumbers value10 = new ArbitraryFloatingPointNumbers (2, true, a10);
        int[] a11 = new int[] {5,8,7,2,1};
        ArbitraryFloatingPointNumbers value11 = new ArbitraryFloatingPointNumbers (4, true, a11);
        int[] a12 = new int[] {5,8,0,8,2};
        ArbitraryFloatingPointNumbers value12 = new ArbitraryFloatingPointNumbers (4, true, a12);
        assertEquals(true, value10.add(value10,value11).equals(value12));
        // Case 5: Test if the addition of a negative number with another number with a smaller precision
        int[] a13 = new int[] {5,8,7,2,1};
        ArbitraryFloatingPointNumbers value13 = new ArbitraryFloatingPointNumbers (4, true, a13);
        int[] a14 = new int[] {3,5,1};
        ArbitraryFloatingPointNumbers value14 = new ArbitraryFloatingPointNumbers (2, true, a14);
        int[] a15 = new int[] {5,8,0,8,2};
        ArbitraryFloatingPointNumbers value15 = new ArbitraryFloatingPointNumbers (4, true, a15);
        assertEquals(true, value14.add(value13,value14).equals(value15));
        // Case 6: Test if the addition of two negative numbers with equal precisions
        int[] a16 = new int[] {5,3,1};
        ArbitraryFloatingPointNumbers value16 = new ArbitraryFloatingPointNumbers (2, true, a16);
        int[] a17 = new int[] {3,5,1};
        ArbitraryFloatingPointNumbers value17 = new ArbitraryFloatingPointNumbers (2, true, a17);
        int[] a18 = new int[] {8,8,2};
        ArbitraryFloatingPointNumbers value18 = new ArbitraryFloatingPointNumbers (2, true, a18);
        assertEquals(true, value17.add(value17,value16).equals(value18));
    }

    /**
     * Case 7 of the add() method testing: Test if the inputs with different signs will throw an Unsupported Operation Exception:
     */
    @Test
    public void testIfAddThrowsExceptionFloatingPoint() {
        int[] a1 = new int[] {7,9,0,2,4};
        ArbitraryFloatingPointNumbers value = new ArbitraryFloatingPointNumbers (true, a1);
        int[] a2 = new int[] {3,1,4};
        ArbitraryFloatingPointNumbers value1 = new ArbitraryFloatingPointNumbers (false, a2);
        boolean thrown = false;
        try {
            value.add(value, value1);
        }
        catch (UnsupportedOperationException e) {
            thrown = true;
        }
        assertEquals(true, thrown);
    }

/**
 * Testing ArbitraryWholeNumbers methods:
 */

    /**
     * Testing isNegativeNumber() method:
     */
    @Test
    public void testIsNegativeWholeNumber() {
        int[] a1 = new int[] {9,5,1,4,1,3};
        ArbitraryWholeNumbers value1 = new ArbitraryWholeNumbers (true, a1);
        int[] a2 = new int[] {9,5,1,4,1,3,1};
        ArbitraryWholeNumbers value2 = new ArbitraryWholeNumbers (false, a2);
        // Case 1: Testing when given number is negative
        assertEquals(true, value1.isNegativeNumber());
        // Case 2: Testing when given number is positive
        assertEquals(false, value2.isNegativeNumber());
    }

    /**
     * Testing toString() method:
     */
    @Test
    public void testToStringWholeNumber() {
        int[] a1 = new int[] {6,7,1};
        ArbitraryWholeNumbers value1 = new ArbitraryWholeNumbers (true, a1);
        int[] a2 = new int[] {0,0,0,3,4,5,6,0};
        ArbitraryWholeNumbers value2 = new ArbitraryWholeNumbers (true, a2);
        int[] a3 = new int[] {0,0,0,3,4,5,6,0,0,0};
        ArbitraryWholeNumbers value3 = new ArbitraryWholeNumbers (true, a3);
        int[] a4 = new int[] {6,7,1};
        ArbitraryWholeNumbers value4 = new ArbitraryWholeNumbers (false, a4);
        int[] a5 = new int[] {0,0,0,3,4,5,6,0};
        ArbitraryWholeNumbers value5 = new ArbitraryWholeNumbers (false, a5);
        int[] a6 = new int[] {0,0,0,3,4,5,6,0,0,0};
        ArbitraryWholeNumbers value6 = new ArbitraryWholeNumbers (false, a6);
        // Case 1: Test if this number is negative with 0 leading zero
        assertEquals("-176", value1.toString());
        // Case 2: Test if this number is negative with 1 leading zero
        assertEquals("-6543000", value2.toString());
        // Case 3: Test if this number is negative with many leading zeros
        assertEquals("-6543000", value3.toString());
        // Case 4: Test if this number is not negative with 0 leading zero
        assertEquals("176", value4.toString());
        // Case 5: Test if this number is not negative with 1 leading zero
        assertEquals("6543000", value5.toString());
        // Case 6: Test if this number is not negative with many leading zeros
        assertEquals("6543000", value6.toString());
    }

    /**
     * Testing the removeLeadingZero() method with 6 cases:
     */
    @Test
    public void testRemoveLeadingZeroWholeNumber() {
        int[] a1 = new int[] { 0, 0, 0, 3, 4, 5, 6 };
        int[] a2 = new int[] { 0, 0, 0, 3, 4, 5, 6, 0 };
        int[] a3 = new int[] { 0, 0, 0, 3, 4, 5, 6, 0, 0, 0 };
        int[] a4 = new int[] { 0, 3, 4, 5, 6 };
        int[] a5 = new int[] { 3, 4, 5, 6, 0 };
        int[] a6 = new int[] { 3, 4, 5, 0, 6};
        int[] a7 = new int[] { 3, 4, 5, 6 };
        ArbitraryWholeNumbers value1 = new ArbitraryWholeNumbers (false, a1);
        // Case 1: Test 0 - test if the given digits array contains no leading zero
        assertEquals(true, Arrays.equals(value1.removeLeadingZero(a1), a1));
        // Case 2: Test 1 - test if the given digits array contains 1 leading zero
        assertEquals(true, Arrays.equals(value1.removeLeadingZero(a2), a1));
        // Case 3: Test many - test if the given digits array contains many leading zeros
        assertEquals(true, Arrays.equals(value1.removeLeadingZero(a3), a1));
        // Case 4: Test first - test if the first digit of the given digits array is 0
        assertEquals(true, Arrays.equals(value1.removeLeadingZero(a4), a4));
        // Case 5: Test last - test if the last digit of the given digits array is 0
        assertEquals(true, Arrays.equals(value1.removeLeadingZero(a5), a7));
        // Case 6: Test middle - test if the middle digits of the given digits array is 0
        assertEquals(true, Arrays.equals(value1.removeLeadingZero(a6), a6));
    }

    /**
     * Testing the arrayToString() method with 2 cases:
     */
    @Test
    public void testArrayToStringWholeNumber() {
        int[] a1 = new int[] { 1 };
        int[] a2 = new int[] { 0, 3, 4, 5, 6 };
        ArbitraryWholeNumbers value1 = new ArbitraryWholeNumbers (false, a1);
        // Case 1: Test if a given number to be converted into a string contains 1 digit
        assertEquals("1", value1.arrayToString(a1));
        // Case 2: Test if a given number to be converted into a string contains many digits
        assertEquals("3456", value1.arrayToString(a2));
    }

    /**
     * Testing the equals() method with 2 cases:
     */
    @Test
    public void testEqualsWholeNumber() {
        int[] a1 = new int[] {9,5,1,4,1,3,1,4};
        ArbitraryWholeNumbers value1 = new ArbitraryWholeNumbers (false, a1);
        int[] a2 = new int[] {6,7,1};
        ArbitraryWholeNumbers value2 = new ArbitraryWholeNumbers (true, a2);
        int[] a3 = new int[] {9,5,1,4,1,3,1,4};
        ArbitraryWholeNumbers value3 = new ArbitraryWholeNumbers (false, a3);
        // Case 1: Test if this number and the number to be compared is not equal
        assertEquals(false, value1.equals(value2));
        // Case 2: Test if this number and the number to be compared is equal to each other
        assertEquals(true, value1.equals(value3));
    }

    /**
     * Testing the add() method with 2 cases:
     */
    @Test
    public void testAddWholeNumbers() {
        // Case 1: Test if the addition of a positive number with another positive number can produce a correct result
        int[] a1 = new int[] {4,1,5,8};
        ArbitraryWholeNumbers value1 = new ArbitraryWholeNumbers (false, a1);
        int[] a2 = new int[] {0,0,0,3,4,5,6};
        ArbitraryWholeNumbers value2 = new ArbitraryWholeNumbers (false, a2);
        int[] a3 = new int[] {4,1,5,1,5,5,6};
        ArbitraryWholeNumbers value3 = new ArbitraryWholeNumbers (false, a3);
        assertEquals(true, value1.add(value1,value2).equals(value3));
        // Case 2: Test if the addition of a negative number with another negative number can produce a correct result
        int[] a4 = new int[] {9,5,9};
        ArbitraryWholeNumbers value4 = new ArbitraryWholeNumbers (true, a4);
        int[] a5 = new int[] {9,6,9};
        ArbitraryWholeNumbers value5 = new ArbitraryWholeNumbers (true, a5);
        int[] a6 = new int[] {8,2,9,1};
        ArbitraryWholeNumbers value6 = new ArbitraryWholeNumbers (true, a6);
        assertEquals(true, value4.add(value4,value5).equals(value6));
    }

    /**
     * Case 3 of the add() method testing: Test if the inputs with different signs will throw an Unsupported Operation Exception:
     */
    @Test
    public void testIfAddWholeNumbersThrowsException() {
        int[] a1 = new int[] {7,9,0,2,4};
        ArbitraryWholeNumbers value = new ArbitraryWholeNumbers (true, a1);
        int[] a2 = new int[] {3,1,4};
        ArbitraryWholeNumbers value1 = new ArbitraryWholeNumbers (false, a2);
        boolean thrown = false;
        try {
            value.add(value, value1);
        }
        catch (UnsupportedOperationException e) {
            thrown = true;
        }
        assertEquals(true, thrown);
    }

/**
 * Testing the ComplexNumber class:
 */

    /**
     * Testing the getRealPart() method with 2 cases:
     */
    @Test
    public void testGetRealPartComplex() {
        // Case 1: Test if the method correctly returns the real part (which, in this case, is NEGATIVE) of the complex number
        int[] a1 = new int[] {2,3,5,1,3};
        ArbitraryFloatingPointNumbers value1 = new ArbitraryFloatingPointNumbers (4, true, a1);
        int[] a2 = new int[] {3,2,1,7,6};
        ArbitraryFloatingPointNumbers value2 = new ArbitraryFloatingPointNumbers (3, false, a2);
        ComplexNumber c = new ComplexNumber(value1, value2);
        assertEquals(true, c.getRealPart().equals(value1));
        // Case 2: Test if the method correctly returns the real part (which, in this case, is POSITIVE) of the complex number
        int[] a3 = new int[] {2,3,5,1,3};
        ArbitraryFloatingPointNumbers value3 = new ArbitraryFloatingPointNumbers (4, false, a3);
        int[] a4 = new int[] {3,2,1,7,6};
        ArbitraryFloatingPointNumbers value4 = new ArbitraryFloatingPointNumbers (3, false, a4);
        ComplexNumber d = new ComplexNumber(value3, value4);
        assertEquals(true, d.getRealPart().equals(value3));
    }

    /**
     * Testing the getImaginaryPart() method with 2 cases:
     */
    @Test
    public void testGetImaginaryPartComplex() {
        // Case 1: Test if the method correctly returns the imaginary part (which, in this case, is POSITIVE) of the complex number
        int[] a1 = new int[] {2,3,5,1,3};
        ArbitraryFloatingPointNumbers value1 = new ArbitraryFloatingPointNumbers (4, false, a1);
        int[] a2 = new int[] {3,2,1,7,6};
        ArbitraryFloatingPointNumbers value2 = new ArbitraryFloatingPointNumbers (3, false, a2);
        ComplexNumber c = new ComplexNumber(value1, value2);
        assertEquals(true, c.getImaginaryPart().equals(value2));
        // Case 2: Test if the method correctly returns the real part (which, in this case, is NEGATIVE) of the complex number
        int[] a3 = new int[] {2,3,5,1,3};
        ArbitraryFloatingPointNumbers value3 = new ArbitraryFloatingPointNumbers (4, false, a3);
        int[] a4 = new int[] {3,2,1,7,6};
        ArbitraryFloatingPointNumbers value4 = new ArbitraryFloatingPointNumbers (3, true, a4);
        ComplexNumber d = new ComplexNumber(value3, value4);
        assertEquals(true, d.getImaginaryPart().equals(value4));
    }

    /**
     * Testing the add() method with 4 cases:
     */
    @Test
    public void testAddComplexNumbers() {
     /* Case 1: Test if the addition between a complex number with a positive real part and positive imaginary part and
     another complex number with a positive real part and positive imaginary part */
        int[] a1 = new int[] {2,3,5,1,3};
        ArbitraryFloatingPointNumbers value1 = new ArbitraryFloatingPointNumbers (4, false, a1);
        int[] a2 = new int[] {3,2,1,7,6};
        ArbitraryFloatingPointNumbers value2 = new ArbitraryFloatingPointNumbers (3, false, a2);
        ComplexNumber c = new ComplexNumber(value1, value2);
        int[] a3 = new int[] {3,0,0,0,3};
        ArbitraryFloatingPointNumbers value3 = new ArbitraryFloatingPointNumbers (4, false, a3);
        int[] a4 = new int[] {4,6,9,5};
        ArbitraryFloatingPointNumbers value4 = new ArbitraryFloatingPointNumbers (3, false, a4);
        ComplexNumber d = new ComplexNumber(value3, value4);
        int[] a5 = new int[] {5,3,5,1,6};
        ArbitraryFloatingPointNumbers value5 = new ArbitraryFloatingPointNumbers (4, false, a5);
        int[] a6 = new int[] {7,8,0,3,7};
        ArbitraryFloatingPointNumbers value6 = new ArbitraryFloatingPointNumbers (3, false, a6);
        ComplexNumber e = new ComplexNumber(value5, value6);
        assertEquals(true, ((c.add(d).toString()).equals(e.toString())));
        /* Case 2: Test if the addition between a complex number with a positive real part and negative imaginary part and
         * another complex number with a positive real part and negative imaginary part */
        int[] a7 = new int[] {2,3,5,1,3};
        ArbitraryFloatingPointNumbers value7 = new ArbitraryFloatingPointNumbers (4, false, a7);
        int[] a8 = new int[] {3,2,1,7,6};
        ArbitraryFloatingPointNumbers value8 = new ArbitraryFloatingPointNumbers (3, true, a8);
        ComplexNumber f = new ComplexNumber(value7, value8);
        int[] a9 = new int[] {2,3,5,1,3};
        ArbitraryFloatingPointNumbers value9 = new ArbitraryFloatingPointNumbers (4, false, a9);
        int[] a10 = new int[] {7,2,0,4};
        ArbitraryFloatingPointNumbers value10 = new ArbitraryFloatingPointNumbers (2, true, a10);
        ComplexNumber g = new ComplexNumber(value9, value10);
        int[] a11 = new int[] {4,6,0,3,6};
        ArbitraryFloatingPointNumbers value11 = new ArbitraryFloatingPointNumbers (4, false, a11);
        int[] a12 = new int[] {3,9,3,7,0,1};
        ArbitraryFloatingPointNumbers value12 = new ArbitraryFloatingPointNumbers (3, true, a12);
        ComplexNumber h = new ComplexNumber(value11, value12);
        assertEquals(true, ((f.add(g).toString()).equals(h.toString())));
        /* Case 3: Test if the addition between a complex number with a negative real part and positive imaginary
         * part and another complex number with a negative real part and positive imaginary part */
        int[] a13 = new int[] {7,9,0,2,4};
        ArbitraryFloatingPointNumbers value13 = new ArbitraryFloatingPointNumbers (4, true, a13);
        int[] a14 = new int[] {9,9,9,9};
        ArbitraryFloatingPointNumbers value14 = new ArbitraryFloatingPointNumbers (3, false, a14);
        ComplexNumber i = new ComplexNumber(value13, value14);
        int[] a15 = new int[] {2,2,5};
        ArbitraryFloatingPointNumbers value15 = new ArbitraryFloatingPointNumbers (2, true, a15);
        int[] a16 = new int[] {7,7,7,7,8};
        ArbitraryFloatingPointNumbers value16 = new ArbitraryFloatingPointNumbers (4, false, a16);
        ComplexNumber j = new ComplexNumber(value15, value16);
        int[] a17 = new int[] {7,9,2,4,9};
        ArbitraryFloatingPointNumbers value17 = new ArbitraryFloatingPointNumbers (4, true, a17);
        int[] a18 = new int[] {7,6,7,7,8,1};
        ArbitraryFloatingPointNumbers value18 = new ArbitraryFloatingPointNumbers (4, false, a18);
        ComplexNumber k = new ComplexNumber(value17, value18);
        assertEquals(true, ((i.add(j).toString()).equals(k.toString())));
        /* Case 4: Test if the addition between a complex number with a negative real part and negative imaginary part and
         * another complex number with a negative real part and negative imaginary part */
        int[] a19 = new int[] {7,9,0,2,4};
        ArbitraryFloatingPointNumbers value19 = new ArbitraryFloatingPointNumbers (4, true, a19);
        int[] a20 = new int[] {9,9,9,9};
        ArbitraryFloatingPointNumbers value20 = new ArbitraryFloatingPointNumbers (3, true, a20);
        ComplexNumber l = new ComplexNumber(value7, value8);
        int[] a21 = new int[] {2,2,5};
        ArbitraryFloatingPointNumbers value21 = new ArbitraryFloatingPointNumbers (4, true, a21);
        int[] a22 = new int[] {7,7,7,7,8};
        ArbitraryFloatingPointNumbers value22 = new ArbitraryFloatingPointNumbers (2, true, a22);
        ComplexNumber m = new ComplexNumber(value9, value10);
        int[] a23 = new int[] {7,9,2,4,9};
        ArbitraryFloatingPointNumbers value23 = new ArbitraryFloatingPointNumbers (4, true, a23);
        int[] a24 = new int[] {7,6,7,7,8,1};
        ArbitraryFloatingPointNumbers value24 = new ArbitraryFloatingPointNumbers (3, true, a24);
        ComplexNumber n = new ComplexNumber(value11, value12);
        assertEquals(true, ((l.add(m).toString()).equals(n.toString())));
        // Case 5: Test if adding in hierarchy can produce a correct number
        // Test if adding a complex number with an integer number can produce a correct result
        int[] a25 = new int[] {7,9,7,2,7};
        ArbitraryWholeNumbers value25 = new ArbitraryWholeNumbers (false, a25);
        int[] a26 = new int[] {7,9,7,2,7};
        ArbitraryWholeNumbers value26 = new ArbitraryWholeNumbers (false, a26);
        ComplexNumber complexNumber = new ComplexNumber (value25, value26);
        IntegerNumber integerNumber = new IntegerNumber (value25);
        int[] a27 = new int[] {4,9,5,5,4,1};
        ArbitraryFloatingPointNumbers value27 = new ArbitraryFloatingPointNumbers (false, a27);
        int[] a28 = new int[] {7,9,7,2,7};
        ArbitraryFloatingPointNumbers value28 = new ArbitraryFloatingPointNumbers (false, a28);
        ComplexNumber complexNumber2 = new ComplexNumber (value27, value28);
        assertEquals(true, ((complexNumber.add(integerNumber).toString()).equals(complexNumber2.toString())));
    }

    /**
     * Case 6 of the add() method testing: Test if the inputs with different signs will throw an Unsupported Operation Exception:
     */
    @Test
    public void testIfAddComplexThrowsException() {
        int[] a1 = new int[] {7,9,0,2,4};
        ArbitraryWholeNumbers value = new ArbitraryWholeNumbers (true, a1);
        int[] a2 = new int[] {3,1,4};
        ArbitraryWholeNumbers value1 = new ArbitraryWholeNumbers (false, a2);
        ComplexNumber c1 = new ComplexNumber (value, value1);
        int[] a3 = new int[] {7,2,9,5,6};
        ArbitraryWholeNumbers value2 = new ArbitraryWholeNumbers (false, a3);
        int[] a4 = new int[] {5,6};
        ArbitraryWholeNumbers value3 = new ArbitraryWholeNumbers (true, a4);
        ComplexNumber c2 = new ComplexNumber (value2, value3);
        boolean thrown = false;
        try {
            c1.add(c2);
        }
        catch (UnsupportedOperationException e) {
            thrown = true;
        }
        assertEquals(true, thrown);
    }

    /**
     * Testing the equals() method with 2 cases:
     */
    @Test
    public void testEqualsComplexNumbers() {
        // Case 1: Test if this complex number and the number to be compared is equal
        int[] a1 = new int[] {2,3,5,1,3};
        ArbitraryFloatingPointNumbers value1 = new ArbitraryFloatingPointNumbers (4, true, a1);
        int[] a2 = new int[] {3,2,1,7,6};
        ArbitraryFloatingPointNumbers value2 = new ArbitraryFloatingPointNumbers (3, false, a2);
        ComplexNumber c = new ComplexNumber(value1, value2);
        int[] a3 = new int[] {2,3,5,1,3};
        ArbitraryFloatingPointNumbers value3 = new ArbitraryFloatingPointNumbers (4, true, a3);
        int[] a4 = new int[] {3,2,1,7,6};
        ArbitraryFloatingPointNumbers value4 = new ArbitraryFloatingPointNumbers (3, false, a4);
        ComplexNumber d = new ComplexNumber(value3, value4);
        assertEquals(true, c.equals(c,d));
        // Case 2: Test if this complex number and the number to be compared is not equal
        int[] a5 = new int[] {2,3,5,1,3};
        ArbitraryFloatingPointNumbers value5 = new ArbitraryFloatingPointNumbers (4, true, a5);
        int[] a6 = new int[] {3,2,1,7};
        ArbitraryFloatingPointNumbers value6 = new ArbitraryFloatingPointNumbers (3, false, a6);
        ComplexNumber e = new ComplexNumber(value5, value6);
        int[] a7 = new int[] {2,3,5,3};
        ArbitraryFloatingPointNumbers value7 = new ArbitraryFloatingPointNumbers (4, true, a7);
        int[] a8 = new int[] {2,1,7};
        ArbitraryFloatingPointNumbers value8 = new ArbitraryFloatingPointNumbers (3, false, a8);
        ComplexNumber f = new ComplexNumber(value7, value8);
        assertEquals(false, e.equals(e,f));
    }

    /**
     * Testing the toString() method with 4 cases:
     */
    @Test
    public void testToStringComplexNumbers() {
        // Case 1: Test if the complex number to be represented contains a positive real part and positive imaginary part
        int[] a5 = new int[] {2,3,5,1,3};
        ArbitraryFloatingPointNumbers value5 = new ArbitraryFloatingPointNumbers (4, false, a5);
        int[] a6 = new int[] {3,2,1,7,6};
        ArbitraryFloatingPointNumbers value6 = new ArbitraryFloatingPointNumbers (3, false, a6);
        ComplexNumber a = new ComplexNumber(value5, value6);
        assertEquals("3.1532 + 67.123i", a.toString());
        // Case 2: Test if the complex number to be represented contains a negative real part and positive imaginary part
        int[] a1 = new int[] {2,3,5,1,3};
        ArbitraryFloatingPointNumbers value1 = new ArbitraryFloatingPointNumbers (4, true, a1);
        int[] a2 = new int[] {3,2,1,7,6};
        ArbitraryFloatingPointNumbers value2 = new ArbitraryFloatingPointNumbers (3, false, a2);
        ComplexNumber c = new ComplexNumber(value1, value2);
        assertEquals("-3.1532 + 67.123i", c.toString());
        // Case 3: Test if the complex number to be represented contains a positive real part and negative imaginary part
        int[] a3 = new int[] {3,0,0,0,9};
        ArbitraryFloatingPointNumbers value3 = new ArbitraryFloatingPointNumbers (4, false, a3);
        int[] a4 = new int[] {3,9,1,0};
        ArbitraryFloatingPointNumbers value4 = new ArbitraryFloatingPointNumbers (3, true, a4);
        ComplexNumber d = new ComplexNumber(value3, value4);
        assertEquals("9.0003 -0.193i", d.toString());
        // Case 4: Test if the complex number to be represented contains a negative real part and negative imaginary part
        int[] a7 = new int[] {2,3,5,1,3};
        ArbitraryFloatingPointNumbers value7 = new ArbitraryFloatingPointNumbers (4, true, a7);
        int[] a8 = new int[] {3,2,1,7,6};
        ArbitraryFloatingPointNumbers value8 = new ArbitraryFloatingPointNumbers (3, true, a8);
        ComplexNumber b = new ComplexNumber(value7, value8);
        assertEquals("-3.1532 -67.123i", b.toString());
    }

    /**
     * Testing the methods of the Gaussian Integer class
     */

    /**
     * Testing the getRealPart() method with 2 cases:
     */
    @Test
    public void testGetRealPartGaussian() {
        // Case 1: Test if the method correctly returns the real part (which, in this case, is negative) of the gaussian integer
        int[] a1 = new int[] {2,3,5,1,3};
        ArbitraryWholeNumbers value1 = new ArbitraryWholeNumbers (true, a1);
        int[] a2 = new int[] {3,2,1,7,6};
        ArbitraryWholeNumbers value2 = new ArbitraryWholeNumbers (false, a2);
        GaussianInteger g = new GaussianInteger(value1, value2);
        assertEquals(true, g.getRealPart().equals(value1));
        // Case 2: Test if the method correctly returns the real part (which, in this case, is positive) of the gaussian integer
        int[] a3 = new int[] {2,3,5,1,3};
        ArbitraryWholeNumbers value3 = new ArbitraryWholeNumbers (false, a3);
        int[] a4 = new int[] {3,2,1,7,6};
        ArbitraryWholeNumbers value4 = new ArbitraryWholeNumbers (false, a4);
        GaussianInteger c = new GaussianInteger(value3, value4);
        assertEquals(true, c.getRealPart().equals(value3));
    }

    /**
     * Testing the getImaginaryPart() method with 2 cases:
     */
    @Test
    public void testGetImaginaryPartGaussian() {
        // Case 1: Test if the method correctly returns the imaginary part (which, in this case, is positive) of the gaussian integer
        int[] a1 = new int[] {2,3,5,1,3};
        ArbitraryWholeNumbers value1 = new ArbitraryWholeNumbers (true, a1);
        int[] a2 = new int[] {3,2,1,7,6};
        ArbitraryWholeNumbers value2 = new ArbitraryWholeNumbers (false, a2);
        GaussianInteger g = new GaussianInteger(value1, value2);
        assertEquals(true, g.getImaginaryPart().equals(value2));
        // Case 2: Test if the method correctly returns the imaginary part (which, in this case, is negative) of the gaussian integer
        int[] a3 = new int[] {2,3,5,1,3};
        ArbitraryWholeNumbers value3 = new ArbitraryWholeNumbers (true, a3);
        int[] a4 = new int[] {3,2,1,7,6};
        ArbitraryWholeNumbers value4 = new ArbitraryWholeNumbers (true, a4);
        GaussianInteger c = new GaussianInteger(value3, value4);
        assertEquals(true, c.getImaginaryPart().equals(value4));
    }


    /**
     * Testing the add() method with 4 cases:
     */
    @Test
    public void testAddGaussian() {
     /* Case 1: Test if the addition between a gaussian with a positive real part and positive imaginary part and
     another complex number with a positive real part and positive imaginary part */
        int[] a1 = new int[] {2,3,5,1,3};
        ArbitraryWholeNumbers value1 = new ArbitraryWholeNumbers (false, a1);
        int[] a2 = new int[] {3,2,1,7,6};
        ArbitraryWholeNumbers value2 = new ArbitraryWholeNumbers (false, a2);
        GaussianInteger c = new GaussianInteger(value1, value2);
        int[] a3 = new int[] {3,0,0,0,3};
        ArbitraryWholeNumbers value3 = new ArbitraryWholeNumbers (false, a3);
        int[] a4 = new int[] {4,6,9,5};
        ArbitraryWholeNumbers value4 = new ArbitraryWholeNumbers (false, a4);
        GaussianInteger d = new GaussianInteger(value3, value4);
        int[] a5 = new int[] {5,3,5,1,6};
        ArbitraryWholeNumbers value5 = new ArbitraryWholeNumbers (false, a5);
        int[] a6 = new int[] {7,8,0,3,7};
        ArbitraryWholeNumbers value6 = new ArbitraryWholeNumbers (false, a6);
        GaussianInteger e = new GaussianInteger(value5, value6);
        assertEquals(true, ((c.add(d).toString()).equals(e.toString())));
        /* Case 2: Test if the addition between a gaussian with a positive real part and negative imaginary part and
         * another complex number with a positive real part and negative imaginary part */
        int[] a7 = new int[] {2,3,5,1,3};
        ArbitraryWholeNumbers value7 = new ArbitraryWholeNumbers (false, a7);
        int[] a8 = new int[] {3,2,1,7,6};
        ArbitraryWholeNumbers value8 = new ArbitraryWholeNumbers (true, a8);
        GaussianInteger f = new GaussianInteger(value7, value8);
        int[] a9 = new int[] {2,3,5,1,3};
        ArbitraryWholeNumbers value9 = new ArbitraryWholeNumbers (false, a9);
        int[] a10 = new int[] {7,2,0,4};
        ArbitraryWholeNumbers value10 = new ArbitraryWholeNumbers (true, a10);
        GaussianInteger g = new GaussianInteger(value9, value10);
        int[] a11 = new int[] {4,6,0,3,6};
        ArbitraryWholeNumbers value11 = new ArbitraryWholeNumbers (false, a11);
        int[] a12 = new int[] {0,5,1,1,7};
        ArbitraryWholeNumbers value12 = new ArbitraryWholeNumbers (true, a12);
        GaussianInteger h = new GaussianInteger(value11, value12);
        assertEquals(true, ((f.add(g).toString()).equals(h.toString())));
        /* Case 3: Test if the addition between a gaussian with a negative real part and positive imaginary
         * part and another complex number with a negative real part and positive imaginary part */
        int[] a13 = new int[] {7,9,0,2,4};
        ArbitraryWholeNumbers value13 = new ArbitraryWholeNumbers (true, a13);
        int[] a14 = new int[] {9,9,9,9};
        ArbitraryWholeNumbers value14 = new ArbitraryWholeNumbers (false, a14);
        GaussianInteger i = new GaussianInteger(value13, value14);
        int[] a15 = new int[] {2,2,5};
        ArbitraryWholeNumbers value15 = new ArbitraryWholeNumbers (true, a15);
        int[] a16 = new int[] {7,7,7,7,8};
        ArbitraryWholeNumbers value16 = new ArbitraryWholeNumbers (false, a16);
        GaussianInteger j = new GaussianInteger(value15, value16);
        int[] a17 = new int[] {9,1,6,2,4};
        ArbitraryWholeNumbers value17 = new ArbitraryWholeNumbers (true, a17);
        int[] a18 = new int[] {6,7,7,7,9};
        ArbitraryWholeNumbers value18 = new ArbitraryWholeNumbers (false, a18);
        GaussianInteger k = new GaussianInteger(value17, value18);
        assertEquals(true, ((i.add(j).toString()).equals(k.toString())));
        /* Case 4: Test if the addition between a gaussian with a negative real part and negative imaginary part and
         * another complex number with a negative real part and negative imaginary part */
        int[] a19 = new int[] {7,9,0,2,4};
        ArbitraryWholeNumbers value19 = new ArbitraryWholeNumbers (true, a19);
        int[] a20 = new int[] {9,9,9,9};
        ArbitraryWholeNumbers value20 = new ArbitraryWholeNumbers (true, a20);
        GaussianInteger l = new GaussianInteger(value7, value8);
        int[] a21 = new int[] {2,2,5};
        ArbitraryWholeNumbers value21 = new ArbitraryWholeNumbers (true, a21);
        int[] a22 = new int[] {7,7,7,7,8};
        ArbitraryWholeNumbers value22 = new ArbitraryWholeNumbers (true, a22);
        GaussianInteger m = new GaussianInteger(value9, value10);
        int[] a23 = new int[] {9,1,6,2,4};
        ArbitraryWholeNumbers value23 = new ArbitraryWholeNumbers (true, a23);
        int[] a24 = new int[] {6,7,7,7,9};
        ArbitraryWholeNumbers value24 = new ArbitraryWholeNumbers (true, a24);
        GaussianInteger n = new GaussianInteger(value11, value12);
        assertEquals(true, ((l.add(m).toString()).equals(n.toString())));
        // Case 5: Test if adding in hierarchy can produce a correct number
        // Test if adding a gaussian number with an integer number can produce a correct result
        int[] a25 = new int[] {7,9,7,2,7};
        ArbitraryWholeNumbers value25 = new ArbitraryWholeNumbers (false, a25);
        int[] a26 = new int[] {7,9,7,2,7};
        ArbitraryWholeNumbers value26 = new ArbitraryWholeNumbers (false, a26);
        GaussianInteger number = new GaussianInteger (value25, value26);
        IntegerNumber integerNumber = new IntegerNumber (value25);
        int[] a27 = new int[] {4,9,5,5,4,1};
        ArbitraryWholeNumbers value27 = new ArbitraryWholeNumbers (false, a27);
        int[] a28 = new int[] {7,9,7,2,7};
        ArbitraryWholeNumbers value28 = new ArbitraryWholeNumbers (false, a28);
        GaussianInteger number2 = new GaussianInteger (value27, value28);
        assertEquals(true, ((number.add(integerNumber).toString()).equals(number2.toString())));
    }

    /**
     * Case 6 of the add() method testing: Test if the inputs with different signs will throw an Unsupported Operation Exception:
     */
    @Test
    public void testIfGaussianAddMethodThrowsException() {
        int[] a1 = new int[] {7,9,0,2,4};
        ArbitraryWholeNumbers value = new ArbitraryWholeNumbers (true, a1);
        int[] a2 = new int[] {3,1,4};
        ArbitraryWholeNumbers value1 = new ArbitraryWholeNumbers (false, a2);
        GaussianInteger g1 = new GaussianInteger (value, value1);
        int[] a3 = new int[] {7,6,9,0,0};
        ArbitraryWholeNumbers value2 = new ArbitraryWholeNumbers (false, a3);
        int[] a4 = new int[] {6,5};
        ArbitraryWholeNumbers value3 = new ArbitraryWholeNumbers (false, a4);
        GaussianInteger g2 = new GaussianInteger (value2, value3);
        boolean thrown = false;
        try {
            g2.add(g1);
        }
        catch (UnsupportedOperationException e) {
            thrown = true;
        }
        assertTrue(thrown);
    }

    /**
     * Testing the toString() method with 4 cases:
     */
    @Test
    public void testToStringGaussian() {
        // Case 1: Test if the complex number to be represented contains a positive real part and positive imaginary part
        int[] a5 = new int[] {2,3,5,1,3};
        ArbitraryWholeNumbers value5 = new ArbitraryWholeNumbers (false, a5);
        int[] a6 = new int[] {3,2,1,7,6};
        ArbitraryWholeNumbers value6 = new ArbitraryWholeNumbers (false, a6);
        GaussianInteger a = new GaussianInteger(value5, value6);
        assertEquals("31532 + 67123i", a.toString());
        // Case 2: Test if the complex number to be represented contains a negative real part and positive imaginary part
        int[] a1 = new int[] {2,3,5,1,3};
        ArbitraryWholeNumbers value1 = new ArbitraryWholeNumbers (true, a1);
        int[] a2 = new int[] {3,2,1,7,6};
        ArbitraryWholeNumbers value2 = new ArbitraryWholeNumbers (false, a2);
        GaussianInteger c = new GaussianInteger(value1, value2);
        assertEquals("-31532 + 67123i", c.toString());
        // Case 3: Test if the complex number to be represented contains a positive real part and negative imaginary part
        int[] a3 = new int[] {3,0,0,0,9};
        ArbitraryWholeNumbers value3 = new ArbitraryWholeNumbers (false, a3);
        int[] a4 = new int[] {3,9,1,0};
        ArbitraryWholeNumbers value4 = new ArbitraryWholeNumbers (true, a4);
        GaussianInteger d = new GaussianInteger(value3, value4);
        assertEquals("90003 -193i", d.toString());
        // Case 4: Test if the complex number to be represented contains a negative real part and negative imaginary part
        int[] a7 = new int[] {2,3,5,1,3};
        ArbitraryWholeNumbers value7 = new ArbitraryWholeNumbers (true, a7);
        int[] a8 = new int[] {3,2,1,7,6};
        ArbitraryWholeNumbers value8 = new ArbitraryWholeNumbers (true, a8);
        GaussianInteger b = new GaussianInteger(value7, value8);
        assertEquals("-31532 -67123i", b.toString());
    }

    /**
     * Testing the equals() method with 2 cases:
     */
    @Test
    public void testEqualsGaussian() {
        // Case 1: Test if this gaussian integers and the number to be compared is equal
        int[] a1 = new int[] {2,3,5,1,3};
        ArbitraryWholeNumbers value1 = new ArbitraryWholeNumbers (true, a1);
        int[] a2 = new int[] {3,2,1,7,6};
        ArbitraryWholeNumbers value2 = new ArbitraryWholeNumbers (false, a2);
        GaussianInteger c = new GaussianInteger(value1, value2);
        int[] a3 = new int[] {2,3,5,1,3};
        ArbitraryWholeNumbers value3 = new ArbitraryWholeNumbers (true, a3);
        int[] a4 = new int[] {3,2,1,7,6};
        ArbitraryWholeNumbers value4 = new ArbitraryWholeNumbers (false, a4);
        GaussianInteger d = new GaussianInteger(value3, value4);
        assertEquals(true, c.equals(c,d));
        // Case 2: Test if this gaussian integers and the number to be compared is not equal
        int[] a5 = new int[] {2,3,5,1,3};
        ArbitraryWholeNumbers value5 = new ArbitraryWholeNumbers (true, a5);
        int[] a6 = new int[] {3,2,1,7};
        ArbitraryWholeNumbers value6 = new ArbitraryWholeNumbers (false, a6);
        GaussianInteger e = new GaussianInteger(value5, value6);
        int[] a7 = new int[] {2,3,5,3};
        ArbitraryWholeNumbers value7 = new ArbitraryWholeNumbers (true, a7);
        int[] a8 = new int[] {2,1,7};
        ArbitraryWholeNumbers value8 = new ArbitraryWholeNumbers (false, a8);
        GaussianInteger f = new GaussianInteger(value7, value8);
        assertEquals(false, e.equals(e,f));
    }

/**
 * Testing the RealNumber class:
 */

    /**
     * Testing the getNumber() method with 2 cases:
     */
    @Test
    public void testGetNumberRealNumber() {
        // Case 1: Test if the method correctly returns the number (which, in this case, is negative)
        int[] a1 = new int[] {2,3,5,1,3};
        ArbitraryWholeNumbers value1 = new ArbitraryWholeNumbers (true, a1);
        RealNumber g = new RealNumber(value1);
        assertEquals(true, g.getNumber().equals(value1));
        // Case 2: Test if the method correctly returns the number (which, in this case, is positive)
        int[] a3 = new int[] {2,3,5,1,3};
        ArbitraryWholeNumbers value3 = new ArbitraryWholeNumbers (false, a3);
        RealNumber c = new RealNumber(value3);
        assertEquals(true, c.getNumber().equals(value3));
    }

    /**
     * Testing the getRealPart() method with 2 cases:
     */
    @Test
    public void testGetRealPartRealNumber() {
        // Case 1: Test if the method correctly returns the number itself (which, in this case, is positive):
        int[] a1 = new int[] {2,3,5,1,3};
        ArbitraryWholeNumbers value1 = new ArbitraryWholeNumbers (true, a1);
        RealNumber g = new RealNumber(value1);
        assertEquals(true, g.getRealPart().equals(value1));
        // Case 2: Test if the method correctly returns the number itself (which, in this case, is negative):
        int[] a3 = new int[] {2,3,5,1,3};
        ArbitraryWholeNumbers value3 = new ArbitraryWholeNumbers (false, a3);
        RealNumber c = new RealNumber(value3);
        assertEquals(true, c.getRealPart().equals(value3));
    }

    /**
     * Testing the getImaginaryPart() method with 1 case:
     */
    @Test
    public void testGetImaginaryPartRealNumber() {
        // Case 1: Test if the method correctly returns the number of 0, as a real number cannot have any imaginary part:
        int[] a1 = new int[] {2,3,5,1,3};
        ArbitraryWholeNumbers value1 = new ArbitraryWholeNumbers (true, a1);
        ArbitraryWholeNumbers value2 = new ArbitraryWholeNumbers (false, new int[] {0});
        RealNumber g = new RealNumber(value1);
        assertEquals(true, g.getImaginaryPart().equals(value2));
    }

    /**
     * Testing the add() method with 2 cases:
     */
    @Test
    public void testAddRealNumber() {
        /* Case 1: Test if the addition of a positive real number and a positive real number yields the correct result */
        int[] a1 = new int[] {2,3,5,1,3};
        ArbitraryFloatingPointNumbers value1 = new ArbitraryFloatingPointNumbers (false, a1);
        RealNumber c = new RealNumber(value1);
        int[] a2 = new int[] {3,2,1,7,6};
        ArbitraryFloatingPointNumbers value2 = new ArbitraryFloatingPointNumbers (false, a2);
        RealNumber d = new RealNumber(value2);
        int[] a3 = new int[] {5,5,6,8,9};
        ArbitraryFloatingPointNumbers value3 = new ArbitraryFloatingPointNumbers (false, a3);
        RealNumber e = new RealNumber(value3);
        assertEquals(true, ((c.add(d).toString()).equals(e.toString())));
        /* Case 2: Test if the addition of a negative real number and a negative real number yields the correct result */
        int[] a4 = new int[] {2,3,5,1,3};
        ArbitraryFloatingPointNumbers value4 = new ArbitraryFloatingPointNumbers (true, a4);
        RealNumber l = new RealNumber(value4);
        int[] a5 = new int[] {3,2,1,7,6};
        ArbitraryFloatingPointNumbers value5 = new ArbitraryFloatingPointNumbers (true, a5);
        RealNumber m = new RealNumber(value5);
        int[] a6 = new int[] {5,5,6,8,9};
        ArbitraryFloatingPointNumbers value6 = new ArbitraryFloatingPointNumbers (true, a6);
        RealNumber n = new RealNumber(value6);
        assertEquals(true, ((l.add(m).toString()).equals(n.toString())));
        // Case 3: Test if adding in hierarchy can produce a correct number
        // Test if adding a real number with an integer number can produce a correct result
        int[] a25 = new int[] {7,9,7,2,7};
        ArbitraryWholeNumbers value25 = new ArbitraryWholeNumbers (false, a25);
        int[] a26 = new int[] {7,9,7,2,7};
        ArbitraryWholeNumbers value26 = new ArbitraryWholeNumbers (false, a26);
        RealNumber number = new RealNumber (value25);
        IntegerNumber integerNumber = new IntegerNumber (value26);
        int[] a27 = new int[] {4,9,5,5,4,1};
        ArbitraryFloatingPointNumbers value27 = new ArbitraryFloatingPointNumbers (false, a27);
        RealNumber number2 = new RealNumber (value27);
        assertEquals(true, ((number.add(integerNumber).toString()).equals(number2.toString())));
    }

    /**
     * Case 4 of the add() method testing: Test if the inputs with different signs will throw an Unsupported Operation Exception:
     */
    @Test
    public void testIfAddRealNumberThrowsException() {
        int[] a1 = new int[] {7,9,0,2,4};
        ArbitraryWholeNumbers value = new ArbitraryWholeNumbers (true, a1);
        RealNumber r = new RealNumber (value);
        int[] a2 = new int[] {3,1,4};
        ArbitraryWholeNumbers value1 = new ArbitraryWholeNumbers (false, a2);
        RealNumber r1 = new RealNumber (value1);
        boolean thrown = false;
        try {
            r1.add(r);
        }
        catch (UnsupportedOperationException e) {
            thrown = true;
        }
        assertTrue(thrown);
    }

    /**
     * Testing the equals() method with 2 cases:
     */
    @Test
    public void testEqualsRealNumber() {
        // Case 1: Test if two real numbers to be compared are equal to each other:
        int[] a1 = new int[] {2,3,5,1,3};
        ArbitraryFloatingPointNumbers value1 = new ArbitraryFloatingPointNumbers (false, a1);
        RealNumber c = new RealNumber(value1);
        int[] a2 = new int[] {2,3,5,1,3};
        ArbitraryFloatingPointNumbers value2 = new ArbitraryFloatingPointNumbers (false, a2);
        RealNumber d = new RealNumber(value2);
        assertEquals(true, (c.equals(c,d)));
        // Case 2: Test if two real numbers to be compared are NOT equal to each other:
        int[] a4 = new int[] {2,3,5,1,3};
        ArbitraryFloatingPointNumbers value4 = new ArbitraryFloatingPointNumbers (false, a4);
        RealNumber l = new RealNumber(value4);
        int[] a5 = new int[] {3,2,1,7,6};
        ArbitraryFloatingPointNumbers value5 = new ArbitraryFloatingPointNumbers (true, a5);
        RealNumber m = new RealNumber(value5);
        assertEquals(false, (l.equals(l,m)));
    }

    /**
     * Testing the toString() method with 2 cases:
     */
    @Test
    public void testToStringRealNumber() {
        // Case 1: Test if the real number to be represented is negative:
        int[] a1 = new int[] {2,3,5,1,3};
        ArbitraryFloatingPointNumbers value1 = new ArbitraryFloatingPointNumbers (true, a1);
        RealNumber c = new RealNumber(value1);
        assertEquals("-31532.", (c.toString()));
        // Case 2: Test if the real number to be represented is positive:
        int[] a4 = new int[] {2,3,5,1,3};
        ArbitraryFloatingPointNumbers value4 = new ArbitraryFloatingPointNumbers (false, a4);
        RealNumber l = new RealNumber(value4);
        assertEquals("31532.", (l.toString()));
    }

    /**
     * Testing methods of class RationalNumber:
     */

    /**
     * Testing the getNumerator() method with 2 cases:
     */
    @Test
    public void testGetNumeratorRational() {
        // Case 1: Test if the method correctly returns the real part (which, in this case, is positive) of the gaussian integer
        int[] a1 = new int[] {2,3,5,1,3};
        ArbitraryWholeNumbers value1 = new ArbitraryWholeNumbers (false, a1);
        int[] a2 = new int[] {3,2,1,7,6};
        ArbitraryWholeNumbers value2 = new ArbitraryWholeNumbers (false, a2);
        RationalNumber g = new RationalNumber(value1, value2);
        assertEquals(true, g.getNumerator().equals(value1));
        // Case 2: Test if the method correctly returns the real part (which, in this case, is positive) of the gaussian integer
        int[] a3 = new int[] {2,3,5,1,3};
        ArbitraryWholeNumbers value3 = new ArbitraryWholeNumbers (true, a3);
        int[] a4 = new int[] {3,2,1,7,6};
        ArbitraryWholeNumbers value4 = new ArbitraryWholeNumbers (false, a4);
        RationalNumber c = new RationalNumber(value3, value4);
        assertEquals(true, c.getNumerator().equals(value3));
    }

    /**
     * Testing the getDenominator() method with 2 cases:
     */
    @Test
    public void testGetDenominatorRational() {
        // Case 1: Test if the method correctly returns the denominator of the rational number (which, in this case, is positive)
        int[] a1 = new int[] {2,3,5,1,3};
        ArbitraryWholeNumbers value1 = new ArbitraryWholeNumbers (false, a1);
        int[] a2 = new int[] {3,2,1,7,6};
        ArbitraryWholeNumbers value2 = new ArbitraryWholeNumbers (false, a2);
        RationalNumber g = new RationalNumber(value1, value2);
        assertEquals(true, g.getDenominator().equals(value2));
        // Case 2: Test if the method correctly returns the denominator of the rational number (which, in this case, is negative)
        int[] a3 = new int[] {2,3,5,1,3};
        ArbitraryWholeNumbers value3 = new ArbitraryWholeNumbers (true, a3);
        int[] a4 = new int[] {3,2,1,7,6};
        ArbitraryWholeNumbers value4 = new ArbitraryWholeNumbers (false, a4);
        RationalNumber c = new RationalNumber(value3, value4);
        assertEquals(true, c.getDenominator().equals(value4));
    }

    /**
     * Testing the inherited getNumber() method with 2 cases:
     */
    @Test
    public void testGetNumberRational() {
        // Case 1: Test if the method correctly returns the number of the rational number (which, in this case, is positive.)
        int[] a1 = new int[] {2,3,5,1,3};
        ArbitraryWholeNumbers value1 = new ArbitraryWholeNumbers (false, a1);
        int[] a2 = new int[] {3,2,1,7,6};
        ArbitraryWholeNumbers value2 = new ArbitraryWholeNumbers (false, a2);
        RationalNumber g = new RationalNumber(value1, value2);
        assertEquals(true, g.getNumber().equals(value1));
        // Case 2: Test if the method correctly returns the number of the rational number (which, in this case, is negative.)
        int[] a3 = new int[] {2,3,5,1,3};
        ArbitraryWholeNumbers value3 = new ArbitraryWholeNumbers (true, a3);
        int[] a4 = new int[] {3,2,1,7,6};
        ArbitraryWholeNumbers value4 = new ArbitraryWholeNumbers (false, a4);
        RationalNumber c = new RationalNumber(value3, value4);
        assertEquals(true, c.getNumber().equals(value3));
    }

    /**
     * Testing the inherited getNumber() method with 2 cases:
     */
    @Test
    public void testGetRealPartRational() {
        // Case 1: Test if the method correctly returns the number of the rational number (which, in this case, is positive.)
        int[] a1 = new int[] {2,3,5,1,3};
        ArbitraryWholeNumbers value1 = new ArbitraryWholeNumbers (false, a1);
        int[] a2 = new int[] {3,2,1,7,6};
        ArbitraryWholeNumbers value2 = new ArbitraryWholeNumbers (false, a2);
        RationalNumber g = new RationalNumber(value1, value2);
        assertEquals(true, g.getRealPart().equals(value1));
        // Case 2: Test if the method correctly returns the number of the rational number (which, in this case, is negative.)
        int[] a3 = new int[] {2,3,5,1,3};
        ArbitraryWholeNumbers value3 = new ArbitraryWholeNumbers (true, a3);
        int[] a4 = new int[] {3,2,1,7,6};
        ArbitraryWholeNumbers value4 = new ArbitraryWholeNumbers (false, a4);
        RationalNumber c = new RationalNumber(value3, value4);
        assertEquals(true, c.getRealPart().equals(value3));
    }

    /**
     * Testing the inherited getNumber() method with 1 case:
     */
    @Test
    public void testGetImaginaryPartRational() {
        // Case 1: Test if the method correctly returns the number of 0, as a natural number cannot have any imaginary part
        int[] a1 = new int[] {2,3,5,1,3};
        ArbitraryWholeNumbers value1 = new ArbitraryWholeNumbers (false, a1);
        int[] a2 = new int[] {3,2,1,7,6};
        ArbitraryWholeNumbers value2 = new ArbitraryWholeNumbers (false, a2);
        ArbitraryWholeNumbers value3 = new ArbitraryWholeNumbers (false, new int[] {0});
        RationalNumber g = new RationalNumber(value1, value2);
        assertEquals(true, g.getImaginaryPart().equals(value3));
    }

    /**
     * Testing the add() method with 2 cases:
     */
    @Test
    public void testAddRational() {
        /* Case 1: Test if the addition between two rational numbers with positive numerators and same denominators
         * can yield correct answers */
        int[] a1 = new int[] {2,3,5,1,3};
        ArbitraryWholeNumbers value1 = new ArbitraryWholeNumbers (false, a1);
        int[] a2 = new int[] {3,2,1,7,6};
        ArbitraryWholeNumbers value2 = new ArbitraryWholeNumbers (false, a2);
        RationalNumber g = new RationalNumber(value1, value2);
        int[] a3 = new int[] {9,2,1,9,4};
        ArbitraryWholeNumbers value3 = new ArbitraryWholeNumbers (false, a3);
        int[] a4 = new int[] {3,2,1,7,6};
        ArbitraryWholeNumbers value4 = new ArbitraryWholeNumbers (false, a4);
        RationalNumber e = new RationalNumber(value3, value4);
        int[] a5 = new int[] {1,6,6,0,8};
        ArbitraryWholeNumbers value5 = new ArbitraryWholeNumbers (false, a5);
        int[] a6 = new int[] {3,2,1,7,6};
        ArbitraryWholeNumbers value6 = new ArbitraryWholeNumbers (false, a6);
        RationalNumber f = new RationalNumber(value5, value6);
        assertEquals(true, (g.add(e).toString()).equals(f.toString()));
        /* Case 2: Test if the addition between two rational numbers with negative numerators and same denominators can
         * yield correct answers */
        int[] a7 = new int[] {2,3,5,1,3};
        ArbitraryWholeNumbers value7 = new ArbitraryWholeNumbers (true, a7);
        int[] a8 = new int[] {3,2,1,7,6};
        ArbitraryWholeNumbers value8 = new ArbitraryWholeNumbers (false, a8);
        RationalNumber l = new RationalNumber(value7, value8);
        int[] a9 = new int[] {9,2,1,9,4};
        ArbitraryWholeNumbers value9 = new ArbitraryWholeNumbers (true, a9);
        int[] a10 = new int[] {3,2,1,7,6};
        ArbitraryWholeNumbers value10 = new ArbitraryWholeNumbers (false, a10);
        RationalNumber m = new RationalNumber(value9, value10);
        int[] a11 = new int[] {1,6,6,0,8};
        ArbitraryWholeNumbers value11 = new ArbitraryWholeNumbers (true, a11);
        int[] a12 = new int[] {3,2,1,7,6};
        ArbitraryWholeNumbers value12 = new ArbitraryWholeNumbers (false, a12);
        RationalNumber n = new RationalNumber(value11, value12);
        assertEquals(true, (l.add(m).toString()).equals(n.toString()));
    }

    /**
     * Case 3 of the add() method testing: Test if the inputs with different signs will throw an Unsupported Operation Exception:
     */
    @Test
    public void testIfAddRationalThrowsException() {
        int[] a1 = new int[] {7,9,0,2,4};
        ArbitraryWholeNumbers value = new ArbitraryWholeNumbers (true, a1);
        int[] a2 = new int[] {3,1,4};
        ArbitraryWholeNumbers value1 = new ArbitraryWholeNumbers (false, a2);
        RationalNumber r1 = new RationalNumber (value, value1);
        int[] a3 = new int[] {4,1,5};
        ArbitraryWholeNumbers value2 = new ArbitraryWholeNumbers (false, a3);
        int[] a4 = new int[] {4,5};
        ArbitraryWholeNumbers value3 = new ArbitraryWholeNumbers (true, a4);
        RationalNumber r2 = new RationalNumber (value2, value3);
        boolean thrown = false;
        try {
            r1.add(r2);
        }
        catch (UnsupportedOperationException e) {
            thrown = true;
        }
        assertTrue(thrown);
    }


    /**
     * Testing the equals() method with 2 cases:
     */
    @Test
    public void testEqualsRational() {
        /* Case 1: Test if the two rational numbers to be compared have the same numerators and denominators */
        int[] a1 = new int[] {2,3,5,1,3};
        ArbitraryWholeNumbers value1 = new ArbitraryWholeNumbers (false, a1);
        int[] a2 = new int[] {3,2,1,7,6};
        ArbitraryWholeNumbers value2 = new ArbitraryWholeNumbers (false, a2);
        RationalNumber g = new RationalNumber(value1, value2);
        int[] a3 = new int[] {2,3,5,1,3};
        ArbitraryWholeNumbers value3 = new ArbitraryWholeNumbers (false, a3);
        int[] a4 = new int[] {3,2,1,7,6};
        ArbitraryWholeNumbers value4 = new ArbitraryWholeNumbers (false, a4);
        RationalNumber e = new RationalNumber(value3, value4);
        assertEquals(true, g.equals(e,g));
        /* Case 2: Test if the two rational numbers to be compared have different numerators and denominators */
        int[] a7 = new int[] {2,3,5,1,3};
        ArbitraryWholeNumbers value7 = new ArbitraryWholeNumbers (true, a7);
        int[] a8 = new int[] {3,2,1,7,6};
        ArbitraryWholeNumbers value8 = new ArbitraryWholeNumbers (false, a8);
        RationalNumber l = new RationalNumber(value7, value8);
        int[] a9 = new int[] {9,2,1,9,4};
        ArbitraryWholeNumbers value9 = new ArbitraryWholeNumbers (true, a9);
        int[] a10 = new int[] {3,2,1,7,6};
        ArbitraryWholeNumbers value10 = new ArbitraryWholeNumbers (false, a10);
        RationalNumber m = new RationalNumber(value9, value10);
        assertEquals(false, l.equals(l,m));
    }

    /**
     * Testing the toString() method with 4 cases:
     */
    @Test
    public void testToStringRational() {
        /* Case 1: Test if the rational number to be represented have positive numerator and positive denominator */
        int[] a1 = new int[] {2,3,5,1,3};
        ArbitraryWholeNumbers value1 = new ArbitraryWholeNumbers (false, a1);
        int[] a2 = new int[] {3,2,1,7,6};
        ArbitraryWholeNumbers value2 = new ArbitraryWholeNumbers (false, a2);
        RationalNumber g = new RationalNumber(value1, value2);
        assertEquals("31532 / 67123", g.toString());
        /* Case 2: Test if the rational number to be represented have positive numerator and negative denominator */
        int[] a7 = new int[] {2,3,5,1,3};
        ArbitraryWholeNumbers value7 = new ArbitraryWholeNumbers (false, a7);
        int[] a8 = new int[] {3,2,1,7,6};
        ArbitraryWholeNumbers value8 = new ArbitraryWholeNumbers (true, a8);
        RationalNumber l = new RationalNumber(value7, value8);
        assertEquals("31532 / -67123", l.toString());
        // Case 3: Test if the rational number to be represented have negative numerator and positive denominator
        int[] a3 = new int[] {2,3,5,1,3};
        ArbitraryWholeNumbers value3 = new ArbitraryWholeNumbers (true, a3);
        int[] a4 = new int[] {3,2,1,7,6};
        ArbitraryWholeNumbers value4 = new ArbitraryWholeNumbers (false, a4);
        RationalNumber m = new RationalNumber(value3, value4);
        assertEquals("-31532 / 67123", m.toString());
        // Case 4: Test if the rational number to be represented have negative numerator and negative denominator
        int[] a5 = new int[] {2,3,5,1,3};
        ArbitraryWholeNumbers value5 = new ArbitraryWholeNumbers (true, a5);
        int[] a6 = new int[] {3,2,1,7,6};
        ArbitraryWholeNumbers value6 = new ArbitraryWholeNumbers (true, a6);
        RationalNumber n = new RationalNumber(value5, value6);
        assertEquals("-31532 / -67123", n.toString());
    }

    /**
     * Testing methods of class IntegerNumber:
     */

    /**
     * Testing the getNumber() method with 2 cases:
     */
    @Test
    public void testGetNumberInteger() {
        // Case 1: Test if the method correctly returns the number (which, in this case, is negative)
        int[] a1 = new int[] {2,3,5,1,3};
        ArbitraryWholeNumbers value1 = new ArbitraryWholeNumbers (true, a1);
        IntegerNumber g = new IntegerNumber(value1);
        assertEquals(true, g.getNumber().equals(value1));
        // Case 2: Test if the method correctly returns the number (which, in this case, is positive)
        int[] a3 = new int[] {2,3,5,1,3};
        ArbitraryWholeNumbers value3 = new ArbitraryWholeNumbers (false, a3);
        IntegerNumber c = new IntegerNumber(value3);
        assertEquals(true, c.getNumber().equals(value3));
    }

    /**
     * Testing the getRealPart() method with 2 cases:
     */
    @Test
    public void testGetRealPartInteger() {
        // Case 1: Test if the method correctly returns the number itself (which, in this case, is positive)
        int[] a1 = new int[] {2,3,5,1,3};
        ArbitraryWholeNumbers value1 = new ArbitraryWholeNumbers (true, a1);
        IntegerNumber g = new IntegerNumber(value1);
        assertEquals(true, g.getRealPart().equals(value1));
        // Case 2: Test if the method correctly returns the number itself (which, in this case, is negative)
        int[] a3 = new int[] {2,3,5,1,3};
        ArbitraryWholeNumbers value3 = new ArbitraryWholeNumbers (false, a3);
        IntegerNumber c = new IntegerNumber(value3);
        assertEquals(true, c.getRealPart().equals(value3));
    }

    /**
     * Testing the getImaginaryPart() method with 1 case:
     */
    @Test
    public void testGetImaginaryPartInteger() {
        /* Case 1: Test if the method correctly returns the denominator of an integer, which should be 1
         * (assuming it needs to be 1 so that an integer can be correctly represented by 1 arbitrary whole number) */
        int[] a1 = new int[] {2,3,5,1,3};
        ArbitraryWholeNumbers value1 = new ArbitraryWholeNumbers (false, a1);
        IntegerNumber g = new IntegerNumber(value1);
        ArbitraryWholeNumbers value2 = new ArbitraryWholeNumbers (false, new int[] {0});
        assertEquals(true, (g.getImaginaryPart().toString()).equals(value2.toString()));
    }

    /**
     * Testing the getNumerator() method with 2 cases:
     */
    @Test
    public void testGetNumeratorInteger() {
        // Case 1: Test if the method correctly returns the numerator of a positive integer, which is the number itself
        int[] a1 = new int[] {2,3,5,1,3};
        ArbitraryWholeNumbers value1 = new ArbitraryWholeNumbers (true, a1);
        IntegerNumber g = new IntegerNumber(value1);
        assertEquals(true, g.getNumerator().equals(value1));
        // Case 2: Test if the method correctly returns the numerator of a negative integer, which is the number itself
        int[] a3 = new int[] {2,3,5,1,3};
        ArbitraryWholeNumbers value3 = new ArbitraryWholeNumbers (false, a3);
        IntegerNumber c = new IntegerNumber(value3);
        assertEquals(true, c.getNumerator().equals(value3));
    }

    /**
     * Testing the getDenominator() method with 1 case:
     */
    @Test
    public void testGetDenominatorInteger() {
        /* Case 1: Test if the method correctly returns the denominator of an integer, which should be 1
         * (assuming it needs to be 1 so that an integer can be correctly represented by 1 arbitrary whole number) */
        int[] a1 = new int[] {2,3,5,1,3};
        ArbitraryWholeNumbers value1 = new ArbitraryWholeNumbers (false, a1);
        IntegerNumber g = new IntegerNumber(value1);
        ArbitraryWholeNumbers value2 = new ArbitraryWholeNumbers (false, new int[] {1});
        assertEquals(true, (g.getDenominator().toString()).equals(value2.toString()));
    }

    /**
     * Testing the add() method with 2 cases:
     */
    @Test
    public void testAddInteger() {
        // Case 1: Test if the addition of a positive integer number and a positive integer number yields the correct result
        int[] a1 = new int[] {2,3,5,1,3};
        ArbitraryWholeNumbers value1 = new ArbitraryWholeNumbers (false, a1);
        IntegerNumber g = new IntegerNumber(value1);
        int[] a2 = new int[] {3,2,1,7,6};
        ArbitraryWholeNumbers value2 = new ArbitraryWholeNumbers (false, a2);
        IntegerNumber f = new IntegerNumber(value2);
        int[] a3 = new int[] {5,5,6,8,9};
        ArbitraryWholeNumbers value3 = new ArbitraryWholeNumbers (false, a3);
        IntegerNumber c = new IntegerNumber(value3);
        assertEquals(true, (g.add(f,g).toString()).equals(c.toString()));
        // Case 2: Test if the addition of a negative integer number and a negative integer number yields the correct result
        int[] a4 = new int[] {2,3,5,1,3};
        ArbitraryWholeNumbers value4 = new ArbitraryWholeNumbers (true, a4);
        IntegerNumber k = new IntegerNumber(value4);
        int[] a5 = new int[] {3,2,1,7,6};
        ArbitraryWholeNumbers value5 = new ArbitraryWholeNumbers (true, a5);
        IntegerNumber l = new IntegerNumber(value5);
        int[] a6 = new int[] {5,5,6,8,9};
        ArbitraryWholeNumbers value6 = new ArbitraryWholeNumbers (true, a6);
        IntegerNumber m = new IntegerNumber(value6);
        assertEquals(true, (k.add(k,l).toString()).equals(m.toString()));
        // Case 3: Test if adding in hierarchy can produce a correct number
        // Test if adding a real number with an integer number can produce a correct result
        int[] a25 = new int[] {7,9,7,2,7};
        ArbitraryWholeNumbers value25 = new ArbitraryWholeNumbers (false, a25);
        int[] a26 = new int[] {7,9,7,2,7};
        ArbitraryWholeNumbers value26 = new ArbitraryWholeNumbers (false, a26);
        IntegerNumber number = new IntegerNumber (value25);
        NaturalNumber number2 = new NaturalNumber (value26);
        int[] a27 = new int[] {4,9,5,5,4,1};
        ArbitraryWholeNumbers value27 = new ArbitraryWholeNumbers (false, a27);
        IntegerNumber number3 = new IntegerNumber (value27);
        assertEquals(true, ((number.add(number, number2).toString()).equals(number3.toString())));
    }

    /**
     * Case 4 of the add() method testing: Test if the inputs with different signs will throw an Unsupported Operation Exception:
     */
    @Test
    public void testIfAddIntegersThrowsException() {
        int[] a1 = new int[] {7,9,0,2,4};
        ArbitraryWholeNumbers value = new ArbitraryWholeNumbers (true, a1);
        IntegerNumber i1 = new IntegerNumber (value);
        int[] a2 = new int[] {3,1,4};
        ArbitraryWholeNumbers value1 = new ArbitraryWholeNumbers (false, a2);
        IntegerNumber i2 = new IntegerNumber (value1);
        boolean thrown = false;
        try {
            i1.add(i1,i2);
        }
        catch (UnsupportedOperationException e) {
            thrown = true;
        }
        assertTrue(thrown);
    }

    /**
     * Testing the equals() method with 2 cases:
     */
    @Test
    public void testEqualsInteger() {
        // Case 1: Test if two integer numbers to be compared are equal to each other:
        int[] a1 = new int[] {2,3,5,1,3};
        ArbitraryWholeNumbers value1 = new ArbitraryWholeNumbers (false, a1);
        IntegerNumber g = new IntegerNumber(value1);
        int[] a2 = new int[] {2,3,5,1,3};
        ArbitraryWholeNumbers value2 = new ArbitraryWholeNumbers (false, a2);
        IntegerNumber f = new IntegerNumber(value2);
        assertEquals(true, g.equals(f, g));
        // Case 2: Test if two integer numbers to be compared are NOT equal to each other
        int[] a3 = new int[] {2,3,5,1,3};
        ArbitraryWholeNumbers value3 = new ArbitraryWholeNumbers (false, a3);
        IntegerNumber l = new IntegerNumber(value3);
        int[] a4 = new int[] {5,5,6,8,9};
        ArbitraryWholeNumbers value4 = new ArbitraryWholeNumbers (false, a4);
        IntegerNumber m = new IntegerNumber(value4);
        assertEquals(false, l.equals(m, l));
    }

    /**
     * Testing the toString() method with 2 cases:
     */
    @Test
    public void testToStringInteger() {
        // Case 1: Test if the integer number to be represented is negative
        int[] a1 = new int[] {2,3,5,1,3};
        ArbitraryWholeNumbers value1 = new ArbitraryWholeNumbers (false, a1);
        IntegerNumber g = new IntegerNumber(value1);
        assertEquals("31532", g.toString());
        // Case 2: Test if the integer number to be represented is positive
        int[] a3 = new int[] {2,3,5,1,3};
        ArbitraryWholeNumbers value3 = new ArbitraryWholeNumbers (true, a3);
        IntegerNumber l = new IntegerNumber(value3);
        assertEquals("-31532", l.toString());
    }

/**
 * Testing the NaturalNumber class:
 * Note: A natural number cannot be negative, therefore test cases involving negative natural number inputs
 * will not be included.
 */

    /**
     * Testing if the constructor of the NaturalNumber class will throw an exception when the input is negative:
     * The constructor should be able to construct an instance of the class when the given ArbitraryWholeNumber input
     * is positive. HOWEVER, it will throw an exception if the given input is negative, as a natural number cannot be
     * negative.
     */
    @Test
    public void testNaturalNumberConstructor() {
        int[] a1 = new int[] {1,4};
        ArbitraryWholeNumbers value = new ArbitraryWholeNumbers (true, a1);
        boolean thrown = false;
        try {
            NaturalNumber n = new NaturalNumber (value);
        }
        catch (UnsupportedOperationException e) {
            thrown = true;
        }
        assertTrue(thrown);
    }


    /**
     * Testing the getNumber() method with 2 cases:
     */
    @Test
    public void testGetNumberNatural() {
        // Case 1: Test if the method correctly returns the natural number
        int[] a1 = new int[] {1,4};
        ArbitraryWholeNumbers value1 = new ArbitraryWholeNumbers (false, a1);
        NaturalNumber g = new NaturalNumber(value1);
        assertEquals(true, g.getNumber().equals(value1));
    }

    /**
     * Testing the getRealPart() method with 2 cases:
     */
    @Test
    public void testGetRealPartNatural() {
        // Case 1: Test if the method correctly returns the number itself
        int[] a1 = new int[] {1,4};
        ArbitraryWholeNumbers value1 = new ArbitraryWholeNumbers (false, a1);
        NaturalNumber g = new NaturalNumber(value1);
        assertEquals(true, g.getRealPart().equals(value1));
    }

    /**
     * Testing the getImaginaryPart() method with 1 case:
     */
    @Test
    public void testGetImaginaryPartNatural() {
        /* Case 1: Test if the method correctly returns the denominator of a natural number, which should be 1
         * (assuming it needs to be 1 so that an integer can be correctly represented by 1 arbitrary whole number) */
        int[] a1 = new int[] {1,4};
        ArbitraryWholeNumbers value1 = new ArbitraryWholeNumbers (false, a1);
        NaturalNumber g = new NaturalNumber(value1);
        ArbitraryWholeNumbers value2 = new ArbitraryWholeNumbers (false, new int[] {0});
        assertEquals(true, (g.getImaginaryPart().toString()).equals(value2.toString()));
    }

    /**
     * Testing the getNumerator() method with 2 cases:
     */
    @Test
    public void testGetNumeratorNatural() {
        // Case 1: Test if the method correctly returns the numerator of a positive integer, which is the number itself
        int[] a1 = new int[] {1,4};
        ArbitraryWholeNumbers value1 = new ArbitraryWholeNumbers (false, a1);
        NaturalNumber g = new NaturalNumber(value1);
        assertEquals(true, g.getNumerator().equals(value1));
    }

    /**
     * Testing the getDenominator() method with 1 case:
     */
    public void testGetDenominatorNatural() {
        /* Case 1: Test if the method correctly returns the denominator of an integer, which should be 1
         * (assuming it needs to be 1 so that an integer can be correctly represented by 1 arbitrary whole number) */
        int[] a1 = new int[] {1,4};
        ArbitraryWholeNumbers value1 = new ArbitraryWholeNumbers (false, a1);
        NaturalNumber g = new NaturalNumber(value1);
        ArbitraryWholeNumbers value2 = new ArbitraryWholeNumbers (false, new int[] {1});
        assertEquals(true, (g.getDenominator().toString()).equals(value2.toString()));
    }

    /**
     * Testing the add() method with 2 cases:
     */
    @Test
    public void testAddNatural() {
        // Case 1: Test if the addition of a positive integer number and a positive natural number yields the correct result
        int[] a1 = new int[] {1,4};
        ArbitraryWholeNumbers value1 = new ArbitraryWholeNumbers (false, a1);
        NaturalNumber g = new NaturalNumber(value1);
        int[] a2 = new int[] {1,4};
        ArbitraryWholeNumbers value2 = new ArbitraryWholeNumbers (false, a2);
        NaturalNumber f = new NaturalNumber(value2);
        int[] a3 = new int[] {2,8};
        ArbitraryWholeNumbers value3 = new ArbitraryWholeNumbers (false, a3);
        NaturalNumber c = new NaturalNumber(value3);
        assertEquals(true, (g.add(f).toString()).equals(c.toString()));
        // Case 2: Testing of adding natural numbers with more digits
        int[] a4 = new int[] {2,3,5,1,3};
        ArbitraryWholeNumbers value4 = new ArbitraryWholeNumbers (false, a4);
        NaturalNumber k = new NaturalNumber(value4);
        int[] a5 = new int[] {3,2,1,7,6};
        ArbitraryWholeNumbers value5 = new ArbitraryWholeNumbers (false, a5);
        NaturalNumber l = new NaturalNumber(value5);
        int[] a6 = new int[] {5,5,6,8,9};
        ArbitraryWholeNumbers value6 = new ArbitraryWholeNumbers (false, a6);
        NaturalNumber m = new NaturalNumber(value6);
        assertEquals(true, (k.add(l).toString()).equals(m.toString()));
    }

    /**
     * Testing the equals() method with 2 cases:
     */
    @Test
    public void testEqualsNatural() {
        // Case 1: Test if two integer numbers to be compared are equal to each other:
        int[] a1 = new int[] {1,4};
        ArbitraryWholeNumbers value1 = new ArbitraryWholeNumbers (false, a1);
        NaturalNumber g = new NaturalNumber(value1);
        int[] a2 = new int[] {1,4};
        ArbitraryWholeNumbers value2 = new ArbitraryWholeNumbers (false, a2);
        NaturalNumber f = new NaturalNumber(value2);
        assertEquals(true, g.equals(f));
        // Case 2: Test if two integer numbers to be compared are NOT equal to each other
        int[] a3 = new int[] {1,4};
        ArbitraryWholeNumbers value3 = new ArbitraryWholeNumbers (false, a3);
        NaturalNumber l = new NaturalNumber(value3);
        int[] a4 = new int[] {5,5,6,8,9};
        ArbitraryWholeNumbers value4 = new ArbitraryWholeNumbers (false, a4);
        NaturalNumber m = new NaturalNumber(value4);
        assertEquals(false, l.equals(m));
    }

    /**
     * Testing the toString() method with 1 case:
     */
    @Test
    public void testToStringNatural() {
        // Case 1: Test to represent a natural number in String form
        int[] a1 = new int[] {1,4};
        ArbitraryWholeNumbers value1 = new ArbitraryWholeNumbers (false, a1);
        NaturalNumber g = new NaturalNumber(value1);
        assertEquals("41", g.toString());
    }

    /* ALL METHODS HAVE BEEN TESTED SUCCESSFULLY */

}
