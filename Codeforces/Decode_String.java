package com.company.Codeforces;

import java.util.HashMap;
import java.util.Scanner;
import java.util.Stack;

public class Decode_String {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int Timess = in.nextInt();
        while(Timess-- > 0){
            int length = in.nextInt();
            long DecodedString = in.nextLong();
            Stack<Character> stack = new Stack<>();
            StringBuilder res = new StringBuilder();
            HashMap<Long,Character> hMap = new HashMap<>();
            for (long i = 0;i < 26;i++){
                hMap.put(i+1,(char)('a'+ i));
            }
            while(DecodedString > 0){
                long lastDigit = DecodedString%10;
                if(lastDigit == 0){
                    DecodedString /= 10;
                    long digits = DecodedString%10;
                    DecodedString /= 10;
                    if(DecodedString%10 == 1){
                        digits += 10;
                    }else
                        digits += 20;
                    stack.push(hMap.get(digits));
                }else{
                    stack.push(hMap.get(lastDigit));
                }
                DecodedString /= 10;
            }
            while (!stack.isEmpty()){
                res.append(stack.pop());
            }
            System.out.println(res);
        }
    }
}
