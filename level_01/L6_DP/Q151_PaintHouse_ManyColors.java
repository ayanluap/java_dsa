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

        System.out.println(paintHouseRec(arr, 0, -1, dp));
    }

    // MEMOIZATION
    public static int paintHouseRec(int[][] arr, int n, int last, Integer[][] dp) {
        if(n==arr.length) return 0;

        if(last>-1 && dp[n][last] != null) return dp[n][last];

        int[] takeKClr= new int[arr[0].length];
        int res= Integer.MAX_VALUE;

        for(int i=0; i<takeKClr.length; i++) {
            if(last!=i) takeKClr[i]= arr[n][i] + paintHouseRec(arr, n+1, i, dp);  
        }

        if(last > -1) for(int x: takeKClr) dp[n][last]= Math.min(res, x);

        return last>-1 ? dp[n][last]= res : res;
    }
}
