package L2_ArraysAndStrings;
import java.util.*;

// 1. Given an array arr of integers (not necessarily distinct).
// 2. We split the array into some number of "chunks" (partitions), and individually sort each chunk.  
// 3. After concatenating them, the result equals the sorted array.
// 4. What is the most number of chunks we could have made?

// Constraints
// 1. arr will have length in range [1, 2000].
// 2. arr[i] will be an integer in range [0, 10^8].

// APPORACH
// 1. last q se yaha ye twist h ki 0 to n-1 tk elem nhi h yaha aur elem can be repeated
// 2. Solution ye h ki ek leftMax array bnao aur ek rightMax
// 3. agr leftMax[i] kabhi v chota hota h rightMax[i+1] tabhi ek chunk mil jaega "res" ko 1 inc. krdo

public class Q169_MaxChunksToMakeArraySorted2 {
    // ~~~~~~~~~~~~~~~User Section~~~~~~~~~~~~~~~~~
	public static int maxChunksToSorted2(int[] arr) {
    	int[] rmin = new int[arr.length + 1];
   	 
    	int val = Integer.MAX_VALUE;
    	rmin[arr.length] = val;
    	for(int i = arr.length - 1; i>= 0; i--) {
        	val = Math.min(val, arr[i]);
        	rmin[i] = val;
    	}
   	 
    	int lmax = Integer.MIN_VALUE;
    	int count = 0;
    	for(int i = 0; i < arr.length; i++) {
        	lmax = Math.max(lmax, arr[i]);
       	 
        	if(lmax <= rmin[i + 1])
            	count++;
    	}
   	 
    	return count;
	}

	// ~~~~~~~~~~~~~~~Input Management~~~~~~~~~~~~~~~~~
	public static void main(String[] args) {
    	Scanner scn = new Scanner(System.in);
    	int n = scn.nextInt();
    	int[] arr = new int[n];

    	for(int i = 0; i < n; i++) {
        	arr[i] = scn.nextInt();
    	}

    	int res = maxChunksToSorted2(arr);
    	System.out.println(res);
	}
}
