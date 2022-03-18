package L1_RecursionAndBacktracking;
import java.io.*;
import java.util.*;

// 1. You are given a number.
// 2. You have to print all the numbers from 1 to n in lexicographical order.

// Note -> Check out the question video and write the recursive code as it is intended without changing signature. The judge can't force you but intends you to teach a concept.

public class Q161_LexicographicalNumbers {
    public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();

		//write your code here
		for(int i=1; i<10; i++) {
			dfs(i, n);
		}
        
	}

	public static void dfs(int i, int n) {
		if(i>n) return;

		System.out.println(i);
		for(int j=0; j<10; j++) {
			if(i*10+j > n) return;
			dfs(i*10+j, n);
		}
	}
}
