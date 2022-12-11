package com.company.OOPS_concepts.Inheritance;

public class Box {
    double height = -1;
    double length = -1;
    double width = -1;

    public Box(){
        this.height = -1;
        this.length = -1;
        this.width = -1;
    }

    public Box(double side){
        this.height = side;
        this.length = side;
        this.width = side;
    }

    public Box(double l, double w, double h){
        this.length = l;
        this.height = h;
        this.width = w;
    }

    public Box(Box old){
        this.height = old.height;
        this.length = old.length;
        this.width = old.width;
    }
}
