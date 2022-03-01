package L13_HashmapAndHeap;
import java.io.*;
import java.util.*;

// 1. You are given a number n1, representing the size of array a1.
// 2. You are given n1 numbers, representing elements of array a1.
// 3. You are given a number n2, representing the size of array a2.
// 4. You are given n2 numbers, representing elements of array a2.
// 5. You are required to print all elements of a2 which are also present in a1 (in order of their occurence in a2). Make sure to not print duplicates (a2 may have same value present many times).

// Constraints
// 1 <= n1, n2 <= 100
// 0 <= a1[i], a2[i] < 10
// Time complexity should be O(n)

public class Q140_GetCommonElements_1 {
    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner sc= new Scanner(System.in);
        
        int n1= sc.nextInt();
        int[] a1= new int[n1];
        for(int i=0; i<n1; i++) a1[i]= sc.nextInt();
    
        int n2= sc.nextInt();
        int[] a2= new int[n2];
        for(int i=0; i<n2; i++) a2[i]= sc.nextInt();
    
        HashMap<Integer, Integer> hm1= new HashMap<>();
    
        for(int x: a1) hm1.put(x, 1);
        for(int x: a2) {
            if(hm1.containsKey(x)) {
                System.out.println(x);
                hm1.remove(x);
            }
        }
     }
}
