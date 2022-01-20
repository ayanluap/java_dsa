package beginning;
import java.util.*;

public class NestedLoops {
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);

        ///// Print Hollow reactangle
        // int l=sc.nextInt();
        // int b=sc.nextInt();

        // for(int i=0; i<b; i++){
        //     if(i==0 || i==b-1){
        //         for(int j=0; j<l; j++){
        //             System.out.print("* ");
        //         }
        //     }else {
        //         System.out.print("* ");
        //         for(int j=0; j<(l-2)*2; j++){
        //             System.out.print(" ");
        //         }
        //         System.out.print("* ");
        //     }
        //     System.out.println();
        // }

        ///// Print half pyramid [Pattern 01]
        // int pyramidSize=sc.nextInt();
        // for(int i=1; i<=pyramidSize; i++){
        //     for(int j=1; j<=i; j++) {
        //         System.out.print("* ");
        //     }
        //     System.out.println();
        // }

        ///// Print solid rhombus
        // int size=sc.nextInt();
        // int i=size-1;
        // while(i>=0){
        //     for(int j=0; j<i; j++){
        //         System.out.print("  ");
        //     }
        //     for(int j=0; j<size; j++){
        //         System.out.print("* ");
        //     }
        //     System.out.println();
        //     i--;
        // }

        ///// Print number pyramid
        int size=sc.nextInt();
        int i=1;
        while(i<=size){
            for(int j=1; j<=size-i; j++){
                System.out.print(" ");
            }
            for(int j=1; j<=i; j++){
                System.out.print(i+" ");
            }
            System.out.println();
            i++;
        }
    }
}
