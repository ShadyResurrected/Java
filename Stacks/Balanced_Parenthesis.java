package com.company.Stacks;

import java.util.HashMap;
import java.util.Stack;

public class Balanced_Parenthesis {
    public static void main(String[] args) {
        String s = "{[]}";
        Stack<Character> stack = new Stack<>();
        int count = 0;
        if(s.length()%2 != 0){
            System.out.println(false);
        }
        HashMap<Character,Character> hMap = new HashMap<>();
        hMap.put(')','(');
        hMap.put('}','{');
        hMap.put(']','[');
        for(int i = 0;i < s.length();i++){
            char cur = s.charAt(i);
            if(cur == ')' || cur == '}' || cur == ']'){
                if(!stack.isEmpty()){
                    char ch = stack.peek();
                    if(hMap.get(cur).equals(ch)){
                        stack.pop();
                        count++;
                    }else {
                        System.out.println(false);
                        break;
                    }
                }
            }else
                stack.push(cur);
        }
        if(s.length()/2 == count) System.out.println(true);;
        System.out.println(false);
    }
}
