package com.company.LinkedList.Questions;

import com.company.LinkedList.LinkList;

public class LL {
    private Node head;
    private Node tail;
    private int size;
    public LL(){
        this.size = 0;
    }


    // =========================================== Insert first ========================================== //
    public void insertFirst(int val){
        Node node = new Node(val);
        node.next = head;
        head = node;
        if(tail == null){
            tail = head;
        }
        size++;
    }

    // =========================================== Insert Last ========================================== //
    public void insertLast(int val){
        // If the list is empty
        if(tail == null){
            insertFirst(val);
            return;
        }
        Node node = new Node(val); // Creating a node
        tail.next = node;
        tail = node;
        size++;
    }

    // =========================================== Display ========================================== //
    public void Display(){
        Node temp = head; // Taking a temporary node so that the value of head doesn't change
        while(temp != null){
            System.out.print(temp.value + " --> ");
            temp = temp.next; // Moving to the next node
        }
        System.out.println("END");
    }

    // ======================= Q1 Insert Using Recursion =============================== //
    public void InsertRec(int val,int index){
        head = InsertRec(val,index,head);
    }

    private Node InsertRec(int val,int index ,Node node){
        // Base Condition
        if(index == 0){
            Node temp = new Node(val,node);
            size++;
            return temp;
        }

        node.next = InsertRec(val,index-1,node.next);
        return node;
    }

    // ======================= Q2 Removing Duplicates =============================== //
    public void removeDuplicates(){
        Node node = head;

        while(node.next != null){
            if(node.value == node.next.value){
                node.next = node.next.next;
                size--;
            }else{
                node = node.next;
            }
        }

        tail = node;
        tail.next = null;
    }

    // =========================================== Q3 Merge Two Sorted Lists ========================================== //
    public static LL merge(LL list1,LL list2){
        Node temp1 = list1.head;
        Node temp2 = list2.head;

        LL ans = new LL();

        while(temp1 != null && temp2 != null){
            if(temp1.value < temp2.value){
                ans.insertLast(temp1.value);
                temp1 = temp1.next;
            }else{
                ans.insertLast(temp2.value);
                temp2 = temp2.next;
            }
        }

        while(temp1 != null){
            ans.insertLast(temp1.value);
            temp1 = temp1.next;
        }
        while(temp2 != null){
            ans.insertLast(temp2.value);
            temp2 = temp2.next;
        }

        return ans;
    }

    // Q4 =============================== Find Linked List Cycle ==================================
    public static boolean LLCycle(Node head){
        Node fast = head;
        Node slow = head;
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
            if(fast == slow){
                return true;
            }
        }
        return false;
    }
    // Q5 =============================== Length of Cycle in Linked List Cycle ==================================
    public static int CycleLength(Node head){
        Node fast = head;
        Node slow = head;
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
            if(fast == slow){
                //calculate the length using counter
                Node temp = slow;
                int length = 0;
                do{
                    temp = temp.next;
                    length++;
                } while (temp != slow);
                return length;
            }
        }
        return 0;
    }

    // Q6 =============================== Linked List Cycle II ==================================
    public Node detectCycleII(Node head){
        int length = 0;

        Node fast = head;
        Node slow = head;

        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
            if(fast == slow){
                Node temp = slow;
                do{
                    temp = temp.next;
                    length++;
                } while(temp != slow);
                break;
            }
        }
        // if no cycle is found
        if(length == 0){
            return null;
        }

        //find the start node
        Node f = head;
        Node s = head;

        //move ahead the second pointer length of number of times
        while(length > 0){
            s = s.next;
            length--;
        }

        //keep moving both forward and they both will meet at cycle start
        while(f != s){
            f = f.next;
            s = s.next;
        }

        // At the end return any of the two pointers
        return s;
    }


    // Q7 =============================== Happy Number ==================================
    public boolean isHappy(int n) {
        int fast = n;
        int slow = n;

        do{
            slow = findSquare(slow);
            fast = findSquare(findSquare(fast)); // moving twice the speed of slow pointer
        } while (slow != fast);

        if(slow == 1){
            return true;
        }else
            return false;
    }

    private int findSquare(int number){
        int ans = 0;
        while(number > 0){
            int rem = number % 10;
            ans += rem * rem;
            number /= 10;
        }
        return ans;
    }

    // Q8 =============================== Recursion Reverse ==================================
    private void reverse(Node node){
        if(node == tail){
            tail = head;
            return;
        }
        reverse(node.next);
        tail.next = node;
        tail = node;
        tail.next = null;

    }

    private class Node {
        int value;
        Node next;

        public Node(int val){
            this.value = val;
        }
        public Node(int val,Node next){
            this.value = val;
            this.next = next;
        }
    }
}
