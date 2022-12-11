package com.company.OOPS_concepts.Interfaces;

public class CDPlayer implements Media_Player{
    @Override
    public void start() {
        System.out.println("Start the music player");
    }

    @Override
    public void stop() {
        System.out.println("Stop the music player");
    }

    @Override
    public void play() {
        System.out.println("Play the music");
    }
}
