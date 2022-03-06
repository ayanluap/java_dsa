package L6_DP;
import java.util.*;

// 1. You are given a number n and a number k separated by a space, representing the number of houses and number of colors.
// 2. In the next n rows, you are given k space separated numbers representing the cost of painting nth house with one of the k colors.
// 3. You are required to calculate and print the minimum cost of painting all houses without painting any consecutive house with same color.

// Input Format
// A number n
// n1-0th n1-1st n1-2nd .. n1-kth
// n2-0th n2-1st n2-2nd .. n2-kth
// .. n number of elements

public class Q151_PaintHouse_ManyColors {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        int n= sc.nextInt();
        int k= sc.nextInt();

        int[][] arr= new int[n][k];
        Integer[][] dp= new Integer[n][k];

        for(int i=0; i<n; i++) {
            for(int j=0; j<k; j++) {
                arr[i][j]= sc.nextInt();
            }
        }

        // System.out.println(paintHouseRec(arr, n-1, -1, dp));
        // System.out.println(paintHouseTab(arr, dp));
        System.out.println(paintHouseMin(arr, dp));
    }

    // MEMOIZATION
    public static int paintHouseRec(int[][] arr, int n, int last, Integer[][] dp) {
        if(n==-1) return 0;

        if(last>-1 && dp[n][last] != null) return dp[n][last];

        int[] takeKClr= new int[arr[0].length];
        Arrays.fill(takeKClr, Integer.MAX_VALUE);

        for(int i=0; i<takeKClr.length; i++) {
            if(last!=i) takeKClr[i]= arr[n][i] + paintHouseRec(arr, n-1, i, dp);  
        }

        int res= Integer.MAX_VALUE;
        for(int x: takeKClr) res= Math.min(res, x);
        
        return last > -1 ? dp[n][last]= res : res;
    }

    // TABULAR ----> N^3
    public static int paintHouseTab(int[][] arr, Integer[][] dp) {
        
        for(int col=0; col<arr[0].length; col++) dp[0][col]= arr[0][col];

        for(int row=1; row<arr.length; row++) {
            for(int col=0; col<arr[0].length; col++) {
                int mini= Integer.MAX_VALUE;

                for(int i=0; i<arr[0].length; i++) {
                    if(i!=col) mini= Math.min(mini, dp[row-1][i]);
                }

                dp[row][col]= arr[row][col] + mini;
            }
        }

        int res= Integer.MAX_VALUE;
        for(int col=0; col<arr[0].length; col++) res= Math.min(res, dp[arr.length-1][col]);

        return res;
    }


    // REDUCING TIME COMPLEX. ----> N^2
    public static int paintHouseMin(int[][] arr, Integer[][] dp) {
        for(int col=0; col<arr[0].length; col++) dp[0][col]= arr[0][col];

        for(int row=1; row<arr.length; row++) {
            int mini1= Integer.MAX_VALUE;
            int mini2= Integer.MAX_VALUE;

            for(int col=0; col<arr[0].length; col++) {
                if(dp[row-1][col] <= mini1) {
                    int temp= mini1;
                    mini1= dp[row-1][col];
                    mini2= temp;
                } else if (dp[row-1][col] < mini2) {
                    mini2= dp[row-1][col];
                }
            }

            for(int col=0; col<arr[0].length; col++) {
                if(dp[row-1][col] == mini1) dp[row][col]= arr[row][col] + mini2;
                else dp[row][col]= arr[row][col] + mini1;
            }
        }

        int res= Integer.MAX_VALUE;
        for(int col=0; col<arr[0].length; col++) res= Math.min(res, dp[arr.length-1][col]);

        return res;
    }
}
