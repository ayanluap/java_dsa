package L6_DP;
import java.io.*;
import java.util.*;

// 1. You are given a number n, representing the count of elements.
// 2. You are given n numbers, representing n elements.
// 3. You are required to find the maximum sum of a subsequence with no adjacent elements.

// Constraints
// 1 <= n <= 1000
// -1000 <= n1, n2, .. n elements <= 1000

public class Q149_MaximumSumNonAdjacentElements {
    public static void main(String[] args) throws Exception {
        // Scanner sc= new Scanner(System.in);
        // int n= sc.nextInt();

        // int[] arr= new int[n];
        // Integer[] dp= new Integer[n];
        // // Arrays.fill(dp, -1);

        // for(int i=0; i<n; i++) arr[i]= sc.nextInt();

        // System.out.println(maxSumNoAdj(arr, arr.length-1, dp));

        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[]arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }

        int inc = arr[0];                                       //1
        int exc = 0;
        for (int i = 1; i < n; i++) {
            int ninc = exc + arr[i];                            //2
            int nexc = Math.max(inc, exc);
            inc = ninc;                                         //3
            exc = nexc;
        }
        System.out.println(Math.max(inc, exc));                 //4
  
    }

    public static int maxSumNoAdj(int[] arr, int n, Integer[] dp) {
        if(n==0) return arr[n];
        if(n<0) return 0;

        if(dp[n] != null) return dp[n];

        int take= arr[n] + maxSumNoAdj(arr, n-2, dp);
        int notTake= maxSumNoAdj(arr, n-1, dp);

        return dp[n]= Math.max(take, notTake);
    }
}
