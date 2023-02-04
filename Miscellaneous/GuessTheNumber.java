package com.company.Miscellaneous;
import java.util.Scanner;
import java.util.Random;
class Game{
    int RNo1,Number;
    int count=0;
    Random R=new Random();
    Scanner sc1=new Scanner(System.in);
//    int RNo=R.nextInt(100);
//    public void G(){
//        System.out.println(RNo);
//    }
    public Game(){
        RNo1=R.nextInt(100);
    }

    public void takeUserInput(){
        System.out.print("Enter you number: ");
        int n=sc1.nextInt();
        Number=n;
    }

    public void isCorrectNumber(){
        while(count!=10){

            if(RNo1==Number){
                System.out.println("Your number matched!");
                return;
            }
            else if(RNo1<Number){
                System.out.println("Your number is Greater");
                count++;
                takeUserInput();
            }
            else if(RNo1>Number){
                System.out.println("Your number is Smaller");
                count++;
                takeUserInput();
            }
        }
        System.out.println("Game over!!!");
    }
    public void noOfGuesses(){
        System.out.printf("Your score is %d",count);
    }

}
public class GuessTheNumber {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
//        Game guess=new Game();
//        int number=0;
//        //System.out.println(guess.RNo);
//        while(number!=10) {
//            System.out.print("Enter your number here: ");
//            int res = sc.nextInt();
//            if (res == guess.RNo) {
//                System.out.println("Correct");
//                return;
//            }
//            else if (res < guess.RNo)
//                System.out.println("Your number is smaller");
//            else if (res > guess.RNo)
//                System.out.println("Your number is bigger");
//            //System.out.println(guess.RNo);
//            number++;
//            if(number==10)
//                System.out.println("Game over");
//        }
//
//        if(number!=10)
//        System.out.print("Your score is "+ number);

        Game guess1=new Game();
        //System.out.println(guess1.RNo1);
        String know;
        guess1.takeUserInput();
        guess1.isCorrectNumber();
        guess1.noOfGuesses();

    }
}
