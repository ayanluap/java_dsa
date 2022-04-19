package L2_ArraysAndStrings;

import java.util.*;

// 1. Given two non-negative integers num1 and num2 represented as strings.
// 2. Return the product of num1 and num2, also represented as a string.
// 3. Note: You must not use any built-in BigInteger library or convert the inputs to integer directly.

// Constraints
// 1. 1 <= num1.length, num2.length <= 200
// 2. num1 and num2 consist of digits only.
// 3. Both num1 and num2 do not contain any leading zero, except the number 0 itself.

public class Q189_MultiplyStrings {
    // ~~~~~~~~~~~~~~~User Section~~~~~~~~~~~~
    public static String multiplication(String num1, String num2) {
        // write your code here
        int n = num1.length() + num2.length();
        int[] res = new int[n];
        Arrays.fill(res, 0);
        int skip = 0;
        int carry = 0;

        for (int i = num2.length() - 1; i >= 0; i--) {
            int filler = n - 1 - skip;
            for (int j = num1.length() - 1; j >= 0; j--) {
                int op1 = num1.charAt(j) - '0';
                int op2 = num2.charAt(i) - '0';
                int val = 0;

                int mult = (op1 * op2) + carry + res[filler];
                carry = 0;

                if (mult <= 9) {
                    val = mult;
                } else {
                    carry = mult / 10;
                    val = mult % 10;
                }

                res[filler] = val;
                filler--;
            }
            if (carry > 0) {
                res[filler] = carry;
                carry = 0;
            }
            ;
            skip++;
        }

        StringBuilder str = new StringBuilder();

        int i = 0;
        while (res[i] == 0 && i < res.length)
            i++;

        for (int k = i; k < res.length; k++)
            str.append(res[k]);

        return str.toString();
    }

    // ~~~~~~~~~~~~Input Management~~~~~~~~~~~~~
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        String str1 = scn.nextLine();
        String str2 = scn.nextLine();

        String res = multiplication(str1, str2);
        System.out.println(res);
    }
}
