package level_01.RecursionWithArrayList;
import java.util.*;

// 1. You are given a number n representing number of stairs in a staircase.
// 2. You are standing at the bottom of staircase. You are allowed to climb 1 step, 2 steps or 3 steps in one move.
// 3. Complete the body of getStairPaths function - without changing signature - to get the list of all paths that can be used to climb the staircase up.
// Use sample input and output to take idea about output.

// 3
// [111, 12, 21, 3]

public class Q17_GetStairPaths {
    public static void main(String[] args) throws Exception {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        System.out.println(getStairPaths(n));
    }

    public static ArrayList<String> getStairPaths(int n) {
        if(n==0) {
            ArrayList<String> bres=new ArrayList<>();
            bres.add("");
            return bres;
        }else if(n<0){
            ArrayList<String> bres=new ArrayList<>();
            return bres;
        }

        ArrayList<String> now1=getStairPaths(n-1);
        ArrayList<String> now2=getStairPaths(n-2);
        ArrayList<String> now3=getStairPaths(n-3);

        ArrayList<String> mres=new ArrayList<>();
        for(String x:now1) {

            mres.add(1+x);
        }
        for(String x:now2) {
            mres.add(2+x);
        }
        for(String x:now3) {
            mres.add(3+x);
        }
        return mres;

    }
}
