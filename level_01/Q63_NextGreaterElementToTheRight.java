import java.io.*;
import java.util.*;

// 1. You are given a number n, representing the size of array a.
// 2. You are given n numbers, representing elements of array a.
// 3. You are required to "next greater element on the right" for all elements of array
// 4. Input and output is handled for you.

public class Q63_NextGreaterElementToTheRight {
    public static void display(int[] a){
        StringBuilder sb = new StringBuilder();
    
        for(int val: a){
          sb.append(val + "\n");
        }
        System.out.println(sb);
      }
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
        int n = Integer.parseInt(br.readLine());
        int[] a = new int[n];
        for(int i = 0; i < n; i++){
           a[i] = Integer.parseInt(br.readLine());
        }
    
        int[] nge = solve(a);
        display(nge);
     }
    
     public static int[] solve(int[] arr){
       // solve
       Stack<Integer> st= new Stack<>();
       int res[]= new int[arr.length];
       Arrays.fill(res, -1);
    
       for(int i=arr.length-1; i>=0; i--){
          if(st.empty()){
            st.push(arr[i]);
          } else if(arr[i]<st.peek()){
            res[i]=st.peek();
            st.push(arr[i]);
          } else{
           while(!st.empty() && arr[i]>=st.peek()) st.pop();
           if(!st.empty()) res[i]= st.peek();
           st.push(arr[i]);
          }
       }
    
       return res;
     }
}
