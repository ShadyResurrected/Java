package com.company.OOPS_concepts.Abstract_Classes;

public class Son extends Parent{
    public Son(int age) {
        super(age);
        this.age = age;
        System.out.println("Son age is " +  age);
    }

    @Override
    void career(){
        System.out.println("I want to be a coder");
    }

    @Override
    void phone() {
        System.out.println("I will buy Iphone 32");
    }
}
