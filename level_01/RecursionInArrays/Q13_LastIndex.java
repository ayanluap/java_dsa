package level_01.RecursionInArrays;
import java.util.*;

// 1. You are given a number n, representing the count of elements.
// 2. You are given n numbers.
// 3. You are given a number x. 
// 4. You are required to find the last index at which x occurs in array a.
// 5. If x exists in array, print the last index where it is found otherwise print -1.

public class Q13_LastIndex {
    public static void main(String[] args) throws Exception {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int arr[]= new int[n];
        for(int i=0; i<n; i++) arr[i]=sc.nextInt();
        int x=sc.nextInt();

        System.out.println(lastIndex(arr, 0, x));
    }

    public static int lastIndex(int[] arr, int idx, int x){
        if(idx==arr.length) return -1;

        int last=lastIndex(arr, idx+1, x);

        if(last==-1){
            if(arr[idx]==x) return idx;
            else return -1;
        }else{
            return last;
        }
    }
}
