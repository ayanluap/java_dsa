package L2_RecursionInArrays;
import java.util.*;

// 1. You are given a number n, representing the size of array a.
// 2. You are given n numbers, representing elements of array a.
// 3. You are required to print the elements of array from beginning to end each in a separate line.
// 4. For the above purpose complete the body of displayArr function. Don't change the signature.

public class Q9_DisplayArray {
    public static void main(String[] args) throws Exception {
        Scanner sc=new Scanner(System.in);
        // write your code here
        int size=sc.nextInt();
        int arr[]=new int[size];

        for (int i=0; i<size; i++) {
            arr[i]=sc.nextInt();
        }
        displayArr(arr, 0);
    }

    public static void displayArr(int[] arr, int idx){
        if(idx==arr.length) return;
        System.out.println(arr[idx]);
        displayArr(arr, idx+1);
    }
}
