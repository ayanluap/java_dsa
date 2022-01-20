package beginning;
import java.util.*;

public class Variables {
    public static void main(String args[]){
        // VARIABLE
        /* 
        String name="Ayan paul";
        int age=21;
        double cgpa=8.8;
        cgpa=9;

        int a=10;
        int b=5;

        System.out.println((a*b)/(a-b));
        System.out.println(a*b/a-b); 
        */

        // TAKING INPUT FROM USER
        /*
        Scanner sc=new Scanner(System.in);
        String name=sc.next();  // will accept a word not a sentence
        String fullname=sc.nextLine(); // accept sentence
        System.out.println(name);
        System.out.println(fullname); 
        */

        // TAKING TWO INTEGER FROM USER

        Scanner sc=new Scanner(System.in);
        int a=sc.nextInt();
        int b=sc.nextInt();
        int sum=a+b;
        System.out.println("our sum is :"+sum);

        
    }
    
}
