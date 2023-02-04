package com.company.OOPS_concepts.Interfaces;

public class Main {
    public static void main(String[] args) {
        Car car = new Car();
        car.stop();
        car.acc();

        NiceCar car1 = new NiceCar();
        car1.start();
        car1.upgradedEngine(new ElectricEngine());
        car1.start();
    }
}
