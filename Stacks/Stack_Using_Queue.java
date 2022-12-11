package com.company.Stacks;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Stack_Using_Queue {
    private int size = -1;
    Queue<Integer> Q1 = new LinkedList<>();
    Queue<Integer> Q2 = new LinkedList<>();

    public Stack_Using_Queue(){
        this.size = 0;
    }
    public Stack_Using_Queue(int size){
        this.size = size;
    }

    public void push(int x){
        Q2.offer(x);
        while(!Q1.isEmpty()){
            Q2.offer(Q1.poll());
        }
        while(!Q2.isEmpty()){
            Q1.offer(Q2.poll());
        }
    }

    public void Display(){
        while(!Q1.isEmpty()){
            System.out.print(Q1.poll() + " ");
        }
        System.out.println();
    }
}
