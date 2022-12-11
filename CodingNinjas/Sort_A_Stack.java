package com.company.CodingNinjas;

import javax.print.attribute.IntegerSyntax;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.Stack;

public class Sort_A_Stack {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(5);
        stack.push(-2);
        stack.push(9);
        stack.push(-7);
        stack.push(3);
        int[] TopElement = new int[1];
        ReverseStack(stack);
        System.out.println(stack);
    }

    private static void ReverseStack(Stack<Integer> stack) {
        if(stack.size() > 0){
            int topElement = stack.peek();
            stack.pop();
            ReverseStack(stack);
            InsertCorrectPosition(topElement,stack);
        }
    }

    private static void InsertCorrectPosition(int topElement, Stack<Integer> stack) {
        if(stack.size() == 0 || stack.peek() < topElement){
            stack.push(topElement);
        }else{
            int newTop = stack.peek();
            stack.pop();
            InsertCorrectPosition(topElement,stack);
            stack.push(newTop);
        }
    }
}
