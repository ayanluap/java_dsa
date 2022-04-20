package L2_ArraysAndStrings;

import java.util.*;

// 1. Given a string s.
// 2. Return true if the s can be palindrome after deleting at most one character from it.

// Constraints
// 1. 1 <= s.length <= 10^5
// 2. s consists of lowercase English letters.

public class Q192_ValidPalindrome2 {
    // ~~~~~~~~~~~~~~User Section~~~~~~~~~~~~~~
    public static boolean validPalindrome(String s) {
        // write your code here
        int i = 0;
        int j = s.length() - 1;
        boolean res1 = true;
        boolean res2 = true;

        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) {
                res1 = chkPalindrome(s.substring(i + 1, j + 1));
                res2 = chkPalindrome(s.substring(i, j));
                break;
            }
            i++;
            j--;
        }

        if (res1 || res2)
            return true;
        else
            return false;
    }

    public static boolean chkPalindrome(String s) {
        int i = 0, j = s.length() - 1;
        while (i < j) {
            if (s.charAt(i) != s.charAt(j))
                return false;
            i++;
            j--;
        }

        return true;
    }

    // ~~~~~~~~~~~~Input Management~~~~~~~~~~~~~~~~
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String str = scn.nextLine();

        boolean res = validPalindrome(str);
        System.out.println(res);
    }
}
