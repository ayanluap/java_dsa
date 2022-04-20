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
        int count = 0;

        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) {
                if (s.charAt(i + 1) == s.charAt(j) || s.charAt(j - 1) == s.charAt(i))
                    count++;
                else
                    return false;
            }
            i++;
            j--;
        }

        if (count > 1)
            return false;
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
