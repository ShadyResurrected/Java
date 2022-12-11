package com.company.Miscellaneous;

import java.util.ArrayList;

public class Add_to_Array_Form_Integer {
    public static void main(String[] args) {
        int[] num = {9,9,9,9,9,9,9,9};
        int k = 1;
        System.out.println(integerForm(num,k));
    }



    static ArrayList<Integer> integerForm(int[] num, int k){
//        long ans = 0;
        ArrayList<Integer> list = new ArrayList<>();
//        for(int i = 0; i < num.length ; i++){
//            ans += decimalConvert(num[i],num.length - 1 - i);
//        }
//
//        ans += k;
//
//        int count = lengthOfDecimal(ans);
//
//        while(count > 0){
//            list.add((int)(ans / Math.pow(10,count-1)));
//            ans = (long)(ans % Math.pow(10,count-1));
//            count--;
//        }
//
//        return list;

        int ans = 0;
        int count = num.length;
        int i = 0;
        while(k != 0 && count != 0){
            int digit = k % 10;
            int sum = num[num.length-1-i] + digit;
            if(sum >= 10){
                sum = sum - 10;
                num[num.length - 1 - i] = sum;
                if(num.length-2-i < 0){
                    list.add(1);
                }else
                    num[num.length - 2 - i] += 1;
            } else
                num[num.length - 1 - i] += digit;
            i++;
            count--;
            k = k / 10;
        }
        for (int element : num){
            list.add(element);
        }
        return list;
    }

    static long decimalConvert(int number, int times){
        return (long)(number * Math.pow(10,times));
    }

    static int lengthOfDecimal(long number){
        int count = 0;
        while(number != 0){
            number = number/10;
            count++;
        }
        return count;
    }
    static int lengthOfDecimal1(int number){
        int count = 0;
        while(number != 0){
            number = number/10;
            count++;
        }
        return count;
    }
}
