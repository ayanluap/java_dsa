package L2_ArraysAndStrings;

import java.util.*;

// 1. A complex number can be represented as a string on the form "Real + Imaginary i" where:
//     1.1 Real is the real part and is an integer in the range [-100, 100].
//     1.2 Imaginary is the imaginary part and is an integer in the range [-100, 100].
//     1.3 i^2 == -1.
// 2. Given two complex numbers num1 and num2 as strings, return a string of the complex number that represents their multiplications.

// Constraints
// num1 and num2 are valid complex numbers.

public class Q191_ComplexNumberMultiplication {
    // ~~~~~~~~~~~~~User''s Section~~~~~~~~~~~~~
    public static String complexNumberMultiply(String num1, String num2) {
        // write your code here
        int r1 = Integer.parseInt(num1.substring(0, num1.indexOf('+')));
        int i1 = Integer.parseInt(num1.substring(num1.indexOf('+') + 1, num1.indexOf('i')));
        int r2 = Integer.parseInt(num2.substring(0, num2.indexOf('+')));
        int i2 = Integer.parseInt(num2.substring(num2.indexOf('+') + 1, num2.indexOf('i')));

        return "" + ((r1 * r2) - (i1 * i2)) + "+" + ((i1 * r2) + (i2 * r1)) + "i";
    }

    // ~~~~~~~~~~~~Input Management~~~~~~~~~~~
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String num1 = scn.nextLine();
        String num2 = scn.nextLine();
        String res = complexNumberMultiply(num1, num2);
        System.out.println(res);
    }
}
