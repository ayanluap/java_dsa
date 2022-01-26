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
            ArrayList<Integer> arr=new ArrayList<>();

            if(x>lenSub) {
                System.out.println(-1);
                return;

            } else {
                for(int i=0; i<len; i++){
                    int l=lenSub-i-1;
                    if(l<x){
                        arr.add(Math.abs(l));
                    }else{
                        l/=x;
                        arr.add(Math.abs(l));
                    }
                }
            }


            for(int i: arr) System.out.print(i+" ");
            System.out.println();
            tc--;
        }
    }
}
