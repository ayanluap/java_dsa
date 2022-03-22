package L2_ArraysAndStrings;

import java.util.*;

// 1. Given an unsorted array 'arr'.
// 2. Reorder it in-place such that :  arr[0] 

// Constraints
// 1. arr.length <= 10^5
// 2. -10^9 <= arr[i] <= 10^9

public class Q174_Q174_WiggleSort1 {
    // ~~~~~~~~~~~~~~User Section~~~~~~~~~~~~~~
    public static void wiggleSort(int[] arr) {
        // write your code here
        for (int i = 0; i < arr.length - 1; i++) {
            if (i % 2 == 0) {
                if (arr[i] > arr[i + 1]) {
                    int t = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = t;
                }
            } else {
                if (arr[i] < arr[i + 1]) {
                    int t = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = t;
                }
            }
        }
    }

    // ~~~~~~~~~~~~Input Management~~~~~~~~~~~~~
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        int n = scn.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }

        wiggleSort(arr);

        for (int val : arr) {
            System.out.print(val + " ");
        }
        System.out.println();
    }

}
