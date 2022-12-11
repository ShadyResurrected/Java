package com.company.Miscellaneous;

import java.util.ArrayList;

public class Skip_Character {
    public static void main(String[] args) {
//        skipChar("","bccadahahf");
//        System.out.println(skipChar2("bccasadfgd"));
//        System.out.println(skipString("asdasdexamplererw"));
//        subseq("","abc");
        System.out.println(subseqRec("","abc"));
    }

    static void skipChar(String initial, String original){
        if(original.isEmpty()){
            System.out.println(initial);
            return;
        }

        if(original.charAt(0) == 'a'){
            skipChar(initial,original.substring(1));
        }else
            skipChar(initial+original.charAt(0),original.substring(1));
    }

    static String skipChar2(String s){
        if(s.isEmpty()){
            return "";
        }
        if(s.charAt(0) == 'a'){
            return skipChar2(s.substring(1));
        }else
            return s.charAt(0) + skipChar2(s.substring(1));
    }

    static String skipString(String s){
        if(s.isEmpty()){
            return "";
        }
        if(s.startsWith("example")){
            return skipString(s.substring("example".length()));
        }else
            return s.charAt(0) + skipString(s.substring(1));
    }

    static void subseq(String p,String up){
//        When the unprocessed string is empty then empty the loop
        if(up.isEmpty()){
            System.out.println(p);
            return;
        }

        char firstch = up.charAt(0);

//        Taking the first char
        subseq(p + firstch,up.substring(1));

//        Ignoring the first char
        subseq(p,up.substring(1));
    }

    static ArrayList<String> subseqRec(String p, String up){
        if(up.isEmpty()){
            ArrayList<String> list = new ArrayList<>();
            list.add(p);
            return list;
        }

        char ch = up.charAt(0);

        ArrayList<String> left = subseqRec(p+ch,up.substring(1));
        ArrayList<String> right = subseqRec(p,up.substring(1));

//        Copying elements from the left list to the right list
        left.addAll(right);
        return left;
    }
}
