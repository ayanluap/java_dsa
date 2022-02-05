package L6_DP;
import java.util.*;

// 1. You are given a number n, representing the count of items.
// 2. You are given n numbers, representing the values of n items.
// 3. You are given n numbers, representing the weights of n items.
// 3. You are given a number "cap", which is the capacity of a bag you've.
// 4. You are required to calculate and print the maximum value that can be created in the bag without overflowing it's capacity.

// Note1 -> Items can be added to the bag even partially. But you are not allowed to put same items again and again to the bag.

public class Q42_FractionalKnapsack {
    static Scanner sc=new Scanner(System.in);
    public static void main(String args[]){
        int n=sc.nextInt();
        int val[]=new int[n];
        int wt[]=new int[n];

        for(int i=0; i<n; i++) val[i]=sc.nextInt();
        for(int i=0; i<n; i++) wt[i]=sc.nextInt();

        int cap=sc.nextInt();
        Float dp[][]=new Float[n+1][cap+1];

        System.out.println(fracKnapsack(val, wt, n, cap, dp));
    }
    
    // Fractional 
    public static float fracKnapsack(int val[], int wt[], int n, int cap, Float dp[][]){

        if(n<=0 || cap<=0) return 0;

        if(dp[n][cap]!=null) return dp[n][cap];

        float takingWhole= fracKnapsack(val, wt, n-1, cap-wt[n-1], dp) + val[n-1];
        float takingPartial= fracKnapsack(val, wt, n-1, 0, dp) + ((float)val[n-1]/(float)wt[n-1])*(float)cap;
        float notTaking= fracKnapsack(val, wt, n-1, cap, dp);

        if(wt[n-1]<=cap){
            dp[n][cap]= Math.max(takingWhole, notTaking);
        }else{
            dp[n][cap]= Math.max(takingPartial, notTaking);
        }

        return dp[n][cap];
    }
}
