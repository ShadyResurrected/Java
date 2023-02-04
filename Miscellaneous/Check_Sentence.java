package com.company.Miscellaneous;
// https://leetcode.com/problems/check-if-the-sentence-is-pangram/
public class Check_Sentence {
    public static void main(String[] args){
        String sentence = "thequickbrownfoxjumpsoverthelazydog";
        System.out.println(isPangram(sentence));
    }

    static boolean isPangram(String sentence){
        boolean result = false;
        char check = 'a';
        int count = 0;
        int end = sentence.length() - 1;
        for(int i = 0; i < sentence.length();i++){
            for (int j = 0; j < sentence.length(); j++) {
                if(sentence.charAt(j) == check){
                    count++;
                    check++;
                }
            }
        }
        if (count == 26){
            result = true;
        }
        return result;
    }
}
