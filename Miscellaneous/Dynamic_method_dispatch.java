package com.company.Miscellaneous;


class Phone{
    public void greet(){
        System.out.println("Good morning!!!");
    }
    public void on(){
        System.out.println("Turning On phone....");
    }
}
class SmartPhone extends Phone{
    public void welcome(){
        System.out.println("Welcome to smart phone");
    }
    public void on(){
        System.out.println("Turning on smart phone....");
    }
}
public class Dynamic_method_dispatch{
    public static void main(String[] args) {
        //Runtime Polymorphism
//        Phone obj = new Phone(); //Allowed
//        SmartPhone obj1=new SmartPhone(); //Allowed
//        obj.greet();
//        obj1.welcome();
        Phone obj = new SmartPhone();    //Allowed   //Here reference is of Phone class and object is created of SmartPhone class
        // SmartPhone obj2 = new Phone();         //Not Allowed

        obj.on();   //Overriding method of sub class(SmartPhone) is executed
        //obj.welcome();   //Not Allowed

        //Method of only Phone class is executed, methods of SmartPhone class(except overriding methods) are not executed.

    }
}
