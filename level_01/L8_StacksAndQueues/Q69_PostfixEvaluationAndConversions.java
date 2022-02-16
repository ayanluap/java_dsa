package L8_StacksAndQueues;
import java.io.*;
import java.util.*;

// 1. You are given a postfix expression.
// 2. You are required to evaluate it and print it's value.
// 3. You are required to convert it to infix and print it.
// 4. You are required to convert it to prefix and print it.

// Note -> Use brackets in infix expression for indicating precedence. Check sample input output for more details.

// Constraints
// 1. Expression is a valid postfix expression
// 2. The only operators used are +, -, *, /
// 3. All operands are single digit numbers.

public class Q69_PostfixEvaluationAndConversions {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String exp = br.readLine();
    
        // code
        Stack<Integer> val= new Stack<>();
        Stack<String> in=new Stack<>();
        Stack<String> pre=new Stack<>();
    
        for(int i=0; i<exp.length(); i++){
            char ch= exp.charAt(i);
            if(ch>='0' && ch<='9') {
                val.push(ch-'0');
                in.push(ch+"");
                pre.push(ch+"");
            }else if(ch=='-' || ch=='+' || ch=='*' || ch=='/'){
                int v2= val.pop();
                int v1= val.pop();
                val.push(operate(v1, v2, ch));
    
                String pre2= pre.pop();
                String pre1= pre.pop();
                pre.push(ch+pre1+pre2);
    
                String in2= in.pop();
                String in1= in.pop();
                in.push("("+in1+ch+in2+")");
    
            }else continue;
        }
    
        System.out.println(val.peek());
        System.out.println(in.peek());
        System.out.println(pre.peek());
     }
    
     public static int operate(int v1, int v2, char operator){
         if(operator=='+') return v1+v2;
         else if(operator=='-') return v1-v2;
         else if(operator=='*') return v1*v2;
         else return v1/v2;
      }
}
