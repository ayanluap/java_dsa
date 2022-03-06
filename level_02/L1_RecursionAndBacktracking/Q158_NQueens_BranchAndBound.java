package L1_RecursionAndBacktracking;
import java.io.*;
import java.util.*;

// 1. You are given a number n, the size of a chess board.
// 2. You are required to place n number of queens in the n * n cells of board such that no queen can kill another.
// Note - Queens kill at distance in all 8 directions

// 3. Complete the body of printNQueens function - without changing signature - to calculate and print all safe configurations of n-queens. Use sample input and output to get more idea.

// Note -> The online judge can't force you to write the function recursively but that is what the spirit of question is.

// Write recursive and not iterative logic. The purpose of the question is to aid learning recursion, branch and bound technique and not test you.

public class Q158_NQueens_BranchAndBound {
    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        boolean[][] board = new boolean[n][n];

        //write your code here
        boolean[] col= new boolean[n];
        boolean[] diag1= new boolean[2*n-1];
        boolean[] diag2= new boolean[2*n-1];

        printNQueensUsingArrays(board, 0, col, diag1, diag2, "");

        // printNQueens(board, 0, "");
      }

      // REDUCING EXTRA COMPLEXITY ----(OPTIMISED)
      public static void printNQueensUsingArrays(boolean[][] board, int rowIdx, boolean[] col, boolean[] diag1, boolean[] diag2, String asf) {

        if(rowIdx==board.length) {
          asf+= ".";
          System.out.println(asf);
          return;
        }
          
        for(int c=0; c<board.length; c++){
          if(!col[c] && !diag1[rowIdx+c] && !diag2[rowIdx-c+board.length-1]) {
            col[c]= true;
            diag1[rowIdx+c]= true;
            diag2[rowIdx-c+board.length-1]= true;

            printNQueensUsingArrays(board, rowIdx+1, col, diag1, diag2, asf+rowIdx+"-"+c+", ");

            col[c]= false;
            diag1[rowIdx+c]= false;
            diag2[rowIdx-c+board.length-1]= false;
          };
        }
      }
    
      // OLD METHOD ----(NOT OPTIMISED)
      public static void printNQueens(boolean[][] board, int rowIdx, String asf) {
        if(rowIdx==board.length) {
          asf+= ".";
          System.out.println(asf);
          return;
        }
    
        for(int col=0; col<board.length; col++){
          if(isQueenSafe(board, rowIdx, col)) {
            board[rowIdx][col]= true;
            printNQueens(board, rowIdx+1, asf+rowIdx+"-"+col+", ");
            board[rowIdx][col]= false;
          }
        }
      }
    
      public static boolean isQueenSafe(boolean[][] board, int row, int col) {
        for(int r=row-1; r>=0; r--) {
          if(board[r][col]) return false;
        }
    
        for(int r=row-1, c=col-1; r>=0 && c>=0; r--,c--) {
          if(board[r][c]) return false;
        } 
    
        for(int r=row-1, c=col+1; r>=0 && c<board.length; r--,c++) {
          if(board[r][c]) return false;
        } 
    
        return true;
      }
}
