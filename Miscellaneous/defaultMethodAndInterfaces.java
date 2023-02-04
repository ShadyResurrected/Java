package com.company.Miscellaneous;

interface Camera{
    void takeSnap();
    void recordVideo();
    private void greet(){
        System.out.println("Goodmorning");
    }
    default void record4KVideo(){
        greet();
        System.out.println("Recording in 4K....");
    }
}
interface Wifi{
    String [] getNetwork();
    void connectToNetwork(String network);
}
class MyCellPhone{
    void callNumber(int phoneNumber){
        System.out.println("calling... "+ phoneNumber);
    }
    void pickCall(){
        System.out.println("Connecting...");
    }
}
class MySmartPhone extends MyCellPhone implements Camera, Wifi{
    public void takeSnap(){
        System.out.println("Taking a snap");
    }
    public void recordVideo(){
        System.out.println("Recording Video");
    }
//    public void record4KVideo(){
//        System.out.println("Recording Video in 4K");
//    }
    public void connectToNetwork(String network){
        System.out.println("Authenticating to...." + network);
    }
    public String[] getNetwork(){
        System.out.println("Getting Networks");
        String[] networkList = {"ABC","BIAS","i-ball Baton"};
        return networkList;
    }
}
public class defaultMethodAndInterfaces {
    public static void main(String[] args) {
        MySmartPhone M = new MySmartPhone();
        M.record4KVideo();
        // M.greet();  --> Throws an error!
        String[] arr=M.getNetwork();
        for(String item:arr)
        {
            System.out.println(item);
        }

    }
}
