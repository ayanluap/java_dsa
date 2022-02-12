package L7_TimeAndSpaceComplexity;
import java.util.*;

// 1. You are given an array(arr) of integers.
// 2. You have to sort the given array in increasing order using radix sort.

public class Q49_RadixSort {
    public static void radixSort(int[] arr) {
        // write code here  
          int max=Integer.MIN_VALUE;
          for(int x: arr) if(x>max) max=x;
          int maxPlace=1;

          while(maxPlace<=max){
            countSort(arr, maxPlace);

            maxPlace*=10;
            // max/=10;
          }
      }
    
      public static void countSort(int[] arr, int exp) {
        // write code here
        int digitArr[]=new int[10];
        int duplicate[]=new int[arr.length];

        for(int i=0; i<arr.length; i++){
          digitArr[(arr[i]/exp) % 10]++;
        }
        for(int i=0; i<digitArr.length-1; i++) digitArr[i+1]+=digitArr[i];
        for(int i=arr.length-1; i>=0; i--){
          digitArr[(arr[i]/exp) % 10]--;
          duplicate[digitArr[(arr[i]/exp) % 10]]=arr[i];
        }

        for(int i=0; i<arr.length; i++) arr[i]=duplicate[i]; 

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
