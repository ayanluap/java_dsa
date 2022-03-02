package L13_HashmapAndHeap;
import java.io.*;
import java.util.*;

// 1. You are given a number n, representing the size of array a.
// 2. You are given n numbers, representing elements of array a.
// 3. You are required to print the longest sequence of consecutive elements in the array (ignoring duplicates).

// Note -> In case there are two sequences of equal length (and they are also the longest), then print the one for which the starting point of which occurs first in the array.

// Constraints
// 1 <= n <= 30
// 0 <= n1, n2, .. n elements <= 15

public class Q142_LongestConsecutiveSequenceOfElements {
    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner sc= new Scanner(System.in);
    
        int n= sc.nextInt();
        int[] a= new int[n];
        for(int i=0; i<n; i++) a[i]= sc.nextInt();
    
        HashMap<Integer, Boolean> hm= new HashMap<>();
    
        for(int i=0; i<n; i++) hm.put(a[i], true);
    
        for(int i=0; i<n; i++) {
            if(hm.containsKey(a[i]-1)) {
                hm.put(a[i], false);
            }
        }
    
        int ml=0;   // final max. length
        int msp=0; // final starting point
    
        for(int val: a) {
            if(hm.get(val)==true){
                int tl=1;   // temp length
                int tsp=val; // temp starting point
        
                while(hm.containsKey(tsp + tl)) tl++;
        
                if(tl > ml) {
                    msp= tsp;
                    ml= tl;
                }
            }
        }
    
        for(int i=0; i<ml; i++) {
            System.out.println(msp + i);
        }
    
     }
    
}
