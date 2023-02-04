package com.company.Miscellaneous;

class Employee{ //Creating a class Employee
    int No;       // There can only be one public class
    String name;
    public String Print(){
        return name;
    }
    public void PrintDetails(){
        System.out.println("Id is: "+ No);
        System.out.print("Name is: "+ name);
    }
}
public class Custom_Class {
    public static void main(String[] args) {
        Employee First= new Employee();//Instantiating a new Employee Object(First)
        Employee Second=new Employee();//Instantiating a new Employee Object(Second)

        //Setting Attributes
        First.No=1;
        First.name="Chandra";
        Second.No=2;
        Second.name="Chandradeep";

        //Printing the attributes
        System.out.println(First.No);
        String N= First.Print();
        System.out.println("This is from class method "+ N);
        Second.PrintDetails();
    }
}
