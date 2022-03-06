package L6_DP;
import java.util.*;
import java.io.*;

// 1. You are given a number n, representing the number of days.
// 2. You are given n numbers, where ith number represents price of stock on ith day.
// 3. You are required to print the maximum profit you can make if you are allowed infinite transactions.
// Note - There can be no overlapping transaction. One transaction needs to be closed (a buy followed by a sell) before opening another transaction (another buy)

// Constraints
// 0 <= n <= 20
// 0 <= n1, n2, .. <= 10

public class Q155_BuyAndSellStocks_InfiniteTransactionsAllowed {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        int n= sc.nextInt();
        int[] arr= new int[n];

        for(int i=0; i<n; i++) arr[i]= sc.nextInt();

        int minBuy= Integer.MAX_VALUE;
        int res= 0;
        int profit= 0;

        for(int x: arr) {
            if(x < minBuy) {
                res+= profit;
                profit= 0;
                minBuy= x;
            } else {
                profit= Math.max(profit, x-minBuy);
            }
        }
        if(profit > res) res+= profit;

        System.out.println(res);

    }
}
