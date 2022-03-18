package L2_ArraysAndStrings;
import java.util.*;

// 1. Give an array of size 'n'.
// 2. Find Majority element and print it(if exist), otherwise print "No Majority Element exist".
// 3. Majority element-> if frequency of an element is more than n/2, then that element is majority element.
// 3. Note : solve the problem in linear time and in O(1) space.

// Constraints
// 1. 1 <= n <= 10^4
// 2. -10^9 < arr[n] < 10^9

public class Q166_MajorityElement_I {
    public static void printMajorityElement(int[] arr) {
        // write your code here
        HashMap<Integer, Integer> hm= new HashMap<>();
        int res=-1;

        for(int x: arr) {
            if(hm.containsKey(x)) {
                hm.put(x, hm.get(x)+1);
            }else {
                hm.put(x, 1);
            }
        }

        for(int x: hm.keySet()) {
            if(hm.get(x) > arr.length/2) res= x;
        }

        if(res == -1) System.out.println("No Majority Element exist");
        else System.out.println(res);
        
    }

    // Mooore's vooting algo (without hashmap whicj takes O(n) space)
    public static int validCandidateUsing_mooreVooting(int[] arr) {
        int res=arr[0];
        int count= 1;

        for(int i=1; i<arr.length; i++) {
            if(res==arr[i]) {
                count++;
            } else {
                count--;
            }
            if(count==0) {
                res= arr[i];
                count= 1;
            }
        }
        return res;
    }

    public static void printMajorityElementAlgo(int[] arr) {
        // write your code here
        int validKey= validCandidateUsing_mooreVooting(arr);
        int count= 0;
        for(int x: arr) {
            if(x==validKey) count++;
        }

        if(count > arr.length/2) System.out.println(count);
        else System.out.println(-1);
    }

    // ~~~~~~~~~~~~~~~~~~~Input Management~~~~~~~~~~~~~~~~~~~

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();

        int[] arr = new int[n];

        for(int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }

        printMajorityElement(arr);
        printMajorityElementAlgo(arr);
    }
}
