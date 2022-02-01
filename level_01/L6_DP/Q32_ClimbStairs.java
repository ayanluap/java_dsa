// package level_01.L6_DP;
import java.util.*;

// 1. You are given a number n, representing the number of stairs in a staircase.
// 2. You are on the 0th step and are required to climb to the top.
// 3. In one move, you are allowed to climb 1, 2 or 3 stairs.
// 4. You are required to print the number of different paths via which you can climb to the top.

public class Q32_ClimbStairs {
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        System.out.println(climbStairs(n,  new int[n+1]));
        System.out.println(climbStairsTab(n));
    }

    // USING MEMOIZATION
    public static int climbStairs(int n,  int qb[]){
        
        if(n==0) return 1;
        else if(n<0) return 0;

        if(qb[n]!=0) return qb[n];

        int p1=climbStairs(n-1, qb);
        int p2=climbStairs(n-2, qb);
        int p3=climbStairs(n-3, qb);
        return qb[n]=p1+p2+p3;
    }

    // USING TABULATION
    public static int climbStairsTab(int n){
        int dp[]=new int[n+1];

        if(n==0) return 1;
        else if(n<0) return 0;

        dp[0]=1;
        for(int i=1; i<=n; i++){
            dp[i]=dp[i-1];
            if(i>=2) dp[i]+=dp[i-2];
            if(i>=3) dp[i]+=dp[i-3];
        }

        return dp[n];
    } 
}
