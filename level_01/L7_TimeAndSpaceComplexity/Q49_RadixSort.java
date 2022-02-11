package L7_TimeAndSpaceComplexity;
import java.util.*;

// 1. You are given an array(arr) of integers.
// 2. You have to sort the given array in increasing order using radix sort.

public class Q49_RadixSort {
    public static void radixSort(int[] arr) {
        // write code here  
          
      }
    
      public static void countSort(int[] arr, int exp) {
        // write code here
        System.out.print("After sorting on " + exp + " place -> ");
        print(arr);
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
        radixSort(arr);
        print(arr);
      }
}
