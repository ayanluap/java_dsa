package L6_DP;
import java.io.*;
import java.util.*;

// 1. You are given a number n and a number k in separate lines, representing the number of fences and number of colors.
// 2. You are required to calculate and print the number of ways in which the fences could be painted so that not more than two consecutive  fences have same colors.

public class Q153_PaintFence {
    public static void main(String[] args) throws Exception {
        Scanner sc= new Scanner(System.in);

        int n= sc.nextInt();
        int k= sc.nextInt();

        int res= k*k;

        for(int i=2; i<n; i++) res*= k-1;

        res*= n;
        System.out.println(res);
    }
}
