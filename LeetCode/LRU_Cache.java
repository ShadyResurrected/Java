package com.company.LeetCode;

import java.util.HashMap;

class Node {
    int key;
    int val;
    Node previous;
    Node next;
    public Node(int key,int val){
        this.key = key;
        this.val = val;
    }
}

public class LRU_Cache {
    public static void main(String[] args) {
        int capacity = 3;
        HashMap<Integer, Node> hMap = new HashMap<>();
        Node head = new Node(0,0);
        Node tail = new Node(0,0);
        head.next = tail;
        tail.previous = head;
        put(1,10,hMap,head,tail,capacity);
        put(3,15,hMap,head,tail,capacity);
        System.out.println(get(3,hMap,head));
    }

    private static int get(int key,HashMap<Integer,Node> hMap,Node head) {
        if(!hMap.containsKey(key)) return -1;
        else {
            Node node = hMap.get(key);
            remove(node,hMap);
            insert(node,hMap,head);
            return node.val;
        }
    }

    private static void insert(Node node, HashMap<Integer, Node> hMap,Node head) {
        hMap.put(node.key,node);
        Node headNext = head.next;
        head.next = node;
        node.next.previous = head;
        headNext.previous = node;
        node.next = headNext;
    }

    private static void remove(Node node,HashMap<Integer,Node> hMap) {
        hMap.remove(node.key);
        node.previous.next = node.next.next;
        node.next.previous = node.previous;
    }

    private static void put(int key, int value, HashMap<Integer, Node> hMap, Node head,Node tail,int capacity) {
        if(hMap.containsKey(key)) remove(hMap.get(key),hMap);
        if(hMap.size() == capacity) remove(tail.previous,hMap); // removing the least recently used element
        insert(new Node(key,value),hMap,head);
    }
}
