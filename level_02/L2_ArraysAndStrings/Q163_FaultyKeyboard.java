package L2_ArraysAndStrings;
import java.util.*;

// 1. Your friend is typing his name into a faulty keyboard. 
// 2. Sometimes, when typing a character 'c', the key might get long pressed, and the character will be typed 1 or more times.
// 3. You examine the typed characters of the keyboard. Return 'True' if it is possible that it was your friends name, with some characters (possibly none) being long pressed.

// Constraints
// 1. 1 <= name.length <= 1000
// 2. 1 <= typed.length <= 1000
// 3. name and typed contain only lowercase English letters.

public class Q163_FaultyKeyboard {
    // ~~~~~~~~~~~~~~~~~~~~~User Section~~~~~~~~~~~~~~~~~~~~~

    public static boolean isPossible(String name, String typed) {
        // Write your code here
        int i=0, j=0;
        while(i<name.length() && j<typed.length()) {
            if(name.charAt(i) == typed.charAt(j)) {
                char curr= name.charAt(i);
                int count1=0, count2=0;

                while(i<name.length() && name.charAt(i)==curr) {
                    count1++; 
                    i++;
                }

                while(j<typed.length() && typed.charAt(j)==curr) {
                    count2++;
                    j++;
                }

                if(count1>count2) return false;

            }else return false;
        }

        if(i<name.length() || j<typed.length()) return false;

        return true;
    }

    // ~~~~~~~~~~~~~~~~~~~Input Management~~~~~~~~~~~~~~~~~~~

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        
        String name = scn.next();
        String typed = scn.next();

        boolean res = isPossible(name, typed);

        System.out.println(res);
    }
}
