package com.company.OOPS_concepts.Interfaces;

public class PowerEngine implements Engine{
    @Override
    public void start() {
        System.out.println("Power Engine start");
    }

    @Override
    public void stop() {
        System.out.println("Stop the power engine");
    }

    @Override
    public void acc() {
        System.out.println("Accelerate the power engine");
    }
}
