package com.company.String;


public class Reverse_Words_In_String {
    public static void main(String[] args) {
        String str = "I love    coding";
        String ans = "";
        int N = str.length();
        int outerI = 0;
        int i = 0;
        int j = 0;
        while(outerI < N){
            while(i < N && str.charAt(i) == ' ') i++;
            j = i;
            while(j < N && str.charAt(j) != ' ') j++;
            String midAns = str.substring(i,j);
            if(!ans.isEmpty())
            {
                ans = midAns + " " + ans;
            }
            else ans += midAns;
            outerI = j + 1;
            i = outerI;
        }
        System.out.println(ans);
    }
}
