


class Student{
    String name;
    int age;
    
    ///// POLYMORPHISM (2 types -> 01. function overloading, 02. function overriding)

    // Function overloading [Compile time polymorphism]
    Student(){
        System.out.println("no args passed");
    }

    Student(String name){
        System.out.println("name : "+name);
    }

    Student(int age){
        System.out.println("age : "+age);
    }

    Student(String name, int age){
        this.name=name;
        this.age=age;
        System.out.println("name & age : "+name+" "+age);
    }
}

///// INHERITANCE [increases reusability] 

// 4 types of INHERITANCE in JAVA    [in CPP there are 5 types extra one is MULTIPLE LEVEL INHERITANCE]
// 01. Single level
// 02. Multilevel level
// 03. Heirarchial
// 04. Hybrid

// base-class OR parent-class
class Shape{
    String color;
}
// child-class OR sub-class
class Triangle extends Shape{
    
}

/////   ACCESS MODIFIERS

// 01. public       (can be accessed by any Class or Package - thats why main func is always written in public class so  that it can always be accessible )

// 02. default      (when we dont provide any access modifier its auto. set to default can be accessed within a Package but not bt other Packages)

// 03. protected    (can be accessed by ANY CLASSES OF OWN PACKAGE and ONLY SUB-CLASSES OF OTHER PACKAGES)

// 04. private      (can be accessed only inside the class. If need to modify or store Private attributes/methods we need to setup GETTERS & SETTERS)



public class OOPS {
    public static void main(String args[]){
        Student s1=new Student("ayan",23);

        Triangle t1=new Triangle();
        t1.color="red";
    }
}
