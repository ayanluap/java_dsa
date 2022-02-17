package L8_StacksAndQueues;
import java.io.*;
import java.util.*;

// 1. You are given a number n, representing the number of people in a party.
// 2. You are given n strings of n length containing 0's and 1's
// 3. If there is a '1' in ith row, jth spot, then person i knows about person j.
// 4. A celebrity is defined as somebody who knows no other person than himself but everybody else knows him.
// 5. If there is a celebrity print it's index otherwise print "none".

// Note -> There can be only one celebrity. Think why?

public class Q71_CelebrityProblem {
    public static void main(String[] args) throws Exception {
        // write your code here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][n];

        for (int j = 0; j < n; j++) {
            String line = br.readLine();
            for (int k = 0; k < n; k++) {
                arr[j][k] = line.charAt(k) - '0';
            }
        }

        findCelebrity(arr);

    }

    public static void findCelebrity(int[][] arr) {
        // if a celebrity is there print it''s index (not position), if there is not then
        // print "none"
        Stack<Integer> st= new Stack<>();
        for(int i=0; i<arr.length; i++) st.push(i);

        while(st.size()!=1){
            int p1=st.pop();
            int p2=st.pop();

            if(arr[p1][p2] == 1){
                st.push(p2);
            }else{
                st.push(p1);
            }
        }

        int pot=st.pop();

        for(int i=0; i<arr.length; i++) {
            if(i!=pot){
                if(arr[pot][i]==1 || arr[i][pot]==0 ) {
                    System.out.println("none");
                    return;
                }
            }
        }
        

        System.out.println(pot);
    }
}
