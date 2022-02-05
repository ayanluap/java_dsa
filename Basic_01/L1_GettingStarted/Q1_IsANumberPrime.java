package L1_GettingStarted;
import java.util.*;

// // 1. You've to check whether a given number is prime or not.
// // 2. Take a number "t" as input representing count of input numbers to be tested.
// // 3. Take a number "n" as input "t" number of times.
// // 4. For each input value of n, print "prime" if the number is prime and "not prime" otherwise.

public class Q1_IsANumberPrime {
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();

        while(t>0){
            int n=sc.nextInt();

            int count=0;
            for(int i=2; i*i<=n; i++){
                if(n%i==0) {
                    count++;
                    break;
                }
            }
            
            if(count>0) System.out.println("not prime");
            else System.out.println("prime");
            t--;
        }
    }
}
    

