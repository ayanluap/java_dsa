package L1_RecursionAndBacktracking;
import java.io.*;
import java.util.*;

// 1. You are given a list of words, a list of alphabets(might be repeating) and score of every alphabet from a to z.
// 2. You have to find the maximum score of any valid set of words formed by using the given alphabets.
// 3. A word can not be used more than one time.
// 4. Each alphabet can be used only once. 
// 5. It is not necessary to use all the given alphabets.

// Note -> Check out the question video and write the recursive code as it is intended without changing signature. The judge can't force you but intends you to teach a concept.

// Constraints
// 1 <= N <= 14
// 1 <= length of word <= 15
// 1 <= M <= 100
// 1 <= Value of score <= 10

public class Q159_MaxScore {
    public static int solution(String[] words, int[] farr, int[] score, int idx) {
		//write your code here
		if(idx==words.length) return 0;

		// include curr word
		int currWordScore= 0;
		String currWord= words[idx];
		boolean proceed= true;
		for(int i=0; i < currWord.length(); i++) {
			char ch= currWord.charAt(i);
			
			if(farr[ch-'a'] == 0) {
				proceed= false;
			}

			farr[ch-'a']--;
			currWordScore+= score[ch-'a'];
		}
		int syes= 0;
		if(proceed) syes= currWordScore + solution(words, farr, score, idx+1);

		for(int i=0; i < currWord.length(); i++) {
			char ch= currWord.charAt(i);
			farr[ch-'a']++;
			currWordScore-= score[ch-'a'];
		}
		proceed= true;

		// not include curr word
		int sno= solution(words, farr, score, idx+1);
		
		return Math.max(sno, syes);
	}

	public static void main(String[] args) {

		Scanner scn = new Scanner(System.in);
		int nofWords = scn.nextInt();
		String[] words = new String[nofWords];
		for(int i = 0 ; i < words.length; i++) {
			words[i] = scn.next();
		}
		int nofLetters = scn.nextInt();
		char[] letters = new char[nofLetters];
		for (int i = 0; i < letters.length; i++) {
			letters[i] = scn.next().charAt(0);
		}
		int[] score = new int[26];
		for (int i = 0; i < score.length; i++) {
			score[i] = scn.nextInt();
		}
		if (words == null || words.length == 0 || letters == null || letters.length == 0 || score == null
				|| score.length == 0) {
			System.out.println(0);
			return;
		}
		int[] farr = new int[score.length];
		for (char ch : letters) {
			farr[ch - 'a']++;
		}
		System.out.println(solution(words, farr, score, 0));

	}
}
