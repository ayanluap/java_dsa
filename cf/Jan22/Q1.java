package cf.Jan22;
import java.util.*;

public class Q1 {
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        while(n>0){
            int soft=sc.nextInt();
            int ram=sc.nextInt();
            int currRam=ram;

            int arr[][]=new int[soft][2];

            for(int i=0; i<soft; i++){
                arr[i][0]=sc.nextInt();
            }
            for(int j=0; j<soft; j++){
                arr[j][1]=sc.nextInt();
            }

            Arrays.sort(arr,(a,b)->a[0]-b[0]);

            for(int i=0; i<soft; i++){
                if(currRam>=arr[i][0]){
                    currRam+=arr[i][1];
                }else break;
            }
            System.out.println(currRam);

            n--;
        }
    }
}
