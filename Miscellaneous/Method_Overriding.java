package com.company.Miscellaneous;

class A{
    public void method1(){
        System.out.println("I m method 1 from class A");
    }
    public void method2(){
        System.out.println("I m method 2 from class A");
    }
}

class B extends A{
    public void method3(){
        System.out.println("I m method 3 from class B");
    }
    @Override
    //Method Overriding
    public void method2(){
        System.out.println("I m method 2 from class B");
    }
}
public class Method_Overriding {
    public static void main(String[] args) {
        A a=new A();

        //a.method1();
        //a.method2();

        B b =new B();
        b.method2();

        /*
        Method Overriding
        If the child class implements the same method present in the parent class again, it is known as method Overriding.

        When an object of subclass is created and the overrided method is called, the method which has been implemented in the subclass is called & its code is executed.
         */
    }
}
