package com.company.Miscellaneous;

public class Modular_Exponentiation {
    public static void main(String[] args) {
        int x = 5;
        int n = 125;
        int m = 7;
        long ans = 1;
        long nn = n;
        if(nn < 0){
            nn = nn * -1;
        }
        while(nn > 0){
            if(nn % 2 == 0){
                x = x * x;
                nn = nn / 2;
            }else{
                ans = ans * x;
                nn = nn - 1;
            }
        }

        if(n < 0){
            ans = 1/ans;
        }
        System.out.println(ans);
        ans = ans%m;
        System.out.println(ans);
    }
}
