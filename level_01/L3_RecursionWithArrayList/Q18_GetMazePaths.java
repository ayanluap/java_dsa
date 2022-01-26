package level_01.L3_RecursionWithArrayList;
import java.util.*;

// 1. You are given a number n and a number m representing number of rows and columns in a maze.
// 2. You are standing in the top-left corner and have to reach the bottom-right corner. Only two moves are allowed 'h' (1-step horizontal) and 'v' (1-step vertical).
// 3. Complete the body of getMazePath function - without changing signature - to get the list of all paths that can be used to move from top-left to bottom-right.
// Use sample input and output to take idea about output.

// 3
// 3
// [hhvv, hvhv, hvvh, vhhv, vhvh, vvhh]

public class Q18_GetMazePaths {
    public static void main(String[] args) throws Exception {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int m=sc.nextInt();
        System.out.println(getMazePaths(1, 1, n, m));

    }

    // sr - source row
    // sc - source column
    // dr - destination row
    // dc - destination column
    public static ArrayList<String> getMazePaths(int sr, int sc, int dr, int dc) {
        if(sr==dr && sc==dc){
            ArrayList<String> bres=new ArrayList<>();
            bres.add("");
            return bres;
        }

        ArrayList<String> hpaths=new ArrayList<>();
        ArrayList<String> vpaths=new ArrayList<>();
        if(sr<dr){
            vpaths=getMazePaths(sr+1, sc, dr, dc);
        }
        if(sc<dc){
            hpaths=getMazePaths(sr, sc+1, dr, dc);
        }

        ArrayList<String> mres=new ArrayList<>();
        for(String s: hpaths){
            mres.add("h"+s);
        }
        for(String s: vpaths){
            mres.add("v"+s);
        }

        return mres;
    }
}
