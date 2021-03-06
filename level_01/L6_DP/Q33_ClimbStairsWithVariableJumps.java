package L6_DP;
import java.util.*;

// 1. You are given a number n, representing the number of stairs in a staircase.
// 2. You are on the 0th step and are required to climb to the top.
// 3. You are given n numbers, where ith element's value represents - till how far from the step you could jump to in a single move. You can of course jump fewer number of steps in the move.
// 4. You are required to print the number of different paths via which you can climb to the top.

public class Q33_ClimbStairsWithVariableJumps {
    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int jumps[]=new int[n];
        for(int i=0; i<n; i++) jumps[i]=sc.nextInt();
        System.out.println(climbVarSteps(n, jumps));
    }

    public static int climbVarSteps(int n, int jumps[]){
        int dp[]=new int[n+1];
        dp[n]=1;

        for(int i=n-1; i>=0; i--){
            for(int j=1; j<=jumps[i] && i+j < dp.length; j++ ){
                dp[i]+=dp[i+j];
            }
        }

        return dp[0];
    }

}
