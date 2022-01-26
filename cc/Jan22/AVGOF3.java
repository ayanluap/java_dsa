package cc.Jan22;
import java.util.*;

public class AVGOF3 {
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        int tc=sc.nextInt();
        while(tc>0){
            int tot=sc.nextInt();
            int total=tot*3;
            int sum=0;

            ArrayList<Integer> arr=new ArrayList<>();
            for(int i=1; i<3; i++){
                arr.add(i);
            }

            for(int i: arr){
                sum+=i;
            }
            arr.add(Math.abs(total-sum));

            for(int x:arr){
                System.out.print(x+" ");
            }
            System.out.println();
            tc--;
        }
    }
}
