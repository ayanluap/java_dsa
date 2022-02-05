package L4_RecursionOnTheWayUp;
import java.util.*;

// 1. You are given a string str.
// 2. Complete the body of printPermutations function - without changing signature - to calculate and print all permutations of str.
// Use sample input and output to take idea about permutations.

public class Q25_PrintPermutations {
    public static void main(String args[]) throws Exception{
        Scanner sc=new Scanner(System.in);
        String str=sc.next();
        printPermutations(str, "");
    }

    public static void printPermutations(String str, String asf) {
        if(str.length()<=0) {
            System.out.println(asf);
            return;
        }
        
        for(int i=0; i<str.length(); i++){
            char ch=str.charAt(i);
            String left=str.substring(0, i);
            String right=str.substring(i+1);
            String newStr=left+right;
            printPermutations(newStr, asf+ch);
        }
    }
}
