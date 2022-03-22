package L2_ArraysAndStrings;

import java.util.*;

// 1. Given an array of size 'N' and an element K.
// 2. Task is to find all elements that appears more than N/K times in array.
// 3. Return these elements in an ArrayList in sorted order.

// Constraints
// 1 <= N <= 10^4
// 1 <= a[i] <= 10^6
// 1 <= k <= N

public class Q176_MajorityElementGeneral {
    // ~~~~~~~~~~~~~~~~User Section~~~~~~~~~~~~~~~~~
    public static ArrayList<Integer> majorityElement(int[] arr, int k) {
        // write yout code here
        ArrayList<Integer> res = new ArrayList<>();
        HashMap<Integer, Integer> hm = new HashMap<>();

        for (int el : arr) {
            if (hm.containsKey(el)) {
                hm.put(el, hm.get(el) + 1);
            } else {
                hm.put(el, 1);
            }
        }

        for (int el : hm.keySet()) {
            if (hm.get(el) > (arr.length / k))
                res.add(el);
        }

        Collections.sort(res);
        return res;
    }

    // ~~~~~~~~~~~~~~~Input Management~~~~~~~~~~~~~~~
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }
        int k = scn.nextInt();
        ArrayList<Integer> res = majorityElement(arr, k);
        System.out.println(res);
    }
}
