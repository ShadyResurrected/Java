package com.company.Miscellaneous;

class EkClass{
    int a;
    public int get(){
        return a;
    }
    EkClass(){
        System.out.println("I m the default constructor from parent class");
    }
    EkClass(int a){
        this.a = a;   //this is a way for us to reference an object of the class which is being created/referenced || For ex- "this.area=2" -> this is a reference to current object
        System.out.println("I m the constructor from parent class with value of a as "+a);
    }
    public int returnNone(){
        return 1;
    }

}
class DoClass extends EkClass{
    public DoClass(){
        System.out.println("I m the default constructor from base class");
    }
    public DoClass(int c){
        super(c);
        System.out.println("I m the constructor from base class with value of c as "+c);
    }
}
public class this_super_keyword {
    public static void main(String[] args) {
        //EkClass One=new EkClass(5);
        //System.out.println(One.get());
        DoClass D=new DoClass(67);

//        SUPER KEYWORD
//        A reference variable used to refer immediate parent class object
//        Can be used to refer immediate parent class instance variable
//        Can be used to invoke parent class methods
//        Can be used to invoke parent class constructors
//
    }
}
