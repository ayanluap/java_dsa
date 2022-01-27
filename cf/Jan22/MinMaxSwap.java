package cf.Jan22;
import java.util.*;

public class MinMaxSwap {     
    public static void main(String args[]) {
    Scanner sc=new Scanner(System.in);
    int tc=sc.nextInt();

    while(tc>0) {
        int n=sc.nextInt();
        int a[]=new int[n];
        int b[]=new int[n];

        for(int i=0; i<n; i++) a[i]=sc.nextInt();
        for(int i=0; i<n; i++) b[i]=sc.nextInt();

        for(int i=0; i<n; i++){
            if(a[i]<b[i]) {
                int temp=a[i];
                a[i]=b[i];
                b[i]=temp;
            }
        }

        int max1 = Arrays.stream(a).max().getAsInt();
        int max2 = Arrays.stream(b).max().getAsInt();

        System.out.println(max1*max2);

        
        tc--;
        }
    }
}
