import java.util.*;
import java.io.*;

// 1. You are given an infix expression.
// 2. You are required to evaluate and print it's value.

public class Q67_InfixEvaluation {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String exp = br.readLine();
    
        // code
        Stack<Character> operators= new Stack<>();
        Stack<Integer> operands= new Stack<>();
    
        for(int i=0; i<exp.length(); i++){
            char curr= exp.charAt(i);
            if(curr==' ') continue;
            else if(curr=='('){
                operators.push(curr);
            }else if(Character.isDigit(curr)){
                operands.push(curr-'0');
            }else if(curr==')'){
                while(operators.peek()!='('){
                    int v2= operands.pop();
                    int v1=operands.pop();
                    char ch=operators.pop();
    
                    int res= operate(v1, v2, ch);
                    operands.push(res);
                }
                operators.pop();
            }else if(curr=='+' || curr=='-' || curr=='/' || curr=='*'){
                
                while(!operators.empty() && 
                precedence(curr)<=precedence(operators.peek()) && 
                operators.peek()!='('){
                    int v2= operands.pop();
                    int v1=operands.pop();
                    char ch=operators.pop();
    
                    int res= operate(v1, v2, ch);
                    operands.push(res);
                }
                operators.push(curr);
            }
        }
    
        while(!operators.empty()){
            int v2= operands.pop();
            int v1=operands.pop();
            char ch=operators.pop();
    
            int res= operate(v1, v2, ch);
            operands.push(res);
        }
            
        System.out.println(operands.peek());
     }
    
     public static int precedence(char ch){
         if(ch=='+') return 1;
         else if(ch=='-') return 1;
         else if(ch=='*') return 2;
         else return 2;
     }
    
     public static int operate(int v1, int v2, char ch) {
         if(ch=='+') return v1+v2;
         else if(ch=='-') return v1-v2;
         else if(ch=='*') return v1*v2;
         else return v1/v2;
     }
}
