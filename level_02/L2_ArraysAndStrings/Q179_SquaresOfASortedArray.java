package L2_ArraysAndStrings;

import java.util.*;

// 1. Given an integer array 'nums' sorted in non-decreasing order.
// 2. Return an array of the squares of each number sorted in non-decreasing order.

// Constraints
// 1. 1 <= nums.length <= 10^4
// 2. -10^4 <= nums[i] <= 10^4
// 3. 'nums' is sorted in non-decreasing order.

public class Q179_SquaresOfASortedArray {
    // ~~~~~~~~~~~~~~~~~~~~~User Section~~~~~~~~~~~~~~~~~~~~~

    public static int[] sortedSquares(int[] nums) {
        // write your code here
        int res[] = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            res[i] = nums[i] * nums[i];
        }
        Arrays.sort(res);

        return res;
    }

    // ~~~~~~~~~~~~~~~~~~~Input Management~~~~~~~~~~~~~~~~~~~

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] nums = new int[n];

        for (int i = 0; i < n; i++)
            nums[i] = scn.nextInt();

        int[] res = sortedSquares(nums);

        for (int i = 0; i < n; i++) {
            System.out.print(res[i] + " ");
        }
    }
}
