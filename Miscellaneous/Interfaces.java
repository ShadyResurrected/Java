package com.company.Miscellaneous;

interface Bicycle{
    int a=65;
    public void applyBrake(int decrement);
    public void speedUp(int increment);
}
 class Hercules implements Bicycle{
    int speed = 9;
    public void applyBrake(int decrement){
        speed=speed-decrement;
        System.out.println("The speed decreased by " + this.speed);
    }
    public void speedUp(int increment){
        speed=speed+increment;
        System.out.println("The speed increased by " + this.speed);
    }
 }
public class Interfaces {
    public static void main(String[] args) {
        Hercules Hq = new Hercules();
        Hq.speedUp(23);
        Hq.applyBrake(45);
        System.out.println(Hq.a);
    }
}
