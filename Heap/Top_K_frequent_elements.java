package com.company.Heap;

import java.util.*;

class Node{
    int ele;
    int frequency;
    public Node(int ele,int frequency){
        this.ele = ele;
        this.frequency = frequency;
    }
}

class NodeComparator implements Comparator<Node>{
    public int compare(Node obj1,Node obj2){
        if(obj1.frequency < obj2.frequency) return 1;
        else if (obj1.frequency > obj2.frequency) return -1;
        return 0;
    }
}


public class Top_K_frequent_elements {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer> hMap = new HashMap<>();

        for(int ele : nums){
            if(hMap.containsKey(ele)){
                int count = hMap.get(ele);
                hMap.put(ele,count+1);
            }else hMap.put(ele,1);
        }

        PriorityQueue<Node> pq = new PriorityQueue<>(new NodeComparator());

        for (Map.Entry<Integer,Integer> mapElement : hMap.entrySet()) {
            int key = mapElement.getKey();
            int value = mapElement.getValue();

            pq.offer(new Node(key,value));
        }

        int size = k;
        int[] arr = new int[size];

        for(int i = 0;i < size; i++){
            arr[i] = pq.poll().ele;
        }

        return arr;
    }
}
