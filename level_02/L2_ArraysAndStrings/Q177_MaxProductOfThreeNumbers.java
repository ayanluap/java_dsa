package L2_ArraysAndStrings;
import java.util.*;

// 1. Given an integer array 'arr',
// 2. Find three numbers whose product is maximum and return the maximum product.

// Constraints
// 1. 3 <= nums.length <= 10^4
// 2. -1000 <= nums[i] <= 1000

// Format
// Input
// (Already managed for you)
// 4
// 1 2 3 4

// Output
// (Already managed for you)
// 24

public class Q177_MaxProductOfThreeNumbers {
    // ~~~~~~~~~~~~~~~~User Section~~~~~~~~~~~
    public static int maximumProduct(int[] arr) {
        // write your code here
        Arrays.sort(arr);

        if(arr.length==3) return arr[0]*arr[1]*arr[2];

        int n= arr.length;

        int r1= arr[n-1] * arr[n-2] * arr[n-3];
        int r2= arr[0] * arr[1] * arr[n-1];

        if(r1 > r2) return r1;
        else return r2;
    }

    // ~~~~~~~~~~~~~~~~Input Management~~~~~~~~~~~
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];

        for(int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }

        int prod = maximumProduct(arr);
        System.out.println(prod);
    }
}
