package com.company.LinkedList;

public class DoublyLinkList {

    private Node head; // By default this points to head

    // =========================================== Insert first ========================================== //
    public void InsertFirst(int val){
        Node node = new Node(val);
        node.next = head;
        node.prev = null;
//        Below condition to check for null pointer exception
        if(head != null){
            head.prev = node;
        }
        head = node;
    }

    // =========================================== Insert Last ========================================== //
    public void InsertLast(int val){
        Node node = new Node(val);
        Node last = head;

        // If the list is empty
        if(head == null){
            node.prev = null;
            head = node;
            return;
        }
        while(last.next != null){
            last = last.next;
        }
        last.next = node;
        node.prev = last;
        node.next = null;
    }

    // =========================================== Insert After an element ========================================== //
    public void InsertAfter(int after, int val){
        Node p = find(after);

        if(p == null){
            System.out.println("Does not exist");
            return;
        }

        Node node = new Node(val);
        node.next = p.next;
        p.next = node;
        node.prev = p;
        if(node.next.prev != null){
            node.next.prev = node;
        }
    }

    public Node find(int after){
        Node temp = head;
        while(temp != null){
            if(temp.value == after){
                return temp;
            }
            temp = temp.next;
        }
        return null;
    }
    // =========================================== Display ========================================== //
    public void display(){
        Node temp;
        temp = head;
        Node last = null;
        while(temp != null){
            System.out.print(temp.value + " --> ");
            last = temp; // At the end of the loop this will point to the last node
            temp = temp.next;
        }
        System.out.println("END");

        System.out.println("Printing in reverse pattern");
        while(last != null){
            System.out.print(last.value + "-->");
            last = last.prev;
        }
        System.out.println("END");
    }
    // =========================================== Defining the structure of the node ========================================== //
    private class Node{
        int value;
        Node next;
        Node prev;

        public Node(int val){
            this.value = val;
        }

        public Node(int val,Node next,Node prev){
            this.value = val;
            this.next = next;
            this.prev = prev;
        }
    }
}
