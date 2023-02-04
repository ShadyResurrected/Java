package com.company.Miscellaneous;

public class Find_The_difference {
    public static void main(String[] args) {
        String s = "";
        String t = "y";
        System.out.println(find(s,t));
    }

    static char find(String s, String t){
        boolean confirm = false;
        if(s.equals("")){
            return t.charAt(0);
        }
        for(int i = 0 ; i < t.length(); i++){
            for(int j = 0 ; j < s.length(); j++){
                if(t.charAt(i) == s.charAt(j)){
                    break;
                }else
                    confirm = isCorrectChar(s,t.charAt(i));

                if(confirm){
                    return t.charAt(i);
                }
            }
        }


        return ' ';
    }

    static boolean isCorrectChar(String s,char ch){
        for(int i = 0 ; i < s.length(); i++){
            if(s.charAt(i) == ch){
                return false;
            }
        }

        return true;
    }
}
