package com.company.Heap;

import java.util.*;

public class Nearly_Sorted {
    ArrayList <Integer> nearlySorted(int arr[], int num, int k)
    {
        // your code here
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for(int i = 0;i <= k; i++){
            pq.offer(arr[i]);
        }

        ArrayList<Integer> list = new ArrayList<>();

        int start = k + 1;
        while(start < num){
            list.add(pq.poll());

            pq.offer(arr[start]);
            start++;
        }

        while(!pq.isEmpty()){
            list.add(pq.poll());
        }

        return list;
    }
}
