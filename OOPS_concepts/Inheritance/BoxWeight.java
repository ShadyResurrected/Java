package com.company.OOPS_concepts.Inheritance;

public class BoxWeight extends Box{
    double weight;

    public BoxWeight(){
        this.weight = -1;
    }

    // In the parent class the parameter is of the Box type
    // Here we are passing the child class
    // It is similar to the concept of Superclass reference variable and subclass object type
    // So it will have access to the members of superclass
    public BoxWeight(BoxWeight other){
        super();
        weight = other.weight;
    }
    public BoxWeight(double length, double height, double width, double weight){
        super(length,width,height); // here the length is initialised by the constructor of the Box
        this.weight = weight;
    }
}
