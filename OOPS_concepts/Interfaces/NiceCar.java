package com.company.OOPS_concepts.Interfaces;

import jdk.jshell.spi.ExecutionControl;

public class NiceCar {

    private Engine engine;
    private Media_Player player = new CDPlayer();

    public NiceCar(){
        engine = new PowerEngine(); // By default, all the methods of the power engine class will be applied
    }

    public NiceCar(Engine engine){
        this.engine = engine;
    }

    public void start(){
        engine.start(); // it will decide which method to call based on the type of the engine selected
    }

    public void stop(){
        engine.stop();
    }

    public void musicStart(){
        player.start();
    }

    public void upgradedEngine(Engine engine){
        this.engine = engine;
    }
}
