package L2_ArraysAndStrings;
import java.util.*;

// 1. Given a positive number 'n' in form of String.
// 2. Find the smallest number which has exactly the same digits existing in the number 'n' and is greater in value than 'n'.
// 3. If no such positive number exists, return -1 as string.

// Constraints
// 1. 'n' is given in form of string.


public class Q164_NextGreaterElement_3 {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        String n= sc.next();
        StringBuilder ns= new StringBuilder(n);
        
        int i= ns.length()-2;
        while(i>=0 && ns.charAt(i) > ns.charAt(i+1)) {
            i--;
        }
        if(i<0) {
            System.out.println("-1");
            return;
        }

        int j= ns.length()-1;
        while(i<j) {
            if(ns.charAt(j) > ns.charAt(i)) {
                char t= ns.charAt(i);
                ns.setCharAt(i, ns.charAt(j));
                ns.setCharAt(j, t);
                break;
            } else j--;
        }

        i++;
        j=ns.length()-1;
        while(i<j) {
            char t= ns.charAt(i);
            ns.setCharAt(i, ns.charAt(j));
            ns.setCharAt(j, t);
            i++; j--;
        }

        System.out.println(ns);

    }
}
