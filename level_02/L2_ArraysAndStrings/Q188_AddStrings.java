package L2_ArraysAndStrings;

import java.util.*;

// 1. Given two non-negative integers, num1 and num2 represented as string.
// 2. Return the sum of num1 and num2 as a string.
// 3. You must solve the problem without using any built-in library for handling large integers (such as BigInteger). 
// 4. You must also not convert the inputs to integers directly.

// Constraints
// 1. 1 <= num1.length, num2.length <= 10^4
// 2. num1 and num2 consist of only digits.
// 3. num1 and num2 don't have any leading zeros except for the zero itself.

public class Q188_AddStrings {
    public static String addStrings(String num1, String num2) {
        // write your code here
        int n1 = num1.length() - 1;
        int n2 = num2.length() - 1;

        int carry = 0;

        StringBuilder str = new StringBuilder();

        while (n1 >= 0 && n2 >= 0) {
            int op1 = num1.charAt(n1) - '0';
            int op2 = num2.charAt(n2) - '0';

            int sum = op1 + op2 + carry;
            carry = 0;

            if (sum > 9) {
                str.append(sum % 10);
                carry = sum / 10;
            } else {
                str.append(sum);
            }
            n1--;
            n2--;
        }

        while (n1 >= 0) {
            int op1 = num1.charAt(n1) - '0';
            int sum = op1 + carry;
            carry = 0;

            if (sum >= 10) {
                str.append(sum % 10);
                carry = sum / 10;
            } else {
                str.append(sum);
            }
            n1--;
        }

        while (n2 >= 0) {
            int op2 = num2.charAt(n2) - '0';
            int sum = op2 + carry;
            carry = 0;

            if (sum > 9) {
                str.append(sum % 10);
                carry = sum / 10;
            } else {
                str.append(sum);
            }
            n2--;
        }

        if (carry > 0)
            str.append(carry);

        str.reverse();

        return str.toString();
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String n1 = scn.nextLine();
        String n2 = scn.nextLine();

        String res = addStrings(n1, n2);
        System.out.println(res);
    }
}
