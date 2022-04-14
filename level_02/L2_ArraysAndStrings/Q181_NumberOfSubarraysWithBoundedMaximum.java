package L2_ArraysAndStrings;

import java.util.*;

// 1. We have an array 'arr' of positive integers, and two positive integers left and right (left is smaller than right).
// 2. Return the number of (contiguous, non-empty) subarrays such that the value of the maximum array element in that subarray is at least left and at most right.

// Constraints
// 1. left, right, and arr[i] will be an integer in the range [0, 10^9].
// 2. The length of arr will be in the range of [1, 10000].

public class Q181_NumberOfSubarraysWithBoundedMaximum {
  public static int numSubarrayBoundedMax(int[] arr, int left, int right) {
    // write your code here
    int res = 0;
    int prev = 0;

    int si = 0;
    int ei = 0;

    while (ei < arr.length) {
      if (arr[ei] >= left && arr[ei] <= right) {
        prev = ei - si + 1;
        res += prev;
      } else if (arr[ei] < left) {
        res += prev;
      } else if (arr[ei] > right) {
        si = ei + 1;
        prev = 0;
      }

      ei++;
    }

    return res;
  }

  public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    int[] arr = new int[n];
    for (int i = 0; i < n; i++) {
      arr[i] = scn.nextInt();
    }

    int left = scn.nextInt();
    int right = scn.nextInt();

    int count = numSubarrayBoundedMax(arr, left, right);
    System.out.println(count);
  }
}
