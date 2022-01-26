package level_01.L4_RecursionOnTheWayUp;
import java.util.*;

// 1. You are given a number n and a number m representing number of rows and columns in a maze.
// 2. You are standing in the top-left corner and have to reach the bottom-right corner. 
// 3. In a single move you are allowed to jump 1 or more steps horizontally (as h1, h2, .. ), or 1 or more steps vertically (as v1, v2, ..) or 1 or more steps diagonally (as d1, d2, ..). 
// 4. Complete the body of printMazePath function - without changing signature - to print the list of all paths that can be used to move from top-left to bottom-right.
// Use sample input and output to take idea about output.

public class Q24_PrintMazePathsWithJumps {
    public static void main(String[] args) throws Exception {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int m=sc.nextInt();

        printMazePaths(1, 1, n, m, "");
    }

    // sr - source row
    // sc - source column
    // dr - destination row
    // dc - destination column
    public static void printMazePaths(int sr, int sc, int dr, int dc, String psf) {
        if(sc==dc && sr==dr) {
            System.out.println(psf);
            return;
        }
        
        for(int i=1; i<=dc-sc; i++){
            printMazePaths(sr, sc+i, dr, dc, psf+"h"+i);
        }
        for(int i=1; i<=dr-sr; i++){
            printMazePaths(sr+i, sc, dr, dc, psf+"v"+i);
        }
        for(int i=1; i<=dr-sr && i<=dc-sc; i++){
            printMazePaths(sr+i, sc+i, dr, dc, psf+"d"+i);
        }
    }
}
