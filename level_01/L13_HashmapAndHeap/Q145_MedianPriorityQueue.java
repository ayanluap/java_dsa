package L13_HashmapAndHeap;
import java.io.*;
import java.util.*;

// 1. You are required to complete the code of our MedianPriorityQueue class. The class should mimic the behaviour of a PriorityQueue and give highest priority to median of it's data.
// 2. Here is the list of functions that you are supposed to complete
// 2.1. add -> Should accept new data.
// 2.2. remove -> Should remove and return median value, if available or print "Underflow" otherwise and return -1
// 2.3. peek -> Should return median value, if available or print "Underflow" otherwise and return -1
// 2.4. size -> Should return the number of elements available
// 3. Input and Output is managed for you.

// Note -> If there are even number of elements in the MedianPriorityQueue, consider the smaller median as median value.

public class Q145_MedianPriorityQueue {
    public static class MedianPriorityQueue {
        PriorityQueue<Integer> left;
        PriorityQueue<Integer> right;
    
        public MedianPriorityQueue() {
          left = new PriorityQueue<>(Collections.reverseOrder());
          right = new PriorityQueue<>();
        }
    
        public void add(int val) {
          // write your code here
          if(right.size()>0 && right.peek() < val) right.add(val);
          else left.add(val);
    
          if(left.size()-right.size() > 1) {
            right.add(left.remove());
          }else if(right.size()-left.size() > 1) {
            left.add(right.remove());
          }
        }
    
        public int remove() {
          // write your code here
          if(left.size() == right.size()) {
    
            if(left.size() > 0) return left.remove();
            else System.out.println("Underflow");
    
          }else if(left.size() < right.size()){
    
            if(right.size() > 0) return right.remove();
            else System.out.println("Underflow");
    
          }else {
            if(left.size() > 0) return left.remove();
            else System.out.println("Underflow");
          }
    
          return -1;
    
        }
    
        public int peek() {
          // write your code here
          if(left.size()+right.size() == 0) System.out.println("Underflow");
          else {
            if(left.size()==right.size()) return left.peek();
            else if(left.size() < right.size()) return right.peek();
            else return left.peek();
          } 
    
          return -1;
        }
    
        public int size() {
          // write your code here
          return left.size() + right.size();
        }
      }
    
      public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        MedianPriorityQueue qu = new MedianPriorityQueue();
    
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
