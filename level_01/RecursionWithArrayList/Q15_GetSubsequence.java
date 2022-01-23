package level_01.RecursionWithArrayList;
import java.util.*;

// 1. You are given a string str.
// 2. Complete the body of getSS function - without changing signature - to calculate all subsequences of str.
// Use sample input and output to take idea about subsequences.

public class Q15_GetSubsequence {
    public static void main(String[] args) throws Exception {
        Scanner sc=new Scanner(System.in);
        String s=sc.next();
        System.out.println(gss(s));
    }

    public static ArrayList<String> gss(String str) {
        if(str.length()==0) {
            ArrayList<String> bres=new ArrayList<>();
            bres.add("");
            return bres;
        }

        char ch=str.charAt(0);
        String ros=str.substring(1);
        ArrayList<String> rres=gss(ros);

        ArrayList<String> mres=new ArrayList<>();
        for(String s: rres){
            mres.add(""+s);
        }
        for(String s: rres){
            mres.add(ch+s);
        }
        return mres;
        
    }
}
