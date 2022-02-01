// package level_01.L6_DP;
import java.util.*;

import javax.print.attribute.SupportedValuesAttribute;

// 1. You are given a number n.
// 2. You are required to print the nth element of fibonnaci sequence.

// Note -> Notice precisely how we have defined the fibonnaci sequence
// 0th element -> 0
// 1st element -> 1
// 2nd element -> 1
// 3rd element -> 2
// 4th element -> 3
// 5th element -> 5
// 6th element -> 8

public class Q31_Fibonacci {
    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        System.out.println(fibonacci(n, new int[n+1]));
     }

     public static int fibonacci(int n, int qb[]){
         if(n==1) return n;
         if(n==0) return n;

         if(qb[n]!=0) return qb[n];

         return qb[n]=fibonacci(n-1, qb)+fibonacci(n-2,qb);
     }
}
