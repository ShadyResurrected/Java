package com.company.Miscellaneous;

public class Shuffle_string {
    public static void main(String[] args) {
        String s = "codeleet";
        int[] indices = {4,5,6,7,0,2,1,3};
        System.out.println(shuffle(s,indices).toString());
    }

    static StringBuilder shuffle(String s, int[] indices){
        StringBuilder str = new StringBuilder(s);
        int count = 0;
        for(int pos: indices) {
            str.setCharAt(pos,s.charAt(count));
            count++;
        }
        return str;
    }
}
