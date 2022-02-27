package L11_BinaryTree;
import java.io.*;
import java.util.*;

// 1. You are given a partially written BinaryTree class.
// 2. You are required to check if the tree is a Binary Search Tree (BST) as well. In a BST every node has a value greater than all nodes on it's left side and smaller value than all node on it's right side.
// 3. Input is managed for you. 

// Note -> Please refer the question video for clarity.

// Constraints
// Time complexity must be O(n)
// Space should not be more than required for recursion (call-stack)

public class Q129_IsABinarySearchTree {
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
    
      public static int height(Node node) {
        if (node == null) {
          return -1;
        }
    
        int lh = height(node.left);
        int rh = height(node.right);
    
        int th = Math.max(lh, rh) + 1;
        return th;
      }
    
      public static class BSTPair {
        boolean bst;
        int max;
        int min;
    
        BSTPair(){
    
        }
    
        BSTPair(boolean bst, int max, int min){
          this.bst= bst;
          this.max= max;
          this.min= min;
        }
      }
    
    
      public static BSTPair isBst(Node node){
        if(node==null) {
          BSTPair bres= new BSTPair(true, Integer.MIN_VALUE, Integer.MAX_VALUE);
          return bres;
        }
    
        BSTPair lt= isBst(node.left);
        BSTPair rt= isBst(node.right);
    
        BSTPair ct= new BSTPair();
        if(lt.bst && rt.bst && node.data > lt.max && node.data < rt.min){
          ct.bst=true;
        } else ct.bst=false;
        ct.max= Math.max(node.data, Math.max(lt.max, rt.max));
        ct.min= Math.min(node.data, Math.min(lt.min, rt.min));
    
        return ct;
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
        System.out.println(isBst(root).bst);
      }
}
