// package L13_HashmapAndHeap;
// import java.io.*;
// import java.util.*;

// // 1. You are required to complete the code of our Hashmap class. Please watch the question video carefully. The theoretical details of required functionality is explained in detail there. Implement the functions to achieve what is explained in the theoretical discussion in question video.
// // 2. Input and Output is managed for you.

// public class Q148_WriteHashmap {

//     public static class HashMap<K, V> {

//         // CONTENTS OF HASHMAP
//         private class HMNode {
//             K key;
//             V value;

//             HMNode(K key, V value) {
//                 this.key= key;
//                 this.value= value;
//             }
//         }
//         private int size=0;
//         private LinkedList<HMNode>[] buckets;
        
//         // METHODS IN HASHMAP
//         public HashMap() {
//             initBuckets(4);
//             size= 0;
//         }

//         private void initBuckets(int N) {
//             buckets= new LinkedList[N];

//             // for each buckets make their own LinkedList
//             for(int i=0; i<buckets.length; i++) {
//                 buckets[i]= new LinkedList<>();
//             }
//         }

//         private int hashfn(int key){
//             // int res= key.hash
//         }
//     }
    

//     public static void main(String[] args) throws Exception {
//         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//         HashMap<String, Integer> map = new HashMap();
    
//         String str = br.readLine();
//         while (str.equals("quit") == false) {
//           if (str.startsWith("put")) {
//             String[] parts = str.split(" ");
//             String key = parts[1];
//             Integer val = Integer.parseInt(parts[2]);
//             map.put(key, val);
//           } else if (str.startsWith("get")) {
//             String[] parts = str.split(" ");
//             String key = parts[1];
//             System.out.println(map.get(key));
//           } else if (str.startsWith("containsKey")) {
//             String[] parts = str.split(" ");
//             String key = parts[1];
//             System.out.println(map.containsKey(key));
//           } else if (str.startsWith("remove")) {
//             String[] parts = str.split(" ");
//             String key = parts[1];
//             System.out.println(map.remove(key));
//           } else if (str.startsWith("size")) {
//             System.out.println(map.size());
//           } else if (str.startsWith("keyset")) {
//             System.out.println(map.keyset());
//           } else if (str.startsWith("display")) {
//             map.display();
//           }
//           str = br.readLine();
//         }
//       }
// }
