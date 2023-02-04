package com.company.CompilerDesign;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class First {
    public static void main(String[] args) throws IOException {
        FileReader fr = new FileReader(
                "C:\\Users\\Chandradeep Chandra\\Desktop\\Trial.txt");
        int i;
        int count = 0;
        String str = "";
        while ((i = fr.read()) != -1){
            count++;
            str += (char)(i);
            System.out.print((char)i);
        }
        Scanner sc = new Scanner("C:\\Users\\Chandradeep Chandra\\Desktop\\Trial.txt");
        int line = 0;
        while(sc.hasNextLine()){
            sc.nextLine();
            line++;
        }
        String[] arrOfStr = str.split(" ");
        System.out.println();
        System.out.println("No. of lines are: " + line);
        System.out.println("No. of characters in the string are: " + count);
        System.out.println("No. of words in the string are : " + arrOfStr.length);
    }
}
