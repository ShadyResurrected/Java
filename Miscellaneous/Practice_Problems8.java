package com.company.Miscellaneous;
import java.util.Scanner;
class employee1{
    int Salary;
    public int getSalary(){
        return Salary;
    }
    String name;
    public void SetName(String N){
        name=N;
    }
    public String getName(){
        return name;
    }
}
class cellphone{
    public void ringing(){
        System.out.println("Ringing.....");
    }
    public void vibrating(){
        System.out.println("Vibrating....");
    }
    public void CallFriend(){
        System.out.println("CallFriend.....");
    }
}
class Square{
    int side;
    public int Area(int a){
        int Ar=a*a;
        return Ar;
    }
    public int Peri(int a){
        int Per=4*a;
        return Per;
    }
}
class TommyVercetti{
    public void run(){
        System.out.println("Running");
    }
    public void hitting(){
        System.out.println("Hitting pedestrians");
    }
    public void firing(){
        System.out.println("Firing");
    }
}
class Rectangle{
    int length;
    int breadth;
    public int Area(int L,int B){
        int A=L*B;
        return A;
    }
    public int Perim(int L,int B){
        int P=2*(L+B);
        return P;
    }
}
public class Practice_Problems8 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        //Problem 1
        /*
        employee1 Ch=new employee1();
        Ch.SetName("ABC");
        System.out.print("Enter salary: ");
        int Sal=sc.nextInt();
        Ch.Salary=Sal;
        System.out.println(Ch.getName());
        int S=Ch.getSalary();
        System.out.println(S);

         */

        //Problem 2
        /*

        cellphone OnePlus=new cellphone();
        OnePlus.ringing();
        OnePlus.vibrating();

         */

        //Problem 3
        /*

        Square One=new Square();
        System.out.print("Enter the side of square: ");
        int s=sc.nextInt();
        One.side=s;
        int Area=One.Area(s);
        System.out.println(Area);
        int Pe=One.Peri(s);
        System.out.println(Pe);

         */

        //Problem 4
        /*

        TommyVercetti Vice=new TommyVercetti();
        Vice.firing();
        Vice.hitting();
        Vice.run();

         */

        //Problem 5
        Rectangle First=new Rectangle();
        System.out.print("Enter the length: ");
        int L=sc.nextInt();
        First.length=L;
        System.out.print("Enter the breadth");
        int B=sc.nextInt();
        First.breadth=B;
        int Area=First.Area(L,B);
        int Perimeter= First.Perim(L,B);
        System.out.println(Area);
        System.out.println(Perimeter);
    }
}
