package com.company.LeetCode;

import java.util.Objects;
import java.util.Stack;

public class Evaluate_Reverse_Polish_Notation {
    public static void main(String[] args) {
        String[] tokens = {"2","1","+","3","*"};
        int res = evalRPN(tokens);
        System.out.println(res);
    }

    static int evalRPN(String[] tokens) {
        Stack<String> stack = new Stack<>();

        for(int i = 0;i < tokens.length; i++){
            String str = tokens[i];
            if(!Objects.equals(str, "+") && !Objects.equals(str, "-") && !Objects.equals(str, "*") && !Objects.equals(str, "/")){
                stack.push(str);
            }else{
                int num1 = Integer.parseInt(stack.pop());
                int num2 = Integer.parseInt(stack.pop());

                // Calculating the result
                if(Objects.equals(str, "+")) stack.push(Integer.toString(num1+num2));
                else if(Objects.equals(str, "-")) stack.push(Integer.toString(num1-num2));
                else if(Objects.equals(str, "*")) stack.push(Integer.toString(num1*num2));
                else if(Objects.equals(str, "/")) stack.push(Integer.toString(num1/num2));
            }
        }

        return Integer.parseInt(stack.pop());
    }
}
