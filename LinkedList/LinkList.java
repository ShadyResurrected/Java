package com.company.LinkedList;

public class LinkList {

    private Node head;
    private Node tail;
    private int size;
    public LinkList(){
        this.size = 0;
    }

    // =========================================== Insert first ========================================== //
    public void InsertFirst(int val){
        Node node = new Node(val);
        node.next = head;
        head = node;

        //Check whether this is the first element that is inserted in the list
        if(tail == null){
            tail = head;
        }
        // This increment shows that new node is added and size increases
        size += 1;
    }

    // =========================================== Insert last ========================================== //
    public void InsertLast(int val){
        // If the list is empty
        if(tail == null){
            InsertFirst(val);
        }
        Node node = new Node(val); // Creating a node
        tail.next = node;
        tail = node;
        size++;
    }

    // =========================================== Insert at specific position ========================================== //
    public void InsertAt(int val,int index){
        if(index == 0){
            InsertFirst(val);
            return;
        }
        if(index == size){
            InsertLast(val);
            return;
        }
        Node temp = head;
        //We are starting from 1 because 0 is contained in head
        //We should reach the node behind the targeted node
        for(int i = 1; i < index; i++){
            temp = temp.next;
        }
    }


    // =========================================== Delete first ========================================== //
    public int DeleteFirst(){
        int val = head.value;
        head = head.next;
        if(head == null){
            tail = null;
        }
        size--;
        return val;
    }

    // =========================================== Delete last ========================================== //

    public int DeleteLast(){
        // If only one element is present in the list
        if(size <= 1){
            return DeleteFirst();
        }
        // We are taking size-2 because we started the loop from 0
        Node secondLast  = get(size-2);
        int val = tail.value;
        tail = secondLast;
        tail.next = null;
        return val;

    }


    // This function below will return reference variable that points to the second last node
    public Node get(int index){
        Node node = head;
        for(int i = 0; i < index ; i++){
            node = node.next;
        }
        return node;
    }

    // =========================================== Delete at specified index ========================================== //

    public int DeleteAt(int index){
        if(index == 0){
            return DeleteFirst();
        }
        if(index == size-1){
            return DeleteLast();
        }
        Node prev = get(index-1);
        int val = prev.next.value;
        // Now breaking the chain and pointing the node to next one
        prev.next = prev.next.next;
        return val;
    }

    // =========================================== Searching for the element ========================================== //
    public boolean Find(int value){
        Node node = head;
        while(node != null){
            if(node.value == value){
                return true;
            }
            node = node.next;
        }
        return false;
    }

    // =========================================== Display the list ========================================== //
    public void display(){
        Node temp = head; // Taking a temporary node so that the value of head doesn't change
        while(temp != null){
            System.out.print(temp.value + " --> ");
            temp = temp.next; // Moving to the next node
        }
        System.out.println("END");
    }

    // =========================================== Defining the structure of the node ========================================== //
    private class Node{
        private int value;
        private Node next;

        public Node(int value){
            this.value = value;
        }
        public Node(int value,Node next){
            this.value = value;
            this.next = next;
        }
    }
}
