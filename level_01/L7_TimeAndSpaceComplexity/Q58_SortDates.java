package L7_TimeAndSpaceComplexity;
import java.util.*;

// 1. You are given an array(arr) of different dates in format DD-MM-YYYY.
// 2. You have to sort these dates in increasing order.

public class Q58_SortDates {
    public static void sortDates(String[] arr) {
        // write your code here
        countSort(arr, 1000000, 100, 32); //days
        countSort(arr, 10000, 100, 13); //months
        countSort(arr, 1, 10000, 9999); //years
      }
    
      public static void countSort(String[] arr,int div, int mod, int range) {
        // write your code here
         int fr[]=new int[range];
         String dup[]=new String[arr.length];
    
         for(int i=0; i<arr.length; i++){
           fr[Integer.parseInt(arr[i])/div % mod]++;
         }
         for(int i=1; i<fr.length; i++) fr[i]+=fr[i-1];
         for(int i=arr.length-1; i>=0; i--){
           fr[Integer.parseInt(arr[i])/div % mod]--;
            dup[fr[Integer.parseInt(arr[i])/div % mod]]=arr[i];
         } 
    
         for(int i=0; i<arr.length; i++) arr[i]=dup[i];
      }
    
      public static void print(String[] arr) {
        for (int i = 0; i < arr.length; i++) {
          System.out.println(arr[i]);
        }
      }
    
      public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        String[] arr = new String[n];
        for (int i = 0; i < n; i++) {
          String str = scn.next();
          arr[i] = str;
        }
        sortDates(arr);
        print(arr);
      }
}
