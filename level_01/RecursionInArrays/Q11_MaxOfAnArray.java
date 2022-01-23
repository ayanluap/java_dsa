package level_01.RecursionInArrays;
import java.util.*;

// 1. You are given a number n, representing the count of elements.
// 2. You are given n numbers.
// 3. You are required to find the maximum of input. 
// 4. For the purpose complete the body of maxOfArray function. Don't change the signature.

public class Q11_MaxOfAnArray {
    public static void main(String[] args) throws Exception {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int arr[]=new int[n];

        for(int i=0; i<n; i++){
            arr[i]=sc.nextInt();
        }
        System.out.println(maxOfArray(arr, 0));
    }

    public static int maxOfArray(int[] arr, int idx){
        if(idx==arr.length-1) return arr[idx];

        int max=maxOfArray(arr, idx+1);
        if(arr[idx] > max) return arr[idx];
        else return max;
    }
}
