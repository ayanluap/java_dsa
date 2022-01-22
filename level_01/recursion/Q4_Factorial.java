package level_01.recursion;
import java.util.*;

// 1. You are given a number n.
// 2. You are required to calculate the factorial of the number. Don't change the signature of factorial function.

public class Q4_Factorial {
    public static void main(String[] args) throws Exception {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        System.out.println(factorial(n));
    }

    public static int factorial(int n){
        if(n<=1) return 1;

        return n*factorial(n-1);
    }
    
}
