package com.company.Heap;

import java.util.*;

public class Last_Stone_Weight {
    public static void main(String[] args) {
        int[] stones = {2,7,4,1,8,1};
        System.out.println(lastStoneWeight(stones));
    }

    public static int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>(Collections.reverseOrder());

        for(int ele : stones) pq.offer(ele);

        int x,y;

        while(pq.size() > 1){
            y = pq.poll();
            x = pq.poll();

            if(y >= x){
                pq.offer(y-x);
            }
        }

        return pq.size() == 1 ? pq.poll() : 0;
    }
}
