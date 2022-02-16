package L8_StacksAndQueues;
import java.util.*;

// 1. You are given a string exp representing an expression.
// 2. Assume that the expression is balanced  i.e. the opening and closing brackets match with each other.
// 3. But, some of the pair of brackets maybe extra/needless. 
// 4. You are required to print true if you detect extra brackets and false otherwise.

public class  Q61_DuplicateBracket {
    public static void main(String[] args) throws Exception {
        Scanner sc=new Scanner(System.in);
        String s=sc.nextLine();

        System.out.println(DuplicateBrac(s));
    }

    public static Boolean DuplicateBrac(String str) {
        Stack<Character> st= new Stack<>();

        
        for(int i=0; i<str.length(); i++) {
            char ch=str.charAt(i);
            if(ch==')'){
                if(st.peek()=='('){
                    return true;
                }else{
                    while(st.peek()!='('){
                        st.pop();
                    }
                    st.pop();
                }
            }else{
                st.push(ch);
            }    
        }

        return false;
        
    }
}