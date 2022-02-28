package L12_BST;
import java.io.*;
import java.util.*;

// 1. You are given a partially written BST class.
// 2. You are required to complete the body of remove function. "remove" function is expected to remove a new node with given data to the tree and return the new root.
// 3. Input and Output is managed for you. 

// Note -> Please watch the question video to figure out the algorithm required for deletion. It specifies some requirements of the question as well.

// APPROACH----------
// In this problem we have to think about 3 cases;
// 1. remove node with 0 child -> just remove the unwanted node
// 2. remove node with 1 child -> just return the child node and connect with the parent
// 3. remove node with 2 childs -> I. find the max from the left subtree (This would be the rightmost leaf of  the left subtree guaranteed!!!).
                            //    II. replace the max elem. with the unwanted node.data (The BST would still be maintained).   

public class Q134_RemoveNodeFromBst {
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
    
      public static Node remove(Node node, int data) {
        // write your code here
        if(node ==  null) return null;
    
        if(data < node.data) {
          node.left= remove(node.left, data);
        } else if(data > node.data) {
          node.right= remove(node.right, data);
        } else {
          if(node.left != null && node.right != null) {
            int leftMax= max(node.left);
            node.data= leftMax;
            remove(node.left, leftMax);
          }
          else if(node.left != null) return node.left;
          else if(node.right != null) return node.right;
          else return null;
        }
    
        return node;
      }
    
      public static int max(Node node){
        if(node == null) return Integer.MIN_VALUE;
    
        int lmax= max(node.left);
        int rmax= max(node.right);
    
        return Math.max(node.data, Math.max(lmax, rmax));
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
    
        int data = Integer.parseInt(br.readLine());
    
        Node root = construct(arr);
        root = remove(root, data);
    
        display(root);
      }
}
