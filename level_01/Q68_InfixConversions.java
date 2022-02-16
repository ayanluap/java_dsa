import java.io.*;
import java.util.*;

// 1. You are given an infix expression.
// 2. You are required to convert it to postfix and print it.
// 3. You are required to convert it to prefix and print it.

public class Q68_InfixConversions {
public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String exp = br.readLine();

    // code
    Stack<String> pre=new Stack<>();
    Stack<String> post=new Stack<>();
    Stack<Character> op= new Stack<>();

    for(int i=0; i<exp.length(); i++){
        char ch= exp.charAt(i);

        if(ch=='('){
            op.push(ch);
        }else if((ch>='0' && ch<='9') ||
        (ch>='a' && ch<='z') ||
        (ch>='A' && ch<='Z')){
            pre.push(ch+"");
            post.push(ch+"");
        }else if(ch==')'){
            while(op.peek() != '('){
                String c=op.pop()+"";

                String pre2=pre.pop();
                String pre1=pre.pop();
                String prev= c+pre1+pre2;
                pre.push(prev);

                String post2=post.pop();
                String post1=post.pop();
                String postv=post1+post2+c;
                post.push(postv);
            }
            op.pop();
        }else if(ch=='+' || ch=='-' || ch=='*' || ch=='/'){
            while(!op.empty() && op.peek()!='(' && 
            precedence(ch) <= precedence(op.peek())){
                String c=op.pop()+"";

                String pre2=pre.pop();
                String pre1=pre.pop();
                String prev= c+pre1+pre2;
                pre.push(prev);

                String post2=post.pop();
                String post1=post.pop();
                String postv=post1+post2+c;
                post.push(postv);
            }
            op.push(ch);
        }
    }

    while(!op.empty()){
        String c=op.pop()+"";

        String pre2=pre.pop();
        String pre1=pre.pop();
        String prev= c+pre1+pre2;
        pre.push(prev);

        String post2=post.pop();
        String post1=post.pop();
        String postv=post1+post2+c;
        post.push(postv);
    }

    System.out.println(post.peek());
    System.out.println(pre.peek());
 }

 public static int precedence(char ch){
     if(ch=='+' || ch=='-') return 1;
     else if(ch=='*' || ch=='/') return 2;
     else return 0;
 }
}
