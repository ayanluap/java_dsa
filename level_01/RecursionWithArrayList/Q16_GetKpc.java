package level_01.RecursionWithArrayList;
import java.util.*;

// 1. You are given a string str. The string str will contains numbers only, where each number stands for a key pressed on a mobile phone.
// 2. The following list is the key to characters map :
//     0 -> .;
//     1 -> abc
//     2 -> def
//     3 -> ghi
//     4 -> jkl
//     5 -> mno
//     6 -> pqrs
//     7 -> tu
//     8 -> vwx
//     9 -> yz
// 3. Complete the body of getKPC function - without changing signature - to get the list of all words that could be produced by the keys in str.
// Use sample input and output to take idea about output.

public class Q16_GetKpc {
    public static void main(String[] args) throws Exception {
        Scanner sc=new Scanner(System.in);
        String s=sc.next();
        System.out.println(getKPC(s));
    }

    static String codes[]={".","abc","def","ghi","jkl","mno","pqrs","tu","vwx","yz"};
    public static ArrayList<String> getKPC(String str) {
        if(str.length()==0) {
            ArrayList<String> bres=new ArrayList<>();
            bres.add("");
            return bres;
        } 

        char curr=str.charAt(0);
        String ros=str.substring(1);

        ArrayList<String> rres=getKPC(ros);
        ArrayList<String> mres=new ArrayList<>();

        String s=codes[curr-'0'];
        for(int i=0; i<s.length(); i++){
            char c=s.charAt(i);
            for(String x: rres){
                mres.add(c+x);
            }
        }

        return mres;
    }
}
