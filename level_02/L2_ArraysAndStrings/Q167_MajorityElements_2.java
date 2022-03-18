package L2_ArraysAndStrings;
import java.util.*;

// 1. Given an integer array of size 'n'.
// 2. Find all elements that appear more than n / 3 times and return it in an arraylist.
// 3. Note : solve the problem in linear time and in O(1) space.

// Constraints
// 1. 1 <= arr.length <= 10^4
// 2. -10 ^ 9 <= arr[i] <= 10^9

public class Q167_MajorityElements_2 {
   // ~~~~~~~~~~~~~~~~~~~~~User Section~~~~~~~~~~~~~~~~~~~~~
   public static ArrayList<Integer> majorityElement2(int[] arr) {
    // write your code here
    ArrayList<Integer> res= new ArrayList<>();

    int v1=arr[0], v2=0;
    int c1=1, c2=0;

    for(int i=1; i<arr.length; i++) {
        if(arr[i]==v1) c1++;
        else if(arr[i]==v2) c2++;
        else {
            if(c1==0) {
                v1= arr[i];
                c1= 1;
            } else if(c2==0) {
                v2= arr[i];
                c2= 1;
            } else {
                // mtlb 3 ka pair bn gya 1 reduce krdo sbse
                c1--;
                c2--;
            }
        }
    }

    // n/3 elem find krne h to bs 2 hi possible value ho skte h 
    // aur valid candidates v1 & v2 m pde hue h

    int count= 0; 
    for(int el: arr) if(el==v1) count++; //checking if fiest candiate appears n/3 times or not
    if(count > arr.length/3) res.add(v1);

    // doing the same for the second candidate
    count= 0;
    for(int el: arr) if(el==v2) count++; //checking if fiest candiate appears n/3 times or not
    if(count > arr.length/3) res.add(v2);

    return res;
}

// ~~~~~~~~~~~~~~~~~~~Input Management~~~~~~~~~~~~~~~~~~~
public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();

    int[] arr = new int[n];
    for(int i = 0; i < n; i++) {
        arr[i] = scn.nextInt();
    }

    ArrayList<Integer> res = majorityElement2(arr);
    System.out.println(res);
}
}
