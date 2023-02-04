package com.company.Miscellaneous;

public class Find_the_Highest_Altitude {
    public static void main(String[] args) {
        int[] gain = {-5,1,5,0,-7};
        System.out.println(Highest(gain));
    }

    static int Highest(int[] gain){
        int ans = 0;
        int sum = 0;
        for(int k : gain){
            sum += k;
            if(sum > ans){
                ans = sum;
            }
        }

        return ans;
    }
}
