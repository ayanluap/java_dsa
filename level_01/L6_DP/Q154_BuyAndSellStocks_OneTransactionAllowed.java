package L6_DP;
import java.io.*;
import java.util.*;

// 1. You are given a number n, representing the number of days.
// 2. You are given n numbers, where ith number represents price of stock on ith day.
// 3. You are required to print the maximum profit you can make if you are allowed a single transaction.

public class Q154_BuyAndSellStocks_OneTransactionAllowed {
    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner sc= new Scanner(System.in);
        int n= sc.nextInt();
        int[] arr= new int[n];

        for(int i=0; i<n; i++) arr[i]= sc.nextInt();

        int minBuy= Integer.MAX_VALUE;
        int profit= 0;

        for(int x: arr) {
            if(x < minBuy) {
                minBuy= x;
            } else {
                profit= Math.max(profit, x-minBuy);
            }
        }

        System.out.println(profit);

    }
}
