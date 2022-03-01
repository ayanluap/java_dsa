package L13_HashmapAndHeap;
import java.io.*;
import java.util.*;

// 1. You are given a number n1, representing the size of array a1. 2. You are given n1 numbers, representing elements of array a1. 3. You are given a number n2, representing the size of array a2. 4. You are given n2 numbers, representing elements of array a2. 5. You are required to find the intersection of a1 and a2. To get an idea check the example below: if a1 -> 1 1 2 2 2 3 5 and a2 -> 1 1 1 2 2 4 5 intersection is -> 1 1 2 2 5 Note -> Don't assume the arrays to be sorted. Check out the question video.

// Constraints
// 1 <= n1, n2 <= 100 0 <= a1[i], a2[i] < 10 Time complexity should be O(n)

public class Q141_GetCommonElements_2 {
    public static void main(String[] args) throws Exception {
        //Write your code here
      Scanner sc= new Scanner(System.in);
  
      int n1= sc.nextInt();
      int[] a1= new int[n1];
      for(int i=0; i<n1; i++) a1[i]= sc.nextInt();
  
      int n2= sc.nextInt();
      int[] a2= new int[n2];
      for(int i=0; i<n2; i++) a2[i]= sc.nextInt();
  
      HashMap<Integer, Integer> hm= new HashMap<>();
      
      for(int x: a1) {
        if(hm.containsKey(x)) {
          hm.put(x, hm.get(x)+1);
        }else hm.put(x, 1);
      }
  
      for(int x: a2){
        if(hm.containsKey(x) && hm.get(x) > 0) {
          System.out.println(x);
          hm.put(x, hm.get(x)-1);
        }
      }
    }
}
