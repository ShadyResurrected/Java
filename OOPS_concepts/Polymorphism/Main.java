package com.company.OOPS_concepts.Polymorphism;

public class Main {
    public static void main(String[] args) {
        Shapes obj1 = new Shapes();
        Shapes sq = new Shapes();
        Shapes circle = new Circle(); // it overrides the area method from the parent class Shapes
        //if area method from the parent class is deleted then it will throw error

        circle.area();
    }
}
