package L6_DP;
import java.util.*;

// 1. You are given a number n, representing the count of elements.
// 2. You are given n numbers.
// 3. You are given a number "tar".
// 4. You are required to calculate and print true or false, if there is a subset the elements of which add up to "tar" or not.

public class Q37_TargetSumSubsetsDp {
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int arr[]=new int[n];
        for(int i=0; i<arr.length; i++){
            arr[i]=sc.nextInt();
            
        }
        int tar=sc.nextInt();

        Boolean dp[][]=new Boolean[n+1][tar+1];
        // System.out.println(targetSum(arr, n, tar, dp));

        System.out.println(targetSumTab(arr, n, tar, dp));
        
    }

    // Using 0-1 Knapsack recursion
    public static boolean targetSum(int arr[], int n, int tar, Boolean dp[][]){
        if(n==0 && tar==0) return true;
        else if(tar<0 || n<=0) return false;

        if(dp[n][tar]!=null) return dp[n][tar];

        if(arr[n-1]<=tar){
            dp[n][tar]= targetSum(arr, n-1, tar-arr[n-1], dp) || targetSum(arr, n-1, tar, dp);
            
        }else{
            dp[n][tar]=targetSum(arr, n-1, tar, dp);
        }

        return dp[n][tar];
    }

    // using tabulation
    public static boolean targetSumTab(int arr[], int n, int tar, Boolean dp[][]){

        for(int j=1; j<=tar; j++) dp[0][j]=false;
        for(int i=1; i<=n; i++) dp[i][0]=true;
        dp[0][0]=true;

        for(int i=1; i<=n; i++){
            for(int j=1; j<=tar; j++){

                if(arr[i-1] <= j){
                    dp[i][j]= dp[i-1][j-arr[i-1]] || dp[i-1][j];
                }else{
                    dp[i][j]= dp[i-1][j];
                }
            }
        }
        return dp[n][tar];
    }
}
