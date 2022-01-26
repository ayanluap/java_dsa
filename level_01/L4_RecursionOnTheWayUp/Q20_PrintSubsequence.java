package level_01.L4_RecursionOnTheWayUp;
import java.util.*;

// 1. You are given a string str.
// 2. Complete the body of printSS function - without changing signature - to calculate and print all subsequences of str.

public class Q20_PrintSubsequence {
    public static void main(String[] args) throws Exception {
        Scanner sc =new Scanner(System.in);
        String str=sc.next();
        printSS(str, "");
    }

    public static void printSS(String str, String ans) {
        if(str.length()==0) {
            System.out.println(ans);
            return;
        }

        char curr=str.charAt(0);
        String newStr=str.substring(1);
        printSS(newStr, ans+curr);
        printSS(newStr, ans+"");  
    }
       
}
