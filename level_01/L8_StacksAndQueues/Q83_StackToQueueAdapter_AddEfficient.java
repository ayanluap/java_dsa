package L8_StacksAndQueues;
import java.io.*;
import java.util.*;

// 1. You are required to complete the code of our StackToQueueAdapter class. The class should mimic the behaviour of a Queue and implement FIFO semantic.
// 2. Here is the list of functions that are written in the class 
//     2.1. add -> Accepts new data if there is space available in the underlying array or 
//     print "Queue overflow" otherwise.
//     2.2. remove -> Removes and returns value according to FIFO, if available or print 
//     "Queue underflow" otherwise and return -1.
//     2.3. peek -> Returns value according to FIFO, if available or print "Queue 
//     underflow" otherwise and return -1.
//     2.4. size -> Returns the number of elements available in the queue.
// 3. Input and Output is managed for you.

// Constraints
// Note -> add and size should work in constant time. remove and peek should work in linear time.


public class Q83_StackToQueueAdapter_AddEfficient {
    public static class StackToQueueAdapter {
        Stack<Integer> mainS;
        Stack<Integer> helperS;
    
        public StackToQueueAdapter() {
          mainS = new Stack<>();
          helperS = new Stack<>();
        }
    
        int size() {
          // write your code here
          return mainS.size();
        }
    
        void add(int val) {
          // write your code here
          mainS.push(val);
        }
    
        int remove() {
          // write your code here
          int res=-1;
          if(size()==0) System.out.println("Queue underflow");
          else{
            while(!mainS.empty()) {
              helperS.push(mainS.pop());
            }
            res=helperS.pop();
            while(!helperS.empty()) {
              mainS.push(helperS.pop());
            }
          }
    
          return res;
        }
    
        int peek() {
          // write your code here
          int res=-1;
          if(size()==0) System.out.println("Queue underflow");
          else {
            while(!mainS.empty()) {
              helperS.push(mainS.pop());
            }
            res=helperS.peek();
            while(!helperS.empty()) {
              mainS.push(helperS.pop());
            }
          }
    
          return res;
        }
      }
    
      public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StackToQueueAdapter qu = new StackToQueueAdapter();
    
        String str = br.readLine();
        while (str.equals("quit") == false) {
          if (str.startsWith("add")) {
            int val = Integer.parseInt(str.split(" ")[1]);
            qu.add(val);
          } else if (str.startsWith("remove")) {
            int val = qu.remove();
            if (val != -1) {
              System.out.println(val);
            }
          } else if (str.startsWith("peek")) {
            int val = qu.peek();
            if (val != -1) {
              System.out.println(val);
            }
          } else if (str.startsWith("size")) {
            System.out.println(qu.size());
          }
          str = br.readLine();
        }
      }
}
