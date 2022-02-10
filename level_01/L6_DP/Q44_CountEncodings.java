package L6_DP;
import java.util.*;

// 1. You are given a string str of digits. (will never start with a 0)
// 2. You are required to encode the str as per following rules
//     1 -> a
//     2 -> b
//     3 -> c
//     ..
//     25 -> y
//     26 -> z
// 3. You are required to calculate and print the count of encodings for the string str.

//      For 123 -> there are 3 encodings. abc, aw, lc
//      For 993 -> there is 1 encoding. iic 
//      For 013 -> This is an invalid input. A string starting with 0 will not be passed.
//      For 103 -> there is 1 encoding. jc
//      For 303 -> there are 0 encodings. But such a string maybe passed. In this case 
//      print 0.

public class Q44_CountEncodings {
    static Scanner sc=new Scanner(System.in);
    public static void main(String args[]){
        String digs=sc.next();

        System.out.println(countEncodings(digs, digs.length(), new int[digs.length()]));
    }

    public static int countEncodings(String digs, int n, int dp[]){

        if(digs.charAt(0)!='0') dp[0]=1;
        
        for(int i=1; i<n; i++){
            if(digs.charAt(i)=='0' && digs.charAt(i-1)=='0'){
                dp[i]=0;
            }else if(digs.charAt(i-1)=='0' && digs.charAt(i)!='0'){
                dp[i]=dp[i-1];
            }else if(digs.charAt(i-1)!='0' && digs.charAt(i)=='0'){
                if(digs.charAt(i-1)=='1' || digs.charAt(i-1)=='2') {
                    dp[i]= (i>=2 ? dp[i-2] : 1);
                }else{
                    dp[i]=0;
                }
            }else{
                if(Integer.parseInt(digs.substring(i-1, i+1)) <= 26) {
                    dp[i]= dp[i-1]+ ( i<2 ? 1 : dp[i-2] );
                }else{
                    dp[i]= dp[i-1];
                }
            }
        }

        return dp[n-1];
    }

}
