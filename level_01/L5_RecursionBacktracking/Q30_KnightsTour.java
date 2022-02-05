package L5_RecursionBacktracking;
import java.util.*;

// 1. You are given a number n, the size of a chess board.
// 2. You are given a row and a column, as a starting point for a knight piece.
// 3. You are required to generate the all moves of a knight starting in (row, col) such that knight visits all cells of the board exactly once.
// 4. Complete the body of printKnightsTour function - without changing signature - to calculate and print all configurations of the chess board representing the route of knight through the chess board. Use sample input and output to get more idea.

// Note -> When moving from (r, c) to the possible 8 options give first precedence to (r - 2, c + 1) and move in clockwise manner to explore other options.

public class Q30_KnightsTour {
    public static void main(String[] args) throws Exception {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int chess[][]=new int[n][n];
        int row=sc.nextInt();
        int col=sc.nextInt();
        printKnightsTour(chess, row, col, 0);
    }

    public static void printKnightsTour(int[][] chess, int r, int c, int upcomingMove) {
        if(r>=chess.length || c>=chess.length) return;
        if(r<0 || c<0) return; 
        if(chess[r][c]>0) return;
        if(upcomingMove==(chess.length*chess.length)-1) {
            chess[r][c]=upcomingMove+1;
            displayBoard(chess);
        }

        chess[r][c]=upcomingMove+1;
        printKnightsTour(chess, r-2, c+1, upcomingMove+1);
        printKnightsTour(chess, r-1, c+2, upcomingMove+1);
        printKnightsTour(chess, r+1, c+2, upcomingMove+1);
        printKnightsTour(chess, r+2, c+1, upcomingMove+1);
        printKnightsTour(chess, r+2, c-1, upcomingMove+1);
        printKnightsTour(chess, r+1, c-2, upcomingMove+1);
        printKnightsTour(chess, r-1, c-2, upcomingMove+1);
        printKnightsTour(chess, r-2, c-1, upcomingMove+1);
        chess[r][c]=0;
    }

    public static void displayBoard(int[][] chess){
        for(int i = 0; i < chess.length; i++){
            for(int j = 0; j < chess[0].length; j++){
                System.out.print(chess[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println();
    }
}
