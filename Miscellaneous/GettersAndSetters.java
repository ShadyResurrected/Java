package com.company.Miscellaneous;
class Circle{
    private float radius;
    private float perimeter;
    private float area;

    public void getR(float R){
        radius=R;
    }
    public float setRad(){
        return radius;
    }

    public void getA(float A){
        area=A;
    }
    public float setA(){
        float Area=(float)(3.14)*(radius*radius);
        if(area==Area)
            return 1;
        else
            return 0;
    }
}
class Student{
    private int Roll_No;
    private String  Name;

    public void getName(String N){
            Name=N;
    }
    public void setName(){
        System.out.println(Name);
    }

    public void getRoll(int R){
        Roll_No=R;
    }
    public int setRoll(){
        return Roll_No;
    }
}
public class GettersAndSetters {
    public static void main(String[] args) {
        Student Chandra=new Student();

        /*

        int R=Chandra.Roll_No=2;
        String N=Chandra.Name="Chandradeep Chandra";
        System.out.println(R);
        System.out.print(N);

        Chandra.getName("Chandradeep Chandra");
        Chandra.setName();
        Chandra.getRoll(3);
        int R=Chandra.setRoll();
        System.out.print(R);

         */
        Circle Rad=new Circle();
        Rad.getR(2.0f);
        System.out.println(Rad.setRad());

        Rad.getA(12.56f);
        if(Rad.setA()==0)
            System.out.println("Incorrect");
        else
            System.out.println("Correct");
        //System.out.println(Rad.setA());
    }
}
