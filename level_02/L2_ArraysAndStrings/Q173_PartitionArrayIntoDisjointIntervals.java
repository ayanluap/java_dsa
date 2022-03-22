package L2_ArraysAndStrings;

import java.util.*;

// 1. Given an integer array nums.
// 2. Partition it into two (contiguous) subarrays left and right so that:
//     a. Every element in left is less than or equal to every element in right.
//     b. Left and right are non-empty.
//     c. Left has the smallest possible size.
// 3. Return the length of left after such a partitioning.
// NOTE : Test cases are generated such that partitioning exists.

// Constraints
// 1. 2 <= nums.length <= 10^5
// 2. 0 <= nums[i] <= 10^6
// 3. There is at least one valid answer for the given input.

// Format
// Input
// Input is Managed for You
// nums = [5,0,3,8,6]

// nums = [1,1,1,0,6,12]

// Output
// 3
// Explanation: left = [5,0,3], right = [8,6]

// 4
// Explanation: left = [1,1,1,0], right = [6,12]

public class Q173_PartitionArrayIntoDisjointIntervals {
    // ~~~~~~~~~~~~~~User''s Section~~~~~~~~~~~~~~~
    public static int partitionDisjoint(int[] arr) {
        // write your code here
        int leftMax = Integer.MIN_VALUE;

        int[] rightMin = new int[arr.length];
        rightMin[arr.length - 1] = arr[arr.length - 1];

        for (int i = arr.length - 2; i >= 0; i--) {
            rightMin[i] = Math.min(rightMin[i + 1], arr[i]);
        }

        int res = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            leftMax = Math.max(leftMax, arr[i]);

            if (leftMax < rightMin[i + 1]) {
                res= i;
                break;
            }
        }
        
        return res + 1;
    }

    // ~~~~~~~~~~~~~Input Management~~~~~~~~~~~~~~~
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }

        int len = partitionDisjoint(arr);
        System.out.println(len);
    }
}
