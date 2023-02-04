package com.company.Stacks;

import java.util.LinkedList;
import java.util.Queue;

public class BuiltInQueue {
    public static void main(String[] args) {
        //FIFO structure
        Queue<Integer> queue = new LinkedList<>();
        queue.add(33);
        queue.add(31);
        queue.add(54);
        queue.add(32);

        System.out.println(queue.remove());
        System.out.println(queue.remove());
    }
}
