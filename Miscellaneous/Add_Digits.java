package com.company.Miscellaneous;

public class Add_Digits {
    public static void main(String[] args) {
        int n = 34;
        System.out.println(sum(n));
//        System.out.println((Math.log10(n)));
    }

    static int sum(int n){
        int ans = 0;

        while(n > 0){
            ans += n % 10;
            n /= 10;
        }
        if(ans/10 == 0){
            return ans;
        }

        return sum(ans);
    }
}
