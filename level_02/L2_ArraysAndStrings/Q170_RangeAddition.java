package L2_ArraysAndStrings;
import java.util.*;

//  1. You are given a number N.
//  2. Assume you have an array of length N initialised with all 0's.
//  3. You are also given K update operations.
//  4. Each operation contain 3 numbers: startIndex, endIndex and inc and updates each element of the subarray arr[startIndex, endIndex](both inclusive) with inc.
//  5. You have to find the resultant array when all K operations are executed.
//  6. display is a utility function, feel free to use it for debugging purposes.
//  7. main takes input from the users.
//  8. This is a functional problem. 
//  9. You have to complete the getModifiedArray function. It takes as input a length and a 2D array of update operations. It should return the modified array.
//  10. Don't change the code of main and display.

// Expected Complexity : O(n+k)

// Constraints
// 1 <= N <= 30000

public class Q170_RangeAddition {
    public static int[] Range(int length, int[][] updates) {
        // write your code here. 
        int res[]= new int[length];
        int rows= updates.length;

        for(int r=0; r<rows; r++) {
            int start= updates[r][0];
            int end= updates[r][1];
            int inc= updates[r][2];

            res[start]+= inc;
            if(end + 1 < length) res[end+1]-= inc; 
        } 

        for(int i=0; i<length-1; i++) {
            res[i+1]+= res[i]; 
        } 

        return res;
        
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input for length of first array.
        int length = sc.nextInt();

        int K = sc.nextInt();

        int[][] updates = new int[K][3];

        for (int i = 0; i < updates.length; i++) {
            for (int j = 0; j < updates[0].length; j++) {
                updates[i][j] = sc.nextInt();
            }
        }

        int[] result = Range(length, updates);
        display(result);
    }

    // function to display an array.
    public static void display(int[] arr) {

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }

        System.out.println();
    }
}
