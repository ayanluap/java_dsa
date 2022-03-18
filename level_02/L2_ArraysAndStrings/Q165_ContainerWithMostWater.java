package L2_ArraysAndStrings;
import java.util.*;
import java.io.*;

//  1. You will be given coordinates as an array wherein, x,y is written as i,a[i]
//  2. So two endpoints of vertical line i is at (i, a[i]) and (i, 0)
//  3. You need to find two lines, which together along with x-axis forms a container, such that the container contains the most water
//  4. Input and output is handled for you
//  5. It is a functional problem ,please do not modify main()
 
//  NOTE: a) a[i] value need not be distinct
//        b) You can't slant a line

// Constraints
// Array size is limited to integral range

public class Q165_ContainerWithMostWater {
    public static void main(String args[]){
        // write your code here
        Scanner sc= new Scanner(System.in);
        int n= sc.nextInt();
        int arr[]= new int[n];
        for(int i=0; i<n; i++) arr[i]= sc.nextInt();

        int i=0, j=n-1, res=Integer.MIN_VALUE;

        while(i<j) {
            int val= Math.min(arr[i], arr[j]) * (j-i);
            if (arr[i] <= arr[j]) i++;
            else j--; 
            res= Math.max(res, val);
        }

        System.out.println(res);
    }
}
