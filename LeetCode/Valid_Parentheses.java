package com.company.LeetCode;

import java.util.Stack;

// Incomplete
public class Valid_Parentheses {
    public static void main(String[] args) {
        String s = "()[]{}[}";
        boolean res = isValid(s);
        System.out.println(res);
    }

    static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        int count = 0;
        boolean res = true;
        for (int i = 0; i < s.length(); i++){
            if(s.charAt(i) == '(' || s.charAt(i) == '[' || s.charAt(i) == '{'){
                stack.push(s.charAt(i));
            }
            if (s.charAt(i) == ')' || s.charAt(i) == ']' || s.charAt(i) == '}'){

            }
        }
        return res;
    }
}
