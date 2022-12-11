package com.company.OOPS_concepts.Inheritance;

public class Main {
    public static void main(String[] args) {
        Box bx1 = new Box(6.7,8,9);
        System.out.println(bx1.height + " " + bx1.length + " " + bx1.width);

        BoxWeight bx2 = new BoxWeight();
        System.out.println(bx2.weight + " " + bx2.height);

        BoxWeight bx3 = new BoxWeight(2,3,4,5);
        System.out.println(bx3.weight + " " + bx3.length + " " + bx3.width + " " + bx3.height);

        Box bx4 = new BoxWeight(4,5,6,3);
        // here reference type is of parent class and objet instantiation is of Child class, so it will have access to the members of the parent class

        // ERROR Explained
        // here we are given access to the members reference type i.e. BoxWeight
        // so we should have access to the weight variable
        // this also means that the variables we try to access are initialised
        // but here since the object is of type parent class, how will you call the constructor of the child class
//        BoxWeight bx5 = new Box(2,3,7);

    }
}
