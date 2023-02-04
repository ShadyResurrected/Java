package com.company.LinkedList;

public class CircularLinkList {

    private Node head;
    private Node tail;

    public CircularLinkList(){
        this.head = null;
        this.tail = null;
    }

    // =========================================== Insert Last ========================================== //
    public void insertLast(int val){
        Node node = new Node(val);
        if(head == null){
            head = node;
            tail = node;
            return;
        }
        tail.next = node;
        node.next = head;
        tail = node;

    }

    // =========================================== Display List ========================================== //
    public void display(){
        Node node = head;
        if(head != null){
            // Since do while loop executes once so it will change the position of node in starting
            do{
                System.out.print(node.value + " --> ");
                node = node.next;
            } while (node != head);

            System.out.println("HEAD");
        }
    }

    // =========================================== Deletion ========================================== //
    public void delete(int val){
        Node node = head;
        if(node == null){
            return;
        }
        // If the current node is the one to delete
        if(node.value == val){
            head = head.next;
            tail.next = head;
            return;
        }

        // Having a new Node n pointing to the next of node
        do{
            Node n = node.next;
            if(n.value == val){
                node.next = n.next;
                break;
            }
            node = node.next;
        } while (node != head);
    }

    private class Node {
        int value;
        Node next;

        public Node(int val){
            this.value = val;
        }
    }
}
