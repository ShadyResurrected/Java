package com.company.Stacks;

import java.util.Stack;

public class Stock_Span_Problem {
    public static void main(String[] args) {
        int[] Prices = {100,80,60,70,60,75,85};
        int[] span = new int[Prices.length];
        span[0] = 1; // This is the only possible answer for index 0
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        for(int i = 1;i < Prices.length;i++){
            while(!stack.isEmpty() && Prices[stack.peek()] <= Prices[i]){
                stack.pop();
            }
            if(stack.isEmpty()) span[i] = i + 1;
            else span[i] = i - stack.peek();

            stack.push(i);
        }
    }
}
