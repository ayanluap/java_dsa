package L8_StacksAndQueues;
import java.util.*;
import java.io.*;

// 1. You are given a number n, representing the size of array a.
// 2. You are given n numbers, representing the height of bars in a bar chart.
// 3. You are required to find and print the area of largest rectangle in the histogram.

public class Q65_LargestAreaHistogram {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
        int n = Integer.parseInt(br.readLine());
        int[] a = new int[n];
        for(int i = 0; i < n; i++){
           a[i] = Integer.parseInt(br.readLine());
        }
    
        // code
        System.out.println(LargestAreaHist(a));
     }
    
     public static int LargestAreaHist(int arr[]){
       Stack<Integer> st=new Stack<>();
       int nstl[]=new int[arr.length];
       int nstr[]=new int[arr.length];
       int max=Integer.MIN_VALUE;
    
        for(int i=0; i<arr.length; i++){
          while(!st.empty() && arr[st.peek()]>=arr[i]){
            st.pop();
          }
    
          if(st.empty()) nstl[i]= -1;
          else nstl[i]= st.peek();
    
          st.push(i);
        }
    
        st.clear();
        
        for(int i=arr.length-1; i>=0; i--){
          while(!st.empty() && arr[st.peek()]>=arr[i]){
            st.pop();
          }
    
          if(st.empty()) nstr[i]= arr.length;
          else nstr[i]= st.peek();
    
          st.push(i);
        }
    
        for(int i=0; i<arr.length; i++){
          int area= arr[i] * Math.abs((nstr[i]-nstl[i])-1);
          if(area > max) max=area;
        }
    
       return max;
     }
}
