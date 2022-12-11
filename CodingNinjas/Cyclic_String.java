package com.company.CodingNinjas;

public class Cyclic_String {
    public static void main(String[] args) {
        String a = "qwerty";
        String b = "swevta";
        for(int i = 0; i < a.length(); i++){
            char characterA = a.charAt(i);
            char characterB = b.charAt(i);
            if((characterA - characterB) % 2 != 0){
                break;
            }
        }
    }
}
