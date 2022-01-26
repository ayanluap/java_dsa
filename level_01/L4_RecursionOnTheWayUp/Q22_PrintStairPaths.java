package level_01.L4_RecursionOnTheWayUp;
import java.util.*;

// 1. You are given a number n representing number of stairs in a staircase.
// 2. You are standing at the bottom of staircase. You are allowed to climb 1 step, 2 steps or 3 steps in one move.
// 3. Complete the body of printStairPaths function - without changing signature - to print the list of all paths that can be used to climb the staircase up.
// Use sample input and output to take idea about output.

public class Q22_PrintStairPaths {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
        printStairPaths(n, "");
    }

    public static void printStairPaths(int n, String path) {
        if(n==0) System.out.println(path);
        else if(n<0) return;

        printStairPaths(n-1, path+1);
        printStairPaths(n-2, path+2);
        printStairPaths(n-3, path+3);
    }
}
