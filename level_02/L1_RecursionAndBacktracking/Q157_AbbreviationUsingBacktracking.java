package L1_RecursionAndBacktracking;
import java.util.*;
import java.io.*;

// 1. You are given a word.
// 2. You have to generate all abbrevations of that word.

// Use recursion as suggested in question video

public class Q157_AbbreviationUsingBacktracking {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        String str= sc.next();

        solve(str, "", 0, 0);
    }

    public static void solve(String s, String asf, int count, int pos) {
        if(pos == s.length()) {
            if (count==0) System.out.println(asf);
            else System.out.println(asf+count);
            return;
        }
        
        if(count==0) solve(s, asf+s.charAt(pos), 0, pos+1);
        else solve(s, asf+count+s.charAt(pos), 0, pos+1);

        solve(s, asf, count+1, pos+1);
    }
}
