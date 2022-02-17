package L8_StacksAndQueues;
import java.util.*;
import java.io.*;

// 1. You are given a prefix expression.
// 2. You are required to evaluate it and print it's value.
// 3. You are required to convert it to infix and print it.
// 4. You are required to convert it to postfix and print it.

// Note -> Use brackets in infix expression for indicating precedence. Check sample input output for more details.

// Constraints
// 1. Expression is a valid prefix expression
// 2. The only operators used are +, -, *, /
// 3. All operands are single digit numbers.

public class Q70_PrefixEvaluationAndConversions {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String exp = br.readLine();
    
        // code
        Stack<Integer> val=new Stack<>();
        Stack<String> in=new Stack<>();
        Stack<String> post=new Stack<>();
    
        for(int i=exp.length()-1 ;i>=0; i--){
            char ch= exp.charAt(i);
    
            if(ch>='0' && ch<='9'){
                val.push(ch-'0');
                in.push(ch+"");
                post.push(ch+"");
            }else if(ch=='+' || ch=='-' || ch=='*' || ch=='/'){
                int v1= val.pop();
                int v2= val.pop();
                val.push(operate(v1, v2, ch));
    
                String in1= in.pop();
                String in2= in.pop();
                in.push("("+in1+ch+in2+")");
    
                String post1= post.pop();
                String post2= post.pop();
                post.push(post1+post2+ch);
            }else continue;
        }
    
        System.out.println(val.peek());
        System.out.println(in.peek());
        System.out.println(post.peek());
      }
    
      public static int operate(int v1, int v2, char ch){
          if(ch=='+') return v1+v2;
          else if(ch=='-') return v1-v2;
          else if(ch=='*') return v1*v2;
          else return v1/v2;
      }
}
