package com.company.Miscellaneous;

public class Goal_Parser {
    public static void main(String[] args) {
        String command = "G()(al)";
//                G -> G
//                () -> o
//                (al) -> al
        System.out.println(decipher(command));
    }

    static String decipher(String command){

        StringBuilder str = new StringBuilder(command);

        return command;


    }
}
