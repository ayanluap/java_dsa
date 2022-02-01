// package level_01.L6_DP;
import java.util.*;

// 1. You are given a number n, representing the number of rows.
// 2. You are given a number m, representing the number of columns.
// 3. You are given n*m numbers, representing elements of 2d array a, which represents a maze.
// 4. You are standing in top-left cell and are required to move to bottom-right cell.
// 5. You are allowed to move 1 cell right (h move) or 1 cell down (v move) in 1 motion.
// 6. Each cell has a value that will have to be paid to enter that cell (even for the top-left and bottom-right cell).
// 7. You are required to traverse through the matrix and print the cost of path which is least costly.

public class Q35_MinCostInMazeTraversal {
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int m=sc.nextInt();
        int maze[][]=new int[n][m];

        for(int r=0; r<n; r++){
            for(int c=0; c<m; c++){
                maze[r][c]=sc.nextInt();
            }
        }
        System.out.println(minCost(maze, n,m)); 
    }

    // using memoization
    public static int minCost(int maze[][], int row, int col){
        Integer dp[][]=new Integer[row][col];
        dp[row-1][col-1]=maze[row-1][col-1];

        for(int colNum=col-2; colNum>=0; colNum--){
            dp[row-1][colNum]=maze[row-1][colNum]+dp[row-1][colNum+1];
        }
        for(int rowNum=row-2; rowNum>=0; rowNum--){
            dp[rowNum][col-1]=maze[rowNum][col-1]+dp[rowNum+1][col-1];
        }

        for(int r=row-2; r>=0; r--){
            for(int c=col-2; c>=0; c--){
                dp[r][c]=Math.min(dp[r+1][c], dp[r][c+1])+maze[r][c];
            }
        }

        return dp[0][0];
    }
}
