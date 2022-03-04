package L6_DP;
import java.util.*;

// 1. You are given a number n, representing the number of houses.
// 2. In the next n rows, you are given 3 space separated numbers representing the cost of painting nth house with red or blue or green color.
// 3. You are required to calculate and print the minimum cost of painting all houses without painting any consecutive house with same color.

// Constraints
// 1 <= n <= 1000
// 0 <= n1red, n1blue, .. <= 1000

public class Q150_PaintHouse {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        int n= sc.nextInt();

        int[][] arr= new int[n][3];
        Integer[][] dp= new Integer[n][3];

        for(int i=0; i<n; i++) {
            for(int j=0; j<3; j++) {
                arr[i][j]= sc.nextInt();
            }
        }
        
        System.out.println(paintMinCostRec(arr, 0, -1, dp));
        // System.out.println(paintMinCost(arr, dp));
        // System.out.println(paintMinCostConst(arr));
    }

    // MEMOIZATION
    public static int paintMinCostRec(int[][] arr, int idx, int last, Integer[][] dp) {
        if(idx==arr.length) return 0;

        if(last > -1 && dp[idx][last] != null) return dp[idx][last];

        int takeR= Integer.MAX_VALUE;
        int takeG= Integer.MAX_VALUE;
        int takeB= Integer.MAX_VALUE;

        if(last!=0) takeR= arr[idx][0] + paintMinCostRec(arr, idx+1, 0, dp);
        if(last!=1) takeG= arr[idx][1] + paintMinCostRec(arr, idx+1, 1, dp);
        if(last!=2) takeB= arr[idx][2] + paintMinCostRec(arr, idx+1, 2, dp);

        return (last > -1) ? dp[idx][last]= Math.min(takeR, Math.min(takeG, takeB)) : 
        Math.min(takeR, Math.min(takeG, takeB));
    }

    // TABULAR APPROACH
    public static int paintMinCost(int[][] arr, Integer[][] dp) {
        dp[0][0]= arr[0][0];
        dp[0][1]= arr[0][1];
        dp[0][2]= arr[0][2];
        
        for(int i=1; i<arr.length; i++) {
            dp[i][0]= arr[i][0] + Math.min(dp[i-1][1], dp[i-1][2]);
            dp[i][1]= arr[i][1] + Math.min(dp[i-1][0], dp[i-1][2]);
            dp[i][2]= arr[i][2] + Math.min(dp[i-1][0], dp[i-1][1]);
        }

        return Math.min(dp[arr.length-1][0], Math.min(dp[arr.length-1][1], dp[arr.length-1][2]));
    }

    // reducing to constant space
    public static int paintMinCostConst(int[][] arr) {
        int red= arr[0][0];
        int green= arr[0][1];
        int blue= arr[0][2];
        
        for(int i=1; i<arr.length; i++) {
            int redCurr= arr[i][0] + Math.min(green, blue);
            int greenCurr= arr[i][1] + Math.min(red, blue);
            int blueCurr= arr[i][2] + Math.min(red, green);

            red= redCurr;
            green= greenCurr;
            blue= blueCurr;
        }

        return Math.min(red, Math.min(green, blue));
    }
}
