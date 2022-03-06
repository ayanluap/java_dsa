package L5_RecursionBacktracking;
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


    // USING SOME EXTRA COMPLEXITY ----(NOT OPTIMISED)
    public static void printNQueens(int[][] chess, String qsf, int row) {
        if(row==chess.length) {
            qsf+=".";
            System.out.println(qsf);
            return;
        }

        for(int col=0; col<chess.length; col++){
            if(isQueenSafe(chess, row, col)==true){
                chess[row][col]=1;
                printNQueens(chess, qsf+row+"-"+col+", ", row+1);
                chess[row][col]=0;
            }
        }

    }

    public static boolean isQueenSafe(int chess[][], int row, int col){
        for(int checkUp=row; checkUp>=0; checkUp--){
            if(chess[checkUp][col]==1) return false;
        }

        // checking upper left diagonals
        int rl=row-1; int cl=col-1;
        while(rl>=0 && cl>=0){
            if(chess[rl][cl]==1) return false;
            else{
                rl--; cl--;
            }
        }

        // checking upper right diagonals
        int rr=row-1; int cr=col+1;
        while(rr>=0 && cr<chess.length){
            if(chess[rr][cr]==1) return false;
            else{
                rr--; cr++;
            }
        }

        return true;
    }
}
