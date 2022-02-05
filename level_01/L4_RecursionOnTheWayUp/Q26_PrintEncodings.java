package L4_RecursionOnTheWayUp;
import java.util.*;

// 1. You are given a string str of digits. (will never start with a 0)
// 2. You are required to encode the str as per following rules
//     1 -> a
//     2 -> b
//     3 -> c
//     ..
//     25 -> y
//     26 -> z
// 3. Complete the body of printEncodings function - without changing signature - to calculate and print all encodings of str.
// Use the input-output below to get more understanding on what is required
// 123 -> abc, aw, lc
// 993 -> iic
// 013 -> Invalid input. A string starting with 0 will not be passed.
// 103 -> jc
// 303 -> No output possible. But such a string maybe passed. In this case print nothing.

public class Q26_PrintEncodings {
    public static void main(String[] args) throws Exception {
        Scanner sc=new Scanner(System.in);
        String str=sc.next();
        printEncodings(str, "");
    }

    public static void printEncodings(String str, String ans) {
        if(str.length()==0) {
            System.out.println(ans);
            return;
        }else if(str.length()==1){
            char ch=str.charAt(0);
            int chToInt=ch-'0';
            String intToCh=(char)('a'+chToInt-1)+"";
            if(ch=='0'){
                return;
            }else{
                printEncodings(str.substring(1), ans+intToCh);
            }
        }else {
            String ch=str.substring(0,1);
            String newStr1=str.substring(1);
            
            if(str.charAt(0)=='0'){
                return;
            }else{
                int chToInt=Integer.parseInt(ch);

                char intToCh=(char)('a'+chToInt-1);
                printEncodings(newStr1, ans+intToCh);
            

            String ch2=str.substring(0,2);
            String newStr2=str.substring(2);

            int chToInt1=Integer.parseInt(ch2);
            if(chToInt1 <= 26){
                char intToCh1=(char)('a'+chToInt1-1);
                printEncodings(newStr2, ans+intToCh1);
            }
        }
        }
        
        
        
    }
}
