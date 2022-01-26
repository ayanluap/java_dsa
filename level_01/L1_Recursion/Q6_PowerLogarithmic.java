package level_01.L1_Recursion;
import java.util.*;

// 1. You are given a number x.
// 2. You are given another number n.
// 3. You are required to calculate x raised to the power n. Don't change the signature of power function.

// Note1 -> The previous version expects the call stack to be of n height. This function expects call function to be only log(n) high.

public class Q6_PowerLogarithmic {
    public static void main(String[] args) throws Exception {
        Scanner sc=new Scanner(System.in);
        int x=sc.nextInt();
        int n=sc.nextInt();
        System.out.println(power(x,n));
    }

    public static int power(int x, int n){
        if(n==0) return 1;

        int num=power(x,n/2);
        if(n%2==0) return num*num;
        else return num*num*x;

    }
}
