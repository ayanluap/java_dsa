package beginning;
import java.util.*;

public class StringsAdv {
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);

        String s=sc.nextLine();
        StringBuilder str=new StringBuilder(s);

        int i=0;
        int j=str.length()-1;

        while(i<j){
            char front=str.charAt(i);
            char back=str.charAt(j);
            str.setCharAt(i, back);
            str.setCharAt(j, front);
            i++; j--;
        }

        System.out.println(str);



    }
}
