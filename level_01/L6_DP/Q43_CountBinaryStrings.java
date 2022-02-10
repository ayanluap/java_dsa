package L6_DP;
import java.util.*;

// 1. You are given a number n.
// 2. You are required to print the number of binary strings of length n with no consecutive 0's.

public class Q43_CountBinaryStrings {
    static Scanner sc=new Scanner(System.in);
    public static void main(String args[]){
        int n=sc.nextInt();
        System.out.println(countBinString(n, new Integer[n+1]));
    }

    public static int countBinString(int n, Integer dp[]){
        if(n==1) return 2;
        if(n==2) return 3;

        if(dp[n]!=null) return dp[n];

        return dp[n]=countBinString(n-1, dp) + countBinString(n-2, dp);
    }
    
}
