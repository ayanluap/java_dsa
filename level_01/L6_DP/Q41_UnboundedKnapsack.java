package L6_DP;
import java.util.*;

// 1. You are given a number n, representing the count of items.
// 2. You are given n numbers, representing the values of n items.
// 3. You are given n numbers, representing the weights of n items.
// 3. You are given a number "cap", which is the capacity of a bag you've.
// 4. You are required to calculate and print the maximum value that can be created in the bag without overflowing it's capacity.

// Note -> Each item can be taken any number of times. You are allowed to put the same item again and again.

public class Q41_UnboundedKnapsack {
    static Scanner sc=new Scanner(System.in);
    public static void main(String args[]) {
        int n=sc.nextInt();
        int val[]=new int[n];
        int wt[]=new int[n];

        for(int i=0; i<n; i++) val[i]=sc.nextInt();
        for(int i=0; i<n; i++) wt[i]=sc.nextInt();

        int cap=sc.nextInt();
        Integer dp[][]=new Integer[n+1][cap+1];

        // System.out.println(unboundedKnapsack(wt, val, n, cap, dp));
        System.out.println(unboundedKnapsackTopDown(wt, val, n, cap, dp));
    }

    // Unbounded Knapsack
    public static int unboundedKnapsack(int wt[], int val[], int n, int cap, Integer dp[][]){
        if(cap<=0 || n<=0) return 0;

        if(dp[n][cap]!=null) return dp[n][cap];

        int taking= unboundedKnapsack(wt, val, n, cap-wt[n-1], dp)+val[n-1];
        int notTaking= unboundedKnapsack(wt, val, n-1, cap, dp);

        if(wt[n-1]<=cap){
            dp[n][cap]= Math.max(taking, notTaking);
        }else{
            dp[n][cap]= notTaking;
        }

        return dp[n][cap];
    }

    // using top down
    public static int unboundedKnapsackTopDown(int wt[],int val[], int n, int cap, Integer dp[][]){
        
        for(int i=0; i<=n; i++){
            for(int j=0; j<=cap; j++){
                if(i<=0 || j<=0) dp[i][j]=0;
                else {
                    if(wt[i-1]<=j){
                        dp[i][j]= Math.max(dp[i][j-wt[i-1]]+val[i-1] , dp[i-1][j]);
                    }else{
                        dp[i][j]= dp[i-1][j];
                    }
                }
            }
        }

        return dp[n][cap];
    }

}

