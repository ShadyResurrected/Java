package com.company.Miscellaneous;

class Circle1{
    int r;
    public Circle1(int r){
        this.r=r;
        System.out.println("I m circle parameterized constructor with value fo r as "+ r);
    }
    public Circle1(){
        System.out.println("I m circle non-parameterized constructor");
    }
    public void setRadius(int radius){
        r=radius;
    }
    public void getRadius(){
        System.out.println("Radius of circle is "+ r);
    }
    public double area(){
        return Math.PI*this.r*this.r;
    }
}
class Cylinder1 extends Circle1{
    int h;
    public Cylinder1(int h,int r){
        super(r);
        System.out.println("I m cylinder parameterized constructor");
        this.h=h;
    }
    public void setHeight(int h){
        h=this.h;
    }
    public double area(){
        return Math.PI*this.r*this.r*h;
    }
}

class Rectangle1{
    int length,breadth;
    public Rectangle1(){
        System.out.println("I m non parameterized constructor from Rectangle1 class");
    }
    public Rectangle1(int length,int breadth){
        this.length=length;
        this.breadth=breadth;
        System.out.println("I m parameterized constructor from Rectangle1 class with length as "+ length +" and breadth as "+breadth);
    }
    public int area(){
        return length*breadth;
    }
    public void setLength(int length){
        this.length=length;
    }
    public void getLength(){
        System.out.println("Length of rectangle is "+length);
    }

    public void setBreadth(int breadth) {
        this.breadth = breadth;
    }

    public int getBreadth() {
        return breadth;
    }
}

class cuboid extends Rectangle1{
    int length,breadth,height;
    public cuboid(){
        System.out.println("I m non parameterized constructor from cuboid class");
    }
    public cuboid(int length,int breadth,int height){
        super(length,breadth);
        this.length=length;
        this.breadth=breadth;
        this.height=height;
        System.out.println("I m parameterized constructor from cuboid class with length as "+ length + " and breadth as "+breadth+" and height as "+height);
    }
}
public class Practice_Problems10 {
    public static void main(String[] args) {
        //PROBLEM 1
        // Circle1 C1=new Circle1(2);
        // C1.setRadius(2);
        // double Area=C1.area();
        // System.out.println(Area);
        // Cylinder1 cb=new Cylinder1(4,5);

        //PROBLEM 2
        // Rectangle1 Rect=new Rectangle1(3,4);
        // cuboid Cu=new cuboid(45,67,87);
        // int area=Rect.area();
        // System.out.println("Area of rectangle is "+ area);

        Rectangle1 rec=new Rectangle1();
        rec.setLength(4);
        rec.getLength();

    }
}
