package com.company.OOPS_concepts;

public class OOP_1 {
    public static void main(String[] args) {
//        Creating Objects
        Student stu1 = new Student();
        Student stu2 = new Student(88.7f,4,"CDE");
        Student stu3 = new Student(stu2);

        Student[] stu = new Student[5];


//        Manipulating Objects
//        stu1.marks = 23.4f;
//        stu1.sno = 3;
//        stu1.name = "ABC";
//        stu1.greeting();
//        System.out.println(stu1.marks);
//        System.out.println(stu2.marks);
//        System.out.println(stu2.sno);
//        System.out.println(stu2.name);
        System.out.println(stu3.name);
        System.out.println(stu1.name);
    }
}

class Student{
    int sno;
    String name;
    float marks;

//    This below is a constructor and its return type is that of the class

    void greeting(){
        System.out.println("Hello! My name is " + name);
    }
//    By default these values will be passed
    Student(){
//        this.marks = 23.4f;
//        this.sno = 3;
//        this.name = "ABC";
//        Calling a constructor from another constructor
        this(34.8f,3,"Pawan");

    }
//    Passing an object as a parameter to the constructor
    Student(Student obj2){
        this.name = obj2.name;
    }
    Student(float marks,int sno,String name){
        this.marks = marks;
        this.sno = sno;
        this.name = name;
    }
}
