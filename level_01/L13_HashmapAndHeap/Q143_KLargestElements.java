package L13_HashmapAndHeap;
import java.util.*;
import java.lang.*;
import java.io.*;


// 1. You will be given an Array with its length
//  2. You will also be given an integral value k
//  3. You need to find k largest elements from the given array
//  4. Input is handled for you
//  5. It is a functional problem ,please do not modify main()

// Constraints
// 1 <= N <= 100
//  K <= N
//  -1000 <= C[i] <= 1000

public class Q143_KLargestElements {
    public static void main (String[] args) throws IOException
 	  {
 	 	 Scanner scn= new Scanner(System.in);
 	    	 int n = scn.nextInt();
 	 	 int[] num = new int[n];
 	 	 for (int i = 0; i < n; i++) {
 	 	 	 	 num[i] = scn.nextInt();
 	 	 	 }
 	 	 int k = scn.nextInt();
 	 	 solve(n,num,k);
 	  }
 	 // -----------------------------------------------------
 	 // This is a functional problem. Only this function has to be written.
 	 // This function takes as input an array,n length of array and k.
 	 // It should print required output.
 	  public static void solve(int n,int[] arr,int k){
 	     //Write your code here
		  PriorityQueue<Integer> pq= new PriorityQueue<>(Collections.reverseOrder());

		  for(int val: arr) pq.add(val);

		  while(k>0) {
			  System.out.print(pq.peek()+" ");
			  pq.remove();
			  k--;
		  }
     }
}
