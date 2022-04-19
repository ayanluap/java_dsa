package L2_ArraysAndStrings;

import java.util.*;

// 1. Given an array nums of non-negative integers.
// 2. Arrange elements of array in specific order, all even elements followed by odd elements. [even -> odd]
// 3. Preserve the order of Even elements without using extra space.
// 4. Hence question is order specific so you have to match your output in order of given output.

// Constraints
// 1. 1 <= nums.length <= 5000
// 2. 0 <= nums[i] <= 5000

public class Q190_SortArrayByParity {
    public static void sortArrayByParity(int[] nums) {
        // write your code here
        int i = 0;
        int j = i + 1;

        while (j < nums.length) {
            while (nums[i] % 2 == 0)
                i++;
            if (j <= i)
                j = i + 1;

            if (nums[j] % 2 == 0) {
                int t = nums[i];
                nums[i] = nums[j];
                nums[j] = t;
                i++;
            }

            j++;
        }
    }

    //// ~~~~~~~~~~~~~~~~~~Input Management~~~~~~~~~~~~~~~~~
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }

        sortArrayByParity(arr);

        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
