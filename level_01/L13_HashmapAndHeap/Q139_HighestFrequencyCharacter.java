package L13_HashmapAndHeap;
import java.io.*;
import java.util.*;


// 1. You are given a string str.
// 2. You are required to find the character with maximum frequency.

// Constraints
// 0 < str.length() <= 100
// There will be a single character with highest frequency

public class Q139_HighestFrequencyCharacter {
    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner sc= new Scanner(System.in);
        String str= sc.next();

        HashMap<Character, Integer> hm= new HashMap<>();

        for(int i=0; i<str.length(); i++) {
            char x= str.charAt(i);
            if(hm.containsKey(x)){
                int oldVal= hm.get(x);
                int newVal= hm.get(x)+1;
                hm.put(x, newVal);
            }else hm.put(x, 1);
        }

        char comp= str.charAt(0);

        for(char c: hm.keySet()){
            if(hm.get(c) > hm.get(comp)) {
                comp= c;
            }
        }

        System.out.println(comp);
    }
}
