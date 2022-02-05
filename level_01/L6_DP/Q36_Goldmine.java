package L6_DP;
import java.util.*;

// 1. You are given a number n, representing the number of rows.
// 2. You are given a number m, representing the number of columns.
// 3. You are given n*m numbers, representing elements of 2d array a, which represents a gold mine.
// 4. You are standing in front of left wall and are supposed to dig to the right wall. You can start from any row in the left wall.
// 5. You are allowed to move 1 cell right-up (d1), 1 cell right (d2) or 1 cell right-down(d3).

public class Q36_Goldmine {
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

        // Recursion
        Integer dp[][]=new Integer[n][m];
        int max=Integer.MIN_VALUE;

        for(int r=0; r<maze.length; r++){
            max=Math.max(max, goldmineRec(maze, r, 0, dp));
        }
        System.out.println(max);

        System.out.println(goldmine(maze));
    }

    // using recursion
    public static int goldmineRec(int maze[][], int row, int col, Integer dp[][]){
        if(row>=maze.length || row<0) return 0;

        if(col==maze[0].length-1) return dp[row][col]=maze[row][col];

        if(dp[row][col]!=null) return dp[row][col];

        int rightUp= goldmineRec(maze, row-1, col+1, dp);
        int right= goldmineRec(maze, row, col+1, dp);
        int rightDown= goldmineRec(maze, row+1, col+1, dp);

        return dp[row][col]=maze[row][col]+Math.max(right, Math.max(rightUp,rightDown));
    }

    

    // using tabulation
    public static int goldmine(int maze[][]){
        int row=maze.length-1;
        int col=maze[0].length-1;

        int dp[][]=new int[row+1][col+1];
        for(int r=0; r<=row; r++){
            dp[r][col]=maze[r][col];
        }

        for(int c=col-1; c>=0; c--){
            for(int r=0; r<=row; r++){
                if(r==0) {
                    dp[r][c]=maze[r][c]+Math.max(dp[r][c+1], dp[r+1][c+1]);
                }else if(r==row){
                    dp[r][c]=maze[r][c]+Math.max(dp[r][c+1], dp[r-1][c+1]);
                }else{
                    dp[r][c]=maze[r][c]+Math.max(dp[r][c+1], Math.max(dp[r+1][c+1], dp[r-1][c+1]));
                }
            }
        }

        int max=Integer.MIN_VALUE;
        for(int r=0; r<=row; r++){
            max=Math.max(max, dp[r][0]);
        }
        return max;
    }
}
