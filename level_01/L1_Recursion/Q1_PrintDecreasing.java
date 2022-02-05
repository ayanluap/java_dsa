package L1_Recursion;
import java.util.*;


// 1. You are given a positive number n. 
// 2. You are required to print the counting from n to 1.
// 3. You are required to not use any loops. Complete the body of print Decreasing function to achieve it.

public class Q1_PrintDecreasing {
    public static void printDecreasing(int n) {
        if(n==0) return;

        System.out.println(n);
        printDecreasing(n-1);
    }
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        int x=sc.nextInt();
        printDecreasing(x);
    }
}
