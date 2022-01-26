package level_01.L3_RecursionWithArrayList;
import java.lang.reflect.Array;
import java.util.*;

// 1. You are given a number n and a number m representing number of rows and columns in a maze.
// 2. You are standing in the top-left corner and have to reach the bottom-right corner. 
// 3. In a single move you are allowed to jump 1 or more steps horizontally (as h1, h2, .. ), or 1 or more steps vertically (as v1, v2, ..) or 1 or more steps diagonally (as d1, d2, ..). 
// 4. Complete the body of getMazePath function - without changing signature - to get the list of all paths that can be used to move from top-left to bottom-right.
// Use sample input and output to take idea about output.

// Sample Input
// 2
// 2

// Sample Output
// [h1v1, v1h1, d1]

public class Q19_GetMazePathWithJumps {
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
        }else if (sr > dr || sc > dc){
          ArrayList< String> bres = new ArrayList<>();
          return bres;
        }
        ArrayList<String> hpaths=new ArrayList<>();
        ArrayList<String> vpaths=new ArrayList<>();
        ArrayList<String> dpaths=new ArrayList<>();
        ArrayList<String> mres=new ArrayList<>();

        
        for(int i=1; i<=dc-sc; i++){
            hpaths=getMazePaths(sr, sc+i, dr, dc);
            for(String path: hpaths){
                mres.add("h"+i+path);
            }
        }
        for(int i=1; i<=dr-sr; i++){
            vpaths=getMazePaths(sr+i, sc, dr, dc);
            for(String path: vpaths){
                mres.add("v"+i+path);
            }
        }
        for(int i=1; i<=dc-sc && i<=dr-sr; i++){
            dpaths=getMazePaths(sr+i, sc+i, dr, dc);
            for(String path: dpaths){
                mres.add("d"+i+path);
            }
        }
        return mres;
    }
}
