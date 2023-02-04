package com.company.Miscellaneous;

public class Happy_Number {
    public static void main(String[] args) {
        int n = 19;
    }

    public boolean isHappy(int n) {
        boolean result = false;
        int sum = 0;
        if((int)(Math.log10(n)+1) == 1){
            return false;
        }
        while(n > 0){
            sum += Math.pow(n%10,2);
            n /= 10;
        }

        if(sum == 1){
            return false;
        }
        return isHappy(sum);
    }
}
