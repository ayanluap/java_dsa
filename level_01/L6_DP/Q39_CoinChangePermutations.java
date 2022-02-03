import java.util.*;

// 1. You are given a number n, representing the count of coins.
// 2. You are given n numbers, representing the denominations of n coins.
// 3. You are given a number "amt".
// 4. You are required to calculate and print the number of permutations of the n coins using which the amount "amt" can be paid.

// Note1 -> You have an infinite supply of each coin denomination i.e. same coin denomination can be used for many installments in payment of "amt"

// Note2 -> You are required to find the count of permutations and not combinations i.e. 2 + 2 + 3 = 7 and 2 + 3 + 2 = 7 and 3 + 2 + 2 = 7 are different permutations of same combination. You should treat them as 3 and not 1.

public class Q39_CoinChangePermutations {
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int coins[]=new int[n];
        for(int i=0; i<n; i++) coins[i]=sc.nextInt();
        int amt=sc.nextInt();

        int dp[]=new int[amt+1];
        dp[0]=1;

        System.out.println(coinChangePermutation(coins, amt, dp));

    }

    // public static int coinChangePermutation(int coins[], int amt, Integer dp[]){
    //     if(amt==0) return 1;
    //     if(amt<0) return 0;

    //     if(dp[amt]!=null) return dp[amt];

    //     // if(coins[n-1] <= amt){
    //     //     dp[amt]= dp[amt] + coinChangePermutation(coins, n-1, amt-coins[n-1], dp);
    //     // }else{
    //     //     // dp[amt]= dp[amt] + coinChangePermutation(coins, n-1, amt, dp);
    //     // }

    //     return dp[amt];
    // }

    public static int coinChangePermutation(int coins[], int amt, int dp[]){

        for(int amount=1; amount<dp.length; amount++) {
            for(int coin: coins){
                if(amount>=coin){
                    dp[amount]+=dp[amount-coin];
                }
            }
        }

        return dp[amt];
    }
}
