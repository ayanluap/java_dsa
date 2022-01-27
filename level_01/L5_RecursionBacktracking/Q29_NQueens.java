package level_01.L5_RecursionBacktracking;
import java.util.*;

// 1. You are given a number n, the size of a chess board.
// 2. You are required to place n number of queens in the n * n cells of board such that no queen can kill another.
// Note - Queens kill at distance in all 8 directions
// 3. Complete the body of printNQueens function - without changing signature - to calculate and print all safe configurations of n-queens. Use sample input and output to get more idea.

public class Q29_NQueens {
    public static void main(String[] args) throws Exception {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int chessBoard[][]=new int[n][n];
        printNQueens(chessBoard, "", 0);
    }

    public static void printNQueens(int[][] chess, String qsf, int row) {
        if(row==chess.length) {
            qsf+=".";
            System.out.println(qsf);
            return;
        }

        for(int col=0; col<chess.length; col++){
            chess[row][col]=1;
            printNQueens(chess, qsf+row+"-"+col+", ", row+1);
            chess[row][col]=0;
        }

    }
}
