package com.company.LeetCode;

import java.util.*;

public class Add_To_Array_Form_of_Integer {
    public static void main(String[] args) {
        int[] num = {2,7,4};
        int k = 181;
        System.out.println(addToArrayForm(num,k));
    }

    public static List<Integer> addToArrayForm(int[] num, int k) {
        List<Integer> list = new ArrayList<>();

        int len = (int)Math.floor(Math.log10(k) + 1);
        int[] num2 = new int[len];
        while(k > 0){
            int digit = k % 10;
            num2[len-1] = digit;
            k /= 10;
            len--;
        }

        int carry = 0;
        int i = num.length - 1;
        int j = num2.length - 1;
        while(i >= 0 || j >= 0 || carry != 0){
            int mid1 = i >= 0 ? num[i] : 0;
            int mid2 = j >= 0 ? num2[j] : 0;

            int total = mid1 + mid2 + carry;

            list.add(total % 10);

            carry = total / 10;

            i--; j--;
        }

        Collections.reverse(list);
        return list;
    }
}
