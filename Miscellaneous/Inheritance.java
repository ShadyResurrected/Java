package com.company.Miscellaneous;

class Base{
    public int x;

    public void setX(int num){
        System.out.println("I m setting x from Base class");
        x=num;
    }
    public int getX(){
        return x;
    }
}
class Derived extends Base{
    public int y;

    public void setY(int num){
        System.out.println("I am setting y from Derived class");
        y=num;
    }
    public int getY(){
        return y;
    }
}
public class Inheritance {
    public static void main(String[] args) {
        //base class
        Base b1=new Base();
        b1.setX(4);
        System.out.println(b1.getX());

        //Derived class
        Derived d1=new Derived();
        d1.setX(5);
        System.out.println(d1.getX());
        d1.setY(7);
        System.out.println(d1.getY());
    }
}
