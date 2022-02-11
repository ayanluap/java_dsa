
import java.util.*;

public class Loops {
    public static void main(String agrs[]){
        Scanner sc=new Scanner(System.in);
        ///// FOR LOOP

        // for(int i=0;i<100;i++) System.out.println("Hello world!");

        ///// WHILE LOOP

        // int i=5;
        // while(i>0){
        //     System.out.println("Hello world!");
        //     i--;
        // }

        ///// DO WHILE LOOP (Atleast run once)

        // int i=0;
        // do{
        //     System.out.println("Hello world!");
        //     i--;
        // }while(i>0);

        ///// PRINT NUM FROM 0-10

        // int i=0;
        // while(i<=10){
        //     System.out.print(i++ +" ");
        // }

        ///// SUM OF n NAT. NUMBERS

        // int n=sc.nextInt();
        // int ans=0;
        // while(n>0){
        //     ans+=n;
        //     n--;
        // }
        // System.out.println(ans);

        ///// PRint table of number n
        int n=sc.nextInt();
        int i=1;
        while(i<=10){
            System.out.println(n+" x "+i+" = "+n*i);
            i++;
        }
    }
}
