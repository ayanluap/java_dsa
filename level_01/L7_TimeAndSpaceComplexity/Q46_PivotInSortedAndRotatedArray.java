package L7_TimeAndSpaceComplexity;
import java.util.*;

// 1. You are given an array(arr) of distinct integers, which is sorted and rotated around an unknown point.
// 2. You have to find the smallest element in O(logN) time-complexity

public class Q46_PivotInSortedAndRotatedArray {
    static Scanner sc=new Scanner(System.in);
    public static void main(String args[]){
        int n=sc.nextInt();
        int arr[]=new int[n];
        for(int i=0; i<n; i++) arr[i]=sc.nextInt();

        System.out.println(pivot(arr));
    }

    public static int pivot(int arr[]){
        int i=0; int j=arr.length-1;
        while(i<j){
            int mid= (i+j)/2;
            if(arr[mid]>arr[j]) i=mid+1;
            else j=mid;
        }

        return arr[i];
    }
}
