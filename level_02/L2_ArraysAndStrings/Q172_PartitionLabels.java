package L2_ArraysAndStrings;

import java.util.*;

// 1. A string 's' of lowercase English letters is given. 
// 2. We want to partition this string into as many parts as possible so that each letter appears in at most one part.
// 3. Return a list of integers representing the size of these parts.

// Constraints
// 1. 's' will have length in range [1, 500].
// 2. 's' will consist of lowercase English letters ('a' to 'z') only.

// Format
// Input
// s = "ababcbacadefegdehijhklij"

// Output
// [9,7,8]

// Explanation:
// The partition is "ababcbaca", "defegde", "hijhklij".
// This is a partition so that each letter appears in at most one part.
// A partition like "ababcbacadefegde", "hijhklij" is incorrect, because it splits s into less parts.

public class Q172_PartitionLabels {

    // ~~~~~~~~~~~~~~~User Section~~~~~~~~~~~~~~~
    public static List<Integer> partitionLabels(String s) {
        // write your code here
        List<Integer> res = new ArrayList<>();
        HashMap<Character, Integer> hm = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            hm.put(ch, i);
        }

        int lastIdx = 0;
        int maxIdx = -1;

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            maxIdx = Math.max(hm.get(ch), maxIdx);

            if (i == maxIdx) {
                res.add(maxIdx - lastIdx + 1);
                lastIdx = maxIdx + 1;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();

        List<Integer> res = partitionLabels(s);
        for (int val : res) {
            System.out.print(val + " ");
        }
    }
}
