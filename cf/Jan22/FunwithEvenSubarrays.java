package cf.Jan22;
import  java.util.*;

public class FunwithEvenSubarrays {
    public static void main(String args[]) {
    Scanner sc=new Scanner(System.in);
     
    int tc=sc.nextInt();
    while(tc>0) {
        int n=sc.nextInt();
        int arr[]=new int[n];

        for(int i=0; i<n; i++){
            arr[i]=sc.nextInt();
        }

        if(n<2) {
            System.out.println(0);
            return;
        }
        int op=0;
        int temp=arr[n-1]; int l=1; int k=n-2;
        while(k>= 0){
            if(arr[k]!=temp){
                op++;
                k-=l;
            }
            k--;
            l++;
        }
        System.out.println(op);
        tc--;
        }
    }
}


// ans = 0,val = a[n-1],l=1,j = n-2;
//         while(j>= 0)
//         {
//             while(j >= 0 && a[j] == val) {
//                 l++;
//                 j--;
//             }
//             if(j < 0) break;
//             ans++;
//             j-= l;
//             l *= 2;
//         }
//         cout<<ans<<endl;