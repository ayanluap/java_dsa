package L7_TimeAndSpaceComplexity;
import java.util.*;

// 1. You are given an array(arr) of distinct integers and a target.
// 2. You have to print all the pairs having their sum equal to the target.

public class Q60_TargetSumPair1 {
    public static void targetSumPair(int[] arr, int target){
        //write your code here
        int res[]= mergeSort(arr, 0, arr.length-1);
        
        int i=0,j=res.length-1;
        while(i<=j){
          if(res[i]+res[j] > target) j--;
          else if(res[i]+res[j] < target) i++;
          else {
            System.out.println(res[i]+", "+res[j]);
            i++; j--;
          }
        }
      }
    
      public static int[] mergeSort(int arr[], int i, int j){
        if(i==j) {
          int bc[]=new int[1];
          bc[0]= arr[i];
          return bc;
        }
    
        int mid= (i+j)/2;
        int arr1[]= mergeSort(arr, i, mid);
        int arr2[]= mergeSort(arr, mid+1, j);
    
        int res[]= mergeTwoArrays(arr1, arr2);
        return res;
      }
    
      public static int[] mergeTwoArrays(int a[], int b[]){
        int res[]= new int[a.length+b.length];
    
        int i=0,j=0,k=0;
    
        while(i<a.length && j<b.length){
          if(a[i]<b[j]) res[k++]=a[i++];
          else res[k++]=b[j++];
        }
        while(i<a.length) res[k++]=a[i++];
        while(j<b.length) res[k++]=b[j++];
    
        return res;
      }
    
      public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for(int i = 0 ;i < n; i++){
          arr[i] = scn.nextInt();
        }
        int target = scn.nextInt();
        targetSumPair(arr,target);
      }
}
