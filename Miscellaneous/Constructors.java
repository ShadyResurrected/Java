package com.company.Miscellaneous;
class worker{
    int No;
    String Name;
    int Salary;

    public worker(String N,int Nu){ //Constructor(Used to instantiating object)
        Name=N;                     //Constructor Overload
        No=Nu;
        if(No==1)
            Salary=10000;
    }
    public worker(){
        Name="raja";
        No=2;
    }
}
public class Constructors {
    public static void main(String[] args) {
        worker Mason=new worker("Bob",2);
//        System.out.println(Mason.No);
//        System.out.println(Mason.Name);
//        System.out.println(Mason.Salary);
        worker Mason1=new worker();
        System.out.println(Mason1.Name);
        System.out.println(Mason1.No);
    }
}
