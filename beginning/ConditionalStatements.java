package beginning;

import java.util.*;

public class ConditionalStatements {
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        
        // PROGRAM OF IS_ADULT
        
        // System.out.println("\nAre you an Adult?\n");
        // int age=sc.nextInt();
        // if(age>=18){
        //     System.out.println("Yes! You are an ADULT");
        // }else {
        //     System.out.println("No! You are NOT an ADULT");
        // }
        
        // PROGRAM OF IS_EVEN

        // int num=sc.nextInt();
        // if(num%2==0) System.out.println(num+" is an EVEN number!");
        // else System.out.println(num+" is an ODD number!");

        // IS_EQUAL

        // int a=sc.nextInt();
        // double b=sc.nextDouble();
        // if(a<b) System.out.println("a is smaller");
        // else if(a>b) System.out.println("a is greater");
        // else System.out.println("a is equal to b");

        // SWITCH IN JAVA

        int num=sc.nextInt();
        switch(num){
            case 1: System.out.println("Hello");
            break;
            case 2: System.out.println("Namaste");
            break;
            case 3: System.out.println("Bonjour");
            break;
            default: System.out.println("Invalid input!");
        }
    }
}
