package L7_TimeAndSpaceComplexity;
import java.util.*;

// 1. You are given an array(arr) containing only 0's, 1's, and 2's.
// 2. You have to sort the given array in increasing order and in linear time.

public class Q47_Sort012 {
    public static void sort012(int[] arr){
        //write your code here
        int i=0; int k=i; int j=arr.length-1;
        
        while(k<j){
            if(arr[k]==0){
                swap(arr, i, k);
                i++;
                k++;
            }else if(arr[k]==1){
                k++;
            }else if(arr[k]==2){
                swap(arr, k, j);
                j--;
            }
        }
        
      }
    
      // used for swapping ith and jth elements of array
      public static void swap(int[] arr, int i, int j) {
        System.out.println("Swapping index " + i + " and index " + j);
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
      }
    
      public static void print(int[] arr){
        for(int i = 0 ; i < arr.length; i++){
          System.out.println(arr[i]);
        }
      }
      public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for(int i = 0 ;i < n; i++){
          arr[i] = scn.nextInt();
        }
        sort012(arr);
        print(arr);
      }
    
}
