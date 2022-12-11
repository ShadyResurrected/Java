package com.company.Miscellaneous;
import java.util.Scanner;
class Cylinder{
    private float radius;
    private float height;

     public void setRadius(float R){
         radius=R;
     }
     public float getRadius(){
         return radius;
     }

     public void setHeight(float H){
         height=H;
     }
     public float getHeight(){
         return height;
     }
     public float SurfaceArea(){
         float S=2.0f*3.14f*radius*(height+radius);
         return S;
     }
     public float Volume(){
         float V=3.14f*radius*radius*height;   //For accurate value of Pi use Math.PI
         return V;
     }
     public Cylinder(int R,int H){          //Constructor
         radius=R;
         height=H;
     }

}
class Rect{
    private int length;
    private int breadth;
    public Rect(int L){              //Constructor
        length=L;
        breadth=4;
    }
    public Rect(int L,int B){     //Constructor Overloading
        length=L;
        breadth=B;
    }
    public int getL(){
        return length;
    }
    public int getB(){
        return breadth;
    }
}
public class Practice_Problem9 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);


        //Problem 1&2
        /*
        Cylinder C1=new Cylinder();
        System.out.print("Enter the radius: ");
        int a=sc.nextInt();
        System.out.print("Enter the height: ");
        int b=sc.nextInt();
        C1.setRadius(a);
        C1.setHeight(b);
        //float R=C1.getRadius();
        //System.out.println(C1.getRadius());
        System.out.println(C1.SurfaceArea());
        System.out.println(C1.Volume());
        */
        //Problem 3
    /*
        Cylinder C2=new Cylinder(9,12);
        System.out.println(C2.getRadius());
        System.out.println(C2.getHeight());
        System.out.println(C2.SurfaceArea());
    */
        //Problem 4
        /*
        Rect R1=new Rect(2,7);
        System.out.println(R1.getL());
        System.out.println(R1.getB());
         */

    }
}
