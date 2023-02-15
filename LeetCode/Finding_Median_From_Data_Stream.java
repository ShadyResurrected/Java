package com.company.LeetCode;

import java.util.*;

class MedianFinder {
    PriorityQueue<Integer> max_Heap;
    PriorityQueue<Integer> min_Heap;
    public MedianFinder() {
        max_Heap = new PriorityQueue<Integer>(Collections.reverseOrder());
        min_Heap = new PriorityQueue<Integer>();
    }

    public void addNum(int num) {
        int n = max_Heap.size();
        int m = min_Heap.size();

        if(n == 0 && m == 0) max_Heap.offer(num);
        else if(n - m == 1){
            if(num > max_Heap.peek()) min_Heap.offer(num);
            else{
                int mid = max_Heap.poll();
                min_Heap.offer(mid);
                max_Heap.offer(num);
            }
        }else{
            if(num > min_Heap.peek()){
                int mid = min_Heap.poll();
                max_Heap.offer(mid);
                min_Heap.offer(num);
            }else max_Heap.offer(num);
        }

    }

    public double findMedian() {
        int size = max_Heap.size() + min_Heap.size();

        if(size % 2 != 0) return max_Heap.peek() / 1.0;

        return (max_Heap.peek() + min_Heap.peek())/ 2.0;
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */

public class Finding_Median_From_Data_Stream {
    public static void main(String[] args) {

    }
}
