package L7_TimeAndSpaceComplexity;
import java.util.*;

// 1. You are given two sorted arrays(a,b) of integers.
// 2. You have to merge them and form one sorted array.
// 3. You have to do it in linear time complexity.

public class Q53_MergeTwoSortedArrays {
    public static int[] mergeTwoSortedArrays(int[] a, int[] b){
        //write your code here
        int merged[]=new int[a.length+b.length];
        int i=0, j=0, k=0;
    
        while(i<a.length && j<b.length){
          if(a[i]<b[j]) merged[k++]=a[i++];
          else merged[k++]=b[j++];
        }
    
        while(i<a.length) merged[k++]=a[i++];
        while(j<b.length) merged[k++]=b[j++];
        
        return merged;
      }
    
      public static void print(int[] arr){
        for(int i = 0 ; i < arr.length; i++){
          System.out.println(arr[i]);
        }
      }
      public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] a = new int[n];
        for(int i = 0 ; i < n; i++){
          a[i] = scn.nextInt();
        }
        int m = scn.nextInt();
        int[] b = new int[m];
        for(int i = 0 ; i < m; i++){
          b[i] = scn.nextInt();
        }
        int[] mergedArray = mergeTwoSortedArrays(a,b);
        print(mergedArray);
      }
}
