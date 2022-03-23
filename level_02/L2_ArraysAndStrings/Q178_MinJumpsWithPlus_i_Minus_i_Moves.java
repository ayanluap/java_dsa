package L2_ArraysAndStrings;

import java.util.*;

// 1. Given an integers X. 
// 2. The task is to find the minimum number of jumps to reach a point X in the number line starting from zero.
// 3. The first jump made can be of length one unit and each successive jump will be exactly one unit longer than the previous jump in length. 
// 4. It is allowed to go either left or right in each jump.

public class Q178_MinJumpsWithPlus_i_Minus_i_Moves {
    // ~~~~~~~~~~~~User Section~~~~~~~~~~~
    public static int minJumps(int x) {
        // Write your code here
        int currDist = 0;

        int jumps = 1;
        while (currDist < x) {
            currDist += jumps;
            jumps++;
        }

        if ((currDist - x) % 2 == 0) {
            jumps--;
        } else {
            if ((currDist + jumps - x) % 2 != 0)
                jumps++;
        }

        return jumps;
    }

    // ~~~~~~~~~~~~~~~~~~Input Management~~~~~~~~~~~~~~
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int x = scn.nextInt();

        int jumps = minJumps(x);
        System.out.println(jumps);
    }
}
