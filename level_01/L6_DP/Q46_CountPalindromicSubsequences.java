package L6_DP;
import java.util.*;

// 1. You are given a string str.
// 2. You are required to print the count of palindromic subsequences in string str.

public class Q46_CountPalindromicSubsequences {
    static Scanner sc=new Scanner(System.in);
    public static void main(String args[]){
        String s=sc.next();
        int dp[][]=new int[s.length()+1][s.length()+1];
        for(int[] r: dp) Arrays.fill(r,-1);
        System.out.println(countPalinSubseq(s, 0, s.length()-1, dp));
    }    

    public static int countPalinSubseq(String a, int i, int j, int dp[][]){
        if(i>j) return 0;
        if(i==j) return 1;

        if(isPalin(a, i, j)==true) return 1;
        if(dp[i][j] != -1) return dp[i][j];
        // int res=0;

        for(int k=i; k<=j; k++){
            dp[i][j]= countPalinSubseq(a, i, k, dp) + countPalinSubseq(a, k+1, j, dp);
        }

        return dp[i][j];
    }

    public static Boolean isPalin(String s, int i, int j){
        while(i<j){
            if(s.charAt(i) != s.charAt(j)){
                return false;
            }else{
                i++; j--;
            }
        }
        return true;
    }

}
