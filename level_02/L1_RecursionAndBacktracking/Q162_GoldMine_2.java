package L1_RecursionAndBacktracking;
import java.io.*;
import java.util.*;

// 1. You are given a number n, representing the number of rows.
// 2. You are given a number m, representing the number of columns.
// 3. You are given n*m numbers, representing elements of 2d array a, which represents a gold mine.
// 4. You are allowed to take one step left, right, up or down from your current position.
// 5. You can't visit a cell with 0 gold and the same cell more than once. 
// 6. Each cell has a value that is the amount of gold available in the cell.
// 7. You are required to identify the maximum amount of gold that can be dug out from the mine if 
//      you start and stop collecting gold from any position in the grid that has some gold.

// Note -> Check out the question video and write the recursive code as it is intended without 
//                changing signature. The judge can't force you but intends you to teach a concept.

// Constraints
// 1 <= n <= 10
// 1 <= m <= 10
// 0 <= e1, e2, .. n * m elements <= 1000

public class Q162_GoldMine_2 {
    static int max = 0;
	public static void getMaxGold(int[][] arr){
		//write your code here
		
        
		
	}
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int m = scn.nextInt();
		int[][] arr = new int[m][n];
		for(int i = 0; i < arr.length; i++){
			for(int j = 0 ; j  < arr[0].length; j++){
				arr[i][j] = scn.nextInt();
			}
		}
		getMaxGold(arr);
		System.out.println(max);
	}
}
