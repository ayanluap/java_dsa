package L1_Recursion;
import java.util.*;

// 1. You are given a positive number n. 
// 2. You are required to print the counting from 1 to n.
// 3. You are required to not use any loops. Complete the body of print Increasing function to achieve it. Don't change the signature of the function.

public class Q2_PrintIncreasing {
    public static void main(String[] args) throws Exception {
        Scanner sc=new Scanner(System.in);
        int x=sc.nextInt();
        printIncreasing(x);
    }

    public static void printIncreasing(int n){
        if(n==0) return;

        printIncreasing(n-1);
        System.out.println(n);
    }
}
