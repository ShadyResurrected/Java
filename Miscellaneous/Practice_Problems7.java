package com.company.Miscellaneous;
import java.util.Scanner;
public class Practice_Problems7 {
    static void table(int a){
        int i,prod;
        for(i=0;i<=10;i++){
            prod=a*i;
            System.out.print(a+"*"+i+"="+prod);
            System.out.println("");
        }
    }
    static void starPattern(int b){
        int i,j;
        for(i=0;i<b;i++){
            for(j=0;j<i+1;j++){
                System.out.print("*");
            }
            System.out.println("");
        }
    }
    // sum(n)= 1 + 2 + 3 +.........+ n
    // sum(n)=1 + 2 + 3 +........+ (n-1)+ n
    // sum(n)=sum(n-1) + n
    static int addRec(int n){
        // Base Condition
        if(n==1){
            return 1;
        }
        else
            return n + addRec(n-1);
    }
    static void reverseStarPattern(int n){
        int i,j;
        for(i=n;i!=0;i--){
            for(j=0;j<i;j++){
                System.out.print("*");
            }
            System.out.println("");
        }
    }
    static int fib(int n){
        if (n==0)
            return 0;
        else if(n==1)
            return 1;
        else
            return (fib(n-1) + fib(n-2));
    }
    static int RstarPattern(int n){
        /*
        int i,j;
        for(i=n;i>1;i--){
            for(j=1;j<i;j++){
                System.out.print("*");
            }
            System.out.println("");
        }

         */

        if(n==0)
            return 0;
        System.out.println("");
        for(int i=n;i>1;i--){
            System.out.print("*");
        }
        n--;
        return (RstarPattern(n));
    }
    static int Avg(int num){
        if(num==0)
            return 0;
        return num+Avg(--num);
    }
    static void RestarPattern(int num){
        /*
        int i,j;
        for(i=1;i<num;i++){
            for(j=0;j<i;j++){
                System.out.print("*");
            }
            System.out.println("");
        }

         */
        int i;
        if(num==0)
            return;
        RestarPattern(--num);
        for(i=1;i<=num;i++){
            System.out.print("*");
        }
        System.out.println("");
    }
    static void DegreeConv(int C){
        int Fa=(C*9/5)+32;
        System.out.println(Fa);
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        //int user;
        //System.out.printf("Enter the number: ");
        //user=sc.nextInt();
        //table(user);

        //System.out.print("Enter the number:");
        //int user=sc.nextInt();
        //starPattern(user);

        //System.out.print("Enter the number: ");
        //int user=sc.nextInt();
        //int k=addRec(user);
        //System.out.print(k);

        //System.out.print("Enter the number here: ");
        //int user=sc.nextInt();
        //reverseStarPattern(user);

        // 0 , 1 , 1 , 2 , 3 , 5 , 8 , 13....... Fibonacci Series
        //int terms,result;
        //System.out.print("Enter the number of terms: ");
        //terms=sc.nextInt();
        //for(int i=0;i<=terms;i++){
          //  result=fib(i);
            //System.out.println(result);
        //}

       /*
        int user;
        user=sc.nextInt();
        RstarPattern(user);

        */

        /*
        int user=sc.nextInt();
        int sum=Avg(user);
        float avg=(float)sum/user;
        System.out.println(sum);
        System.out.println(avg);

         */

        /*
        int user=sc.nextInt();
        RestarPattern(user);

         */

       //int user=sc.nextInt();
        //DegreeConv(user);
    }
}
