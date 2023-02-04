package com.company.Miscellaneous;

public class NoOfSetBits {
    public static void main(String[] args) {
        int n = 56;
        int count = 0;
        System.out.println(Integer.toBinaryString(n));

//        First Method
//        while(n > 0){
//            if((n & 1) == 1){
//                count++;
//            }
//            n = n >> 1;
//        }
//        System.out.println(count);

//        Second Method
//        while(n > 0){
//            count++;
//            n = n & (n-1);
//        }
//        System.out.println(count);


//        Third Method
        while(n > 0){
            count++;
            n = n - (n & (-n));
        }
        System.out.println(count);
    }
}
