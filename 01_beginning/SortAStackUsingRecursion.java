import java.util.*;

// // Sort a STACK using recursion

public class SortAStackUsingRecursion {
    static Scanner sc=new Scanner(System.in);
    public static void main(String args[]){
        int n=sc.nextInt();
        Stack<Integer> st=new Stack<>();
        for(int i=0; i<n; i++) {
            int t=sc.nextInt();
            st.push(t);
        }

        recurSort(st);

        System.out.println(st);
    }
    
    public static void recurSort(Stack<Integer> st){

        if(st.size()==0) return;

        int topElem=st.peek();
        st.pop();
        recurSort(st);

        recurInsert(st, topElem);
    }

    public static void recurInsert(Stack<Integer> st, int topElem){
        if(st.size() == 0) {
            st.push(topElem); 
            return;
        }

        if(st.peek() < topElem) st.push(topElem);
        else{
            int hold=st.peek();
            st.pop();
            recurInsert(st, topElem);
            st.push(hold);
        }

        return;
    }
}
