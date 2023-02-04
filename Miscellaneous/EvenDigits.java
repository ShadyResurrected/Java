package com.company.Miscellaneous;

public class EvenDigits {
    public static void main(String[] args){
        int[] arr = {18,124,9,-1764,98,12,0};
        int result = Even(arr);
        System.out.println(result);
    }

    static int Even(int[] arr){
        int count = 0;
        for(int i:arr){

            if(i < 0){  //If the number is negative
                i = i * -1;
            }
            if(i == 0){
                continue;
            }
            int even = 0;
            while(i != 0){
                i = i / 10;
                even++;
            }
            if(even % 2 == 0){
                count++;
            }
        }
        return count;
    }
}
