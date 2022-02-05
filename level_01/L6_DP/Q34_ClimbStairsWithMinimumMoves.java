package L6_DP;
import java.util.*;

// 1. You are given a number n, representing the number of stairs in a staircase.
// 2. You are on the 0th step and are required to climb to the top.
// 3. You are given n numbers, where ith element's value represents - till how far from the step you could jump to in a single move.  You can of-course fewer number of steps in the move.
// 4. You are required to print the number of minimum moves in which you can reach the top of staircase.
// Note -> If there is no path through the staircase print null.

public class Q34_ClimbStairsWithMinimumMoves {
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int steps[]=new int[n];
        for(int i=0; i<n; i++) steps[i]=sc.nextInt();
        System.out.println(climbStairsMinMoves(n, steps));
    }

    public static int climbStairsMinMoves(int n, int steps[]){
        Integer dp[]=new Integer[n+1];
        dp[n]=0;

        for(int i=n-1; i>=0; i--){
            if(steps[i]>0){
                int min=Integer.MAX_VALUE;
                for(int j=1; j<=steps[i] && i+j<dp.length; j++){
                    if(dp[i+j]!=null) min=Math.min(min, dp[i+j]);
                }

                if(min!=Integer.MAX_VALUE) dp[i]=min+1;
            }
        }
        return dp[0];
    }

}
