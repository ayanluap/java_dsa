package L7_TimeAndSpaceComplexity;
import java.util.*;

// 1. You are given an array(arr) of integers.
// 2. You have to sort the given array in increasing order using count sort.

public class Q50_CountSort {
    public static void countSort(int[] arr, int min, int max) {
        //write your code here
        int freq[]=new int[(max-min)+1];
        int mod[]=new int[arr.length];

        for(int i=0; i<arr.length; i++) {
            freq[arr[i]-min]++;
        }

        for(int i=0; i<freq.length-1; i++){
            freq[i+1]+=freq[i];
        }

        for(int i=arr.length-1; i>=0; i--) {
            freq[arr[i]-min]--;
            mod[freq[arr[i]-min]] = arr[i];
        }

        for(int i=0; i<mod.length; i++) arr[i]=mod[i];
    }
     
       public static void print(int[] arr) {
            for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
            }
       }
     
       public static void main(String[] args) throws Exception {
         Scanner scn = new Scanner(System.in);
         int n = scn.nextInt();
         int[] arr = new int[n];
         int max = Integer.MIN_VALUE;
         int min = Integer.MAX_VALUE;
         for (int i = 0; i < n; i++) {
           arr[i] = scn.nextInt();
           max = Math.max(max, arr[i]);
           min = Math.min(min, arr[i]);
         }
         countSort(arr,min,max);
         print(arr);
       }
}
