package L2_ArraysAndStrings;
import java.util.*;

// 1. You are given an n x n 2D matrix representing an image.
// 2. rotate the image by 90 degrees (clockwise).
// 3. You have to rotate the image in-place, which means you have to modify the input 2D matrix directly. 
// 4. DO NOT allocate another 2D matrix and do the rotation.

// Constraints
// 1. matrix.length == n
// 2. matrix[i].length == n
// 3. 1 <= n <= 20
// 4. -1000 <= matrix[i][j] <= 1000

public class Q185_RotateImage {
    // ~~~~~~~~~~~~~User Section~~~~~~~~~~~~~
    public static void rotate(int[][] matrix) {
        // write your code here
    int n= matrix.length;

    // Transpose
    for(int i=0; i<n; i++) {
      for(int j=i; j<n; j++) {
        int t= matrix[i][j];
        matrix[i][j]= matrix[j][i];
        matrix[j][i]= t;
      }
    }

    // Swap
    for(int i=0; i<n; i++) {
      int s= 0, e= n-1;
      while(s<e) {
        int t= matrix[i][s];
        matrix[i][s]= matrix[i][e];
        matrix[i][e]= t;

        s++;
        e--;
      }
    }
    }

    // ~~~~~~~~~~~Input Management~~~~~~~~~~~
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[][] matrix = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = scn.nextInt();
            }
        }
        rotate(matrix);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
