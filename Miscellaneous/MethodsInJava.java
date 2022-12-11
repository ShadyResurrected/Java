package com.company.Miscellaneous;
import java.util.Scanner;
public class MethodsInJava {
    static void add(){
        int a,b;
        a=3;b=4;
        int sum=a+b;
        System.out.println(sum);
    }
    static void add(int a,int b){
        int sum=a+b;          //Here a and b are formal arguments
        System.out.print(sum);
    }
    static String Giveback(String a){
        String k=a+" Bro";
        return k;
    }
    static void show(int [] arr){
        int i;
        for(i=0;i<arr.length;i++){
            System.out.print(arr[i]);
            System.out.print("\t");
        }
    }
    static boolean equality(int [] arr1,int []arr2){
        boolean res = false;
        int k=arr1.length;
        int h=0;
        for(int i=0;i<arr1.length;i++){
            for(int j=0;j<=i;j++){
                if(arr1[i]==arr2[j])
                    h++;
            }
        }
        if(h==arr1.length){
            return res;
        }
        else
            return false;

    }
    public static void main(String[] args) {

        Scanner sc=new Scanner(System.in);
        /*
        add();      //Here x and y are actual arguments
        int p,q;
        System.out.print("Enter the number p: ");
        p=sc.nextInt();
        System.out.print("Enter the number q: ");
        q=sc.nextInt();
        add(p,q);
        */

        /*
        System.out.print("Enter a statement: ");
        String c=sc.nextLine();
        String J=Giveback(c);
        System.out.print(J);
        */

        //Creating an object
        //String h="Wasp";
        //MethodsInJava obj = new MethodsInJava();
        //String K=obj.Giveback(h);
        //System.out.print(K);

        int [] a1={1,2,3,4,5};
        int [] a2=new int[5];
        System.out.print("Enter the elements: ");
        for(int i=0;i<a2.length;i++){
            int user=sc.nextInt();
            a2[i]=user;
        }
        show(a2);
        boolean check=equality(a1,a2);
        System.out.println(check);


    }
}
