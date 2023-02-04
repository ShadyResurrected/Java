package com.company.Miscellaneous;

class Base1{
    Base1(){
        System.out.println("I m a base class constructor");
    }
    Base1(int a){
        System.out.println("I m a overloaded constructor of base class with value of a as: "+ a);
    }
}
class Derived1 extends Base1{
    Derived1(){
        //super(1);   //This calls overloaded constructor from base class and sets value of a as 1
        System.out.println("I m a derived class constructor");
    }
    Derived1(int a,int b){
        super(a);
        System.out.println("I m a Overloaded constructor of derived class with value of a : "+ a +" and b : "+ b);
    }
}
class ChildOfDerived extends Derived1{
    ChildOfDerived(){
        System.out.println("I m a constructor of Child class");
    }
    ChildOfDerived(int a,int b,int c){
        super(a,b);
        System.out.println("I m a overloaded constructor of child class with values of a as: " + a +" and b as: " + b +" and c as: "+ c);
    }
}
public class Constructors_In_Inheritance {
    public static void main(String[] args) {
        //Base1 b1=new Base1();
        Derived1 d1=new Derived1(4,5);
        //Derived1 d1=new Derived1(2,3);
        //ChildOfDerived cd=new ChildOfDerived(1,2,3);

    }
}
