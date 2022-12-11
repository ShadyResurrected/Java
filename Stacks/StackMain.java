package com.company.Stacks;

public class StackMain {
    public static void main(String[] args) throws Exception {
//        CustomStack stack = new CustomStack(5);

//        stack.push(32);
//        stack.push(38);
//        stack.push(98);
//        stack.push(90);
//        stack.push(76);

//        System.out.println(stack.pop());
//        System.out.println(stack.pop());

        Stack_Using_Queue stack = new Stack_Using_Queue(5);
        stack.push(3);
        stack.push(4);
        stack.push(2);
        stack.push(1);
        stack.Display();
    }
}
