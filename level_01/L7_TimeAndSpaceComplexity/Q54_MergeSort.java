package L7_TimeAndSpaceComplexity;
import java.util.*;

// 1. You are given an array(arr) of integers.
// 2. You have to sort the given array in increasing order using the merge sort.

public class Q54_MergeSort {
    public static int[] mergeSort(int[] arr, int lo, int hi) {
        //write your code here
        if(lo==hi) {
          int res[]=new int[1];
          res[0]=arr[lo];
          return res;
        }
    
        int mid=(lo+hi)/2;
        int arr1[]= mergeSort(arr, lo, mid);
        int arr2[]= mergeSort(arr, mid+1, hi);
        
        int fin[]=mergeTwoSortedArrays(arr1, arr2);
        return fin;
      }
    
      //used for merging two sorted arrays
      public static int[] mergeTwoSortedArrays(int[] a, int[] b){
        System.out.println("Merging these two arrays ");
        System.out.print("left array -> ");
        print(a);
        System.out.print("right array -> ");
        print(b);
        int i = 0, j =0, k = 0;
        int[] ans = new int[a.length + b.length];
        while(i < a.length && j < b.length){
            if(a[i] <= b[j]){
              ans[k] = a[i];
              i++;
              k++;
            }else{
              ans[k] = b[j];
              j++;
              k++;
            }
        }
    
        while(i < a.length){
          ans[k] = a[i];
          k++;
          i++;
        }
    
        while(j < b.length){
          ans[k] = b[j];
          k++;
          j++;
        }
        
        return ans;
      }
    
      public static void print(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
          System.out.print(arr[i] + " ");
        }
        System.out.println();
      }
    
      public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
          arr[i] = scn.nextInt();
        }
        int[] sa = mergeSort(arr,0,arr.length - 1);
        System.out.print("Sorted Array -> ");
        print(sa);
      }
}
