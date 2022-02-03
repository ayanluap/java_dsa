import java.util.*;

// 1. You are given a number n, representing the count of coins.
// 2. You are given n numbers, representing the denominations of n coins.
// 3. You are given a number "amt".
// 4. You are required to calculate and print the number of permutations of the n coins using which the amount "amt" can be paid.

// Note1 -> You have an infinite supply of each coin denomination i.e. same coin denomination can be used for many installments in payment of "amt"

// Note2 -> You are required to find the count of permutations and not combinations i.e.2 + 2 + 3 = 7 and 2 + 3 + 2 = 7 and 3 + 2 + 2 = 7 are different permutations of same combination. You should treat them as 3 and not 1.

public class Q38_CoinChangePermutations {
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int denom[]=new int[n];
        for(int i=0; i<n; i++) denom[i]=sc.nextInt();
        int amt=sc.nextInt();

        Integer dp[][]=new Integer[n+1][amt+1];
        // System.out.println(countCoinChange(denom, n, amt, dp));
        System.out.println(countCoinChangeTab(denom, n, amt, dp));
    }

    //  Using recursion [unbounded knapsack]
    public static int countCoinChange(int denom[], int n, int amt, Integer dp[][]){
        if(amt==0) return 1;
        if(n<=0 || amt<0) return 0;

        if(dp[n][amt]!=null) return dp[n][amt];

        if(denom[n-1]<=amt){
            dp[n][amt]= countCoinChange(denom, n, amt-denom[n-1], dp) +
             countCoinChange(denom, n-1, amt, dp);
        }else{
            dp[n][amt]=countCoinChange(denom, n-1, amt, dp);
        }

        return dp[n][amt];
    }
    
    // using tabulation
    public static int countCoinChangeTab(int denom[], int n, int amt, Integer dp[][]){
        
        for(int c=0; c<=amt; c++) dp[0][c]=0;
        for(int r=0; r<=n; r++) dp[r][0]=1;
        
        for(int i=1; i<=n; i++){
            for(int j=1; j<=amt; j++){

                if(denom[i-1]<=j){
                    dp[i][j]= dp[i][j-denom[i-1]] + dp[i-1][j];
                }else{
                    dp[i][j]= dp[i-1][j];
                }

            }
        }
        return dp[n][amt];
        
    }
}
