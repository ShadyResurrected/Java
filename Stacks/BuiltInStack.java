package com.company.Stacks;

import java.util.Stack;

public class BuiltInStack {
    public static void main(String[] args) {
        //LIFO structure
        Stack<Integer> stack = new Stack<>();
        stack.push(34);
        stack.push(45);
        stack.push(8);
        stack.push(32);
        stack.push(12);

        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
    }
}
