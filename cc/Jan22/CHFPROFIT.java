package cc.Jan22;
import java.util.*;

public class CHFPROFIT {
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        int tc=sc.nextInt();
        while(tc>0){
            int num=sc.nextInt();
            int cost=sc.nextInt();
            int sell=sc.nextInt();

            System.out.println((num*sell) - (num*cost));

            tc--;
        }
    }
}
