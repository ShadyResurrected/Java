package com.company.Miscellaneous;


/*
abstract class AB{
    abstract void moveTo(int x,int y);  //Abstract method (A method which is declared without implementation is called abstract method)
}
*/

abstract class Parent{
    public Parent(){
        System.out.println("I m constructor from parent class");
    }
    public void sayHello(){
        System.out.println("Hello");
    }
    abstract public void greet();
    abstract public void greet2();
}

class Child extends Parent{
    @Override
    public void greet(){
        System.out.println("Good morning");
    }
   /*

   public Child(){
        System.out.println("Alright");
    }

    */
    @Override
    public void greet2(){
        System.out.println("Again Good morning");
    }
}
abstract class Child2 extends Parent{
    public Child2(){
        System.out.println("I m constructor of Child2 class");
    }
}

public class AbstractClass_Methods {
    public static void main(String[] args) {
        //Objects of abstract classes cannot be instantiated and created.
        Child cd=new Child();
        //cd.greet();
    }
}

