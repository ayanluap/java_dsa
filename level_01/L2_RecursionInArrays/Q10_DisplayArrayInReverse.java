package L2_RecursionInArrays;
import java.util.*;

public class Q10_DisplayArrayInReverse {
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
        displayArr(arr, idx+1);
        System.out.println(arr[idx]);
    }
}
