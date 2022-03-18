package L2_ArraysAndStrings;
import java.util.*;

// 1. Given an array arr that is a permutation of [0, 1, ..., arr.length - 1].
// 2. We split the array into some number of "chunks" (partitions), and individually sort each chunk. 
// 3. Shuffling of chunk is not allowed.
// 4. After concatenating them, the result equals the sorted array.
// 5. What is the most number of chunks we could have made?

// Constraints
// 1. arr will have length in range [1, 10].
// 2. arr[i] will be a permutation of [0, 1, ..., arr.length - 1].

// APPROACH
// 1. hr ek elem pe visit krte krte max dekho
// 2. agr current index aur max equal h to result increase kro
// 3. edge case length 1 k lie return 1 krdo

public class Q168_MaxChunksToMakeArraySorted {
     // ~~~~~~~~~~~~~~~User Section~~~~~~~~~~~~~~~~~~
     public static int maxChunksToSorted(int[] arr) {
        // write your code here   
        int res= 0;
        int max= arr[0];
        
        if(arr.length == 1) return 1;

        for(int i=0; i<arr.length; i++) {
            max= Math.max(max, arr[i]);
            if(i == max) {
                res++;
            }
        }

        return res;
    }

    // ~~~~~~~~~~~~Input Management~~~~~~~~~~~~~~~~
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];

        for(int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }

        int res = maxChunksToSorted(arr);
        System.out.println(res);
    }    
}
