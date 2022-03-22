package L2_ArraysAndStrings;
import java.util.*;

// 1. Given an integer array of size 'n'.
// 2. Return an array answer such that answer[i] is equal to the product of all the elements of arr except arr[i].
// 3. The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.

// Constraints
// 1. 2 <= arr.length <= 10^5
// 2. -30 <= arr[i] <= 30
// 3. The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.

public class Q171_ProductOfArrayExceptItselfWithoutUsingDivisionOperator {
    //~~~~~~~~~~~~~~~~~User Section~~~~~~~~~~~~~~~
    public static int[] productExceptSelf(int[] arr) {
        int[] leftRes= new int[arr.length];
        int[] rightRes= new int[arr.length];
        int[] res= new int[arr.length];
        
        leftRes[0]= arr[0];
        rightRes[arr.length-1]= arr[arr.length-1];
        
        for(int i=1; i<arr.length; i++) {
            leftRes[i]= arr[i] * leftRes[i-1];
        }
        
        for(int i=arr.length-2; i>=0; i--) {
            rightRes[i]= arr[i] * rightRes[i+1];
        }
        
        for(int i=0; i<arr.length; i++) {
            if(i==0) res[i]= rightRes[i+1];
            else if(i==arr.length-1) res[i]= leftRes[i-1];
            else {
             res[i]= leftRes[i-1] * rightRes[i+1];   
            }
        }

        return res;
    }

    //~~~~~~~~~~~~~~~~~Input Management~~~~~~~~~~~~~~~
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }
        int[] res = productExceptSelf(arr);
        for(int i = 0; i < arr.length; i++) {
            System.out.print(res[i] + " ");
        }
    }
}
