import java.util.*;
import java.io.*;

// 1. You are given a number n, representing the size of array a.
// 2. You are given n numbers, representing the elements of array a.
// 3. You are given a number k, representing the size of window.
// 4. You are required to find and print the maximum element in every window of size k.

public class Q66_SlidingWindowMaximum {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
        int n = Integer.parseInt(br.readLine());
        int[] a = new int[n];
        for(int i = 0; i < n; i++){
           a[i] = Integer.parseInt(br.readLine());
        }
        int k = Integer.parseInt(br.readLine());
    
        // code
        int temp[]= new int[a.length];
        Stack<Integer> st=new Stack<>();
    
        for(int i=a.length-1; i>=0; i--){
          while(!st.empty() && a[i]>=a[st.peek()]) st.pop();
    
          if(st.empty()) temp[i]=a.length;
          else temp[i]=st.peek();
    
          st.push(i);
        }
       
       int j=0;
       for(int i=0; i<=a.length-k; i++){
          if(j<i) j=i;
          while(temp[j]<i+k) {
             j= temp[j];
          }
          
          System.out.println(a[j]);
       }
    
     }

    

   
}

