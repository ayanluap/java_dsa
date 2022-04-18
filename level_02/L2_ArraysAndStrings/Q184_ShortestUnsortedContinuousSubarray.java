package L2_ArraysAndStrings;

import java.util.*;

// 1. Given an integer array, find the one continuous subarray that if you only sort this subarray in ascending order, then the whole array will be sorted in ascending order.

// 2. Return the shortest such subarray and output its length.

// Constraints
// 1 <= nums.length <= 10000
// -100000 <= nums[i] <= 100000

public class Q184_ShortestUnsortedContinuousSubarray {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }
        System.out.println(findUnsortedSubarray(arr));
    }

    public static int findUnsortedSubarray(int[] nums) {
        // Write your code here
        int ei = -1;
        int si = -1;

        int finder = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (finder > nums[i])
                ei = i;
            else
                finder = nums[i];
        }

        finder = nums[nums.length - 1];
        for (int i = nums.length - 2; i >= 0; i--) {
            if (finder < nums[i])
                si = i;
            else
                finder = nums[i];
        }

        if (ei == -1 && si == -1)
            return 0;
        else
            return ei - si + 1;
    }
}
