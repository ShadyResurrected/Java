package com.company.String;

public class Count_And_Say {
    public static void main(String[] args) {
        int n = 3;
        String str = "11";
        for(int i = 3;i <= n; i++){
            String t = "";
            str = str + '#'; // Used as a delimiter
            int count = 1;
            for(int j = 1;j < str.length();j++){
                if(str.charAt(j) != str.charAt(j-1)){
                    t = t + Integer.toString(count);
                    t = t + str.charAt(j-1);
                    count = 1;
                }else count++;
            }
            str = t;
        }
    }
}
