
import java.util.*;

public class Functions {
    
    // Func to print sum of two num
    public static int findSum(int x, int y){
        return x+y;
    }

    // Func to return a num mult. with 2
    public static int findProduct(int x, int y){
        return y*x;
    }

    // Find factorial
    public static int findFactorial(int x){
        if(x<=1) return x;
        return x*findFactorial(x-1);
    }

    // Greatest common divisor
    public static int GCD(int x, int y){
        int gcd=0;
        for(int i=1; i<=x && i<=y; i++){
            if(x%i==0 && y%i==0) gcd=i;
        }
        return gcd;
    }


    // Fibonacci series  [Iterative func.]
    public static void fib(int x){
        int n1=0;
        int n2=1;
        int sum=n1+n2;
        for(int i=0; i<x; i++){
            if(i==0) System.out.print(i+" ");
            else {
                System.out.print(sum+" ");
                sum=n1+n2;
                n1=n2;
                n2=sum;
            }
        }
        System.out.println();
    }

    // Fibonacci series  [Recursive func.]
    public static int fibRec(int x){
        if(x<=1) return x;

        return fibRec(x-1)+fibRec(x-2);
    }
    
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        // int num1=sc.nextInt();
        // int num2=sc.nextInt();

        // int sum=findSum(num1, num2);
        // System.out.println("Sum of two numbers : "+sum);
        // System.out.println("Product of two numbers : "+findProduct(num1, num2));
        // System.out.println("factorial of"+num1+" is : "+findFactorial(num1));
        // System.out.println("GCD of "+num1+" & "+num2+" is : "+GCD(num1, num2));

        fib(15);
        System.out.println(fibRec(15));

    }
}
