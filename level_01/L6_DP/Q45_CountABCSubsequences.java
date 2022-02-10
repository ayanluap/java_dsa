package L6_DP;
import java.util.*;

// 1. You are given a string str.
// 2. You are required to calculate and print the count of subsequences of the nature a+b+c+.
// For abbc -> there are 3 subsequences. abc, abc, abbc
// For abcabc -> there are 7 subsequences. abc, abc, abbc, aabc, abcc, abc, abc.

public class Q45_CountABCSubsequences {
    static Scanner sc=new Scanner(System.in);
    public static void main(String args[]){
        String str=sc.next();
        System.out.println(countSubsequences(str, str.length() , new Integer[str.length()]));
    }

    public static int countSubsequences(String str, int n, Integer dp[]){
        
        

        return dp[n];
    }
}
