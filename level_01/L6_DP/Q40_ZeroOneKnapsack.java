package L6_DP;
import java.util.*;

// 1. You are given a number n, representing the count of items.
// 2. You are given n numbers, representing the values of n items.
// 3. You are given n numbers, representing the weights of n items.
// 3. You are given a number "cap", which is the capacity of a bag you've.
// 4. You are required to calculate and print the maximum value that can be created in the bag without  overflowing it's capacity.

// Note -> Each item can be taken 0 or 1 number of times. You are not allowed to put the same item again and again.

public class Q40_ZeroOneKnapsack {
    static Scanner sc=new Scanner(System.in);
    public static void main(String args[]){
        int n=sc.nextInt();
        int val[]=new int[n];
        int wt[]=new int[n];

        for(int i=0; i<n; i++) val[i]=sc.nextInt();
        for(int i=0; i<n; i++) wt[i]=sc.nextInt();

        int cap=sc.nextInt();
        Integer dp[][]=new Integer[n+1][cap+1];

        // System.out.println(knapsack(val, wt, cap, n, dp));
        System.out.println(knapsackTopDown(val, wt, cap, n, dp));
    }

    // using recursion
    public static int knapsack(int val[], int wt[], int cap, int n ,Integer dp[][]){
        if(cap==0 || n<=0 || cap<0) return 0;

        if(dp[n][cap]!=null) return dp[n][cap];

        int taking=knapsack(val, wt, cap-wt[n-1], n-1, dp) + val[n-1];
        int notTaking=knapsack(val, wt, cap, n-1, dp);

        if(wt[n-1]<=cap){
            dp[n][cap]= Math.max(taking, notTaking);
        }else{
            dp[n][cap]= notTaking;
        }

        return dp[n][cap];
    }

    // using top down
    public static int knapsackTopDown(int val[], int wt[], int cap, int n, Integer dp[][]){

        for(int i=0; i<=n; i++) dp[i][0]=0;
        for(int i=0; i<=cap; i++) dp[0][i]=0;

        for(int i=1; i<=n; i++){
            for(int j=1; j<=cap; j++){
                if(wt[i-1]<=j){
                    dp[i][j]= Math.max(dp[i-1][j-wt[i-1]]+val[i-1], dp[i-1][j]);
                }else{
                    dp[i][j]=  dp[i-1][j];
                }
            }
        } 

        return dp[n][cap];

    }
}
