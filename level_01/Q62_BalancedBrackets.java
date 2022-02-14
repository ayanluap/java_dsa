import java.util.*;

// 1. You are given a string exp representing an expression.
// 2. You are required to check if the expression is balanced i.e. closing brackets and opening brackets match up well.

public class Q62_BalancedBrackets {
    public static void main(String[] args) throws Exception {
        Scanner sc=new Scanner(System.in);
        String s=sc.nextLine();
        System.out.println(balBrac(s));
    }

    public static Boolean balBrac(String str){
        Stack<Character> st=new Stack<>();
        for(int i=0; i<str.length(); i++){
            char ch=str.charAt(i);
            if(ch=='(' || ch=='{' || ch=='[') st.push(ch);
            else if((ch==')' || ch=='}' || ch==']') && st.empty()) return false;
            else if(ch==')' && st.peek()=='(' && !st.empty()) st.pop();
            else if(ch=='}' && st.peek()=='{' && !st.empty()) st.pop();
            else if(ch==']' && st.peek()=='[' && !st.empty()) st.pop();
        }
        if(st.empty()==true) return true;
        else return false;
    }
}
