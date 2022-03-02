package L13_HashmapAndHeap;
import java.io.*;
import java.util.*;

// 1. You are given a list of lists, where each list is sorted.
// 2. You are required to complete the body of mergeKSortedLists function. The function is expected to merge k sorted lists to create one sorted list.

// Constraints
// Space complextiy = O(k)
// Time complexity = nlogk
// where k is the number of lists and n is number of elements across all lists.

public class Q146_MergeKSortedLists {
    public static class Pair implements Comparable<Pair> {
        int li;
        int di;
        int val;
  
        Pair(int li, int di, int val){
           this.li= li;
           this.di= di;
           this.val= val;
        }
  
        public int compareTo(Pair o) {
           return this.val-o.val;
        }
     }
  
     public static ArrayList<Integer> mergeKSortedLists(ArrayList<ArrayList<Integer>> lists){
        ArrayList<Integer> rv = new ArrayList<>();
        PriorityQueue<Pair> pq= new PriorityQueue<>();
  
        // write your code here
        for(int i=0; i<lists.size(); i++) {
           Pair p= new Pair(i, 0, lists.get(i).get(0));
           pq.add(p);
        }
  
        while(!pq.isEmpty()) {
           Pair p= pq.remove();
           rv.add(p.val);
           p.di++;
  
           if(p.di < lists.get(p.li).size()) {
              p.val= lists.get(p.li).get(p.di);
              pq.add(p);
           }
  
           
        }
  
  
  
        return rv;
     }
  
     public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int k = Integer.parseInt(br.readLine());
        ArrayList<ArrayList<Integer>> lists = new ArrayList<>();
        for(int i = 0; i < k; i++){
           ArrayList<Integer> list = new ArrayList<>();
  
           int n = Integer.parseInt(br.readLine());
           String[] elements = br.readLine().split(" ");
           for(int j = 0; j < n; j++){
              list.add(Integer.parseInt(elements[j]));
           }
  
           lists.add(list);
        }
  
        ArrayList<Integer> mlist = mergeKSortedLists(lists);
        for(int val: mlist){
           System.out.print(val + " ");
        }
        System.out.println();
     }
}
