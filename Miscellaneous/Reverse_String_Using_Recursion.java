package com.company.Miscellaneous;

public class Reverse_String_Using_Recursion {
    public static void main(String[] args) {
        char[] ch = {'h','e','l','l','o'};
    }

    static char[] reverse(char[] ch,int index){
        if(index == ch.length){
            return ch;
        }
        ch[index] = ch[ch.length - 1 - index];
        return reverse(ch,index+1);
    }
}
