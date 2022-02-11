
import java.util.*;

public class Strings {
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);

        ///// String declaration

        // String name="tony";
        // String fullName="tony stark";
        // String sentence="This is Tony Stark";
        // System.out.println(name+" "+fullName+" "+sentence);

        ///// Taking String inputs from user

        // String str=sc.nextLine();
        // System.out.println(str);

        ///// Contatination in string
        String firstName="tony";
        String lastName="stark";
        String fullName=firstName+" "+lastName;
        System.out.println(fullName);
        
        // string methods

        //  length()
        System.out.println(fullName.length());

        // chatAt()
        System.out.println(fullName.charAt(4));

        // compareTo()
        // NOTE : Never use == to compare strings in java cuz it will give error in many cases
        if(fullName.compareTo(lastName)==0){
            System.out.println("Strings are equal!");
        }else{
            System.out.println("Strings are NOT equal!");
        }

        // substring 
        System.out.println(fullName.substring(3));
        System.out.println(fullName.substring(3,7));


    }
}
