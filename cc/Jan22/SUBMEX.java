package cc.Jan22;
import java.util.*;

public class SUBMEX {
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        int tc=sc.nextInt();
        while(tc>0){
            int len=sc.nextInt();
            int lenSub=sc.nextInt();
            int x=sc.nextInt();

            if(x>lenSub) {
                System.out.println(-1);
            } 
            else {
                for(int i=0; i<len; i++){
                    System.out.print(i%x+" ");
                }
                System.out.println();
            }
            tc--;
        }
    }
}
