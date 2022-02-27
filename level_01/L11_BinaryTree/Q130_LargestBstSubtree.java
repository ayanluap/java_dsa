package L11_BinaryTree;
import java.io.*;
import java.util.*;

// 1. You are given a partially written BinaryTree class.
// 2. You are required to find the root of largest sub-tree which is a BST. Also, find the number of nodes in that sub-tree.
// 3. Input is managed for you. 

// Note -> Please refer the question video for clarity.

// Constraints
// Time complexity must be O(n)
// Space should not be more than required for recursion (call-stack)

public class Q130_LargestBstSubtree {
    public static class Node {
        int data;
        Node left;
        Node right;
    
        Node(int data, Node left, Node right) {
          this.data = data;
          this.left = left;
          this.right = right;
        }
      }
    
      public static class Pair {
        Node node;
        int state;
    
        Pair(Node node, int state) {
          this.node = node;
          this.state = state;
        }
      }
    
      public static Node construct(Integer[] arr) {
        Node root = new Node(arr[0], null, null);
        Pair rtp = new Pair(root, 1);
    
        Stack<Pair> st = new Stack<>();
        st.push(rtp);
    
        int idx = 0;
        while (st.size() > 0) {
          Pair top = st.peek();
          if (top.state == 1) {
            idx++;
            if (arr[idx] != null) {
              top.node.left = new Node(arr[idx], null, null);
              Pair lp = new Pair(top.node.left, 1);
              st.push(lp);
            } else {
              top.node.left = null;
            }
    
            top.state++;
          } else if (top.state == 2) {
            idx++;
            if (arr[idx] != null) {
              top.node.right = new Node(arr[idx], null, null);
              Pair rp = new Pair(top.node.right, 1);
              st.push(rp);
            } else {
              top.node.right = null;
            }
    
            top.state++;
          } else {
            st.pop();
          }
        }
    
        return root;
      }
    
      public static void display(Node node) {
        if (node == null) {
          return;
        }
    
        String str = "";
        str += node.left == null ? "." : node.left.data + "";
        str += " <- " + node.data + " -> ";
        str += node.right == null ? "." : node.right.data + "";
        System.out.println(str);
    
        display(node.left);
        display(node.right);
      }
    
      public static class InfoPair{
        boolean bst;
        int max;
        int min;
        int lastBst;
        int nodesCnt;
    
        InfoPair(){}
    
        InfoPair(boolean bst, int max, int min, int lastBst, int nodesCnt){
          this.bst= bst;
          this.max= max;
          this.min= min;
          this.lastBst= lastBst;
          this.nodesCnt= nodesCnt;
        }
      }
    
      public static InfoPair larBstSubTree(Node node){
        if(node==null) {
          InfoPair bres= new InfoPair(true, Integer.MIN_VALUE, Integer.MAX_VALUE, 0, 0);
          return bres;
        }
    
        InfoPair lt= larBstSubTree(node.left);
        InfoPair rt= larBstSubTree(node.right);
    
        InfoPair res= new InfoPair();
        res.bst= lt.bst && rt.bst && node.data > lt.max && node.data < rt.min;
        res.max= Math.max(node.data, Math.max(lt.max, rt.max));
        res.min= Math.min(node.data, Math.min(lt.min, rt.min));
        
    
        if(res.bst) {
          res.lastBst= node.data;
          res.nodesCnt= lt.nodesCnt + rt.nodesCnt + 1;
        }else if(lt.nodesCnt > rt.nodesCnt) {
          res.lastBst= lt.lastBst;
          res.nodesCnt= lt.nodesCnt;
        }else {
          res.lastBst= rt.lastBst;
          res.nodesCnt= rt.nodesCnt;
        }
    
        return res;
      }
      
      public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Integer[] arr = new Integer[n];
        String[] values = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
          if (values[i].equals("n") == false) {
            arr[i] = Integer.parseInt(values[i]);
          } else {
            arr[i] = null;
          }
        }
    
        Node root = construct(arr);
        
        // write your code here
        InfoPair res= larBstSubTree(root);
        System.out.println(res.lastBst+"@"+res.nodesCnt);
      }
}
