package com.company.LinkedList.Questions;

public class Node {
    int val;
    Node next;

    private Node head;
    private Node tail;

    public Node(){

    }
    public Node(int val){
        this.val = val;
    }
    Node(int val, Node next)
    {
        this.val = val;
        this.next = next;
    }

    public void insertFirst(int val){
        Node Node = new Node(val);
        Node.next = head;
        head = Node;
        if(tail == null){
            tail = head;
        }
    }
    public void insertLast(int val){
        if(head == null){
            insertFirst(val);
            return;
        }
        Node Node = new Node(val);
        com.company.LinkedList.Questions.Node temp = head;
        while(temp.next != null){
            temp = temp.next;
        }
        temp.next = Node;
        temp = Node;
    }

    public static Node merge(Node list1, Node list2){
        Node temp1 = list1.head;
        Node temp2 = list2.head;

        Node ans = new Node();

        while(temp1 != null && temp2 != null){
            if(temp1.val < temp2.val){
                ans.insertLast(temp1.val);
                temp1 = temp1.next;
            }else{
                ans.insertLast(temp2.val);
                temp2 = temp2.next;
            }
        }
        while(temp1 != null){
            ans.insertLast(temp1.val);
            temp1 = temp1.next;
        }
        while(temp2 != null){
            ans.insertLast(temp2.val);
            temp2 = temp2.next;
        }
        return ans;
    }

    //=============================== Finding the middle of the linked list =====================
    public static Node getMid(Node head){
        Node fast = head;
        Node slow = head;
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
    //=============================== Sort a LinkedList ==================================
    public Node sortList(Node head) {
        if(head == null || head.next == null){
            return head;
        }

        Node mid = getMid(head);
        Node left = sortList(head);
        Node right = sortList(mid);

        return merge(left,right);
    }
    //=============================== Reverse a linked list iteratively ==================================
    public Node reverseList(Node head) {
        if(head == null){
            return head;
        }
        Node prev = null;
        Node present = head;
        Node next = present.next;
        while(present != null){
            present.next = prev;
            prev = present;
            present = next;
            if(next != null){
                next = next.next;
            }
        }
        head = prev;
        return head;
    }
    // Q9 =============================== Reverse a linked list 2 ==================================
    public Node reverseBetween(Node head, int left, int right) {
        if(left == right){
            return head;
        }
        // skip the first left-1 nodes
        Node current = head;
        Node prev = null;
        for (int i = 0 ; current != null && i < left-1 ; i++){
            prev = current;
            current = current.next;
        }

        Node last = prev;
        Node newEnd = current;

        //reverse between left and right

        Node next = current.next;
        for(int i = 0 ; current != null && i < right-left+1 ; i++){
            current.next = prev;
            prev = current;
            current = next;
            if(next != null){
                next = next.next;
            }
        }

        if(last != null){
            last.next = prev;
        }else {
            head = prev;
        }
        newEnd.next = current;
        return head;
    }
    // Q10 =============================== Palindrome LinkedList =====================
    public boolean isPalindrome(Node head) {
        Node mid = getMid(head);
        Node headSecond = reverseList(mid);
        Node reverseHead = headSecond;

        //compare both the halves
        while(head != null && headSecond != null){
            if(head.val != headSecond.val){
                break;
            }
            head = head.next;
            headSecond = headSecond.next;
        }
        reverseList(reverseHead);

        return head == null || headSecond == null ;
    }
    // Q11 =============================== Reorder LinkedList =====================
    public void reorderList(Node head) {
        if(head == null || head.next == null){
            return;
        }

        Node mid = getMid(head);
        Node hs = reverseList(mid);
        Node hf = head;

        //reorder
        while(hf != null && hs != null){
            Node temp = hf.next;
            hf.next = hs;
            hf = temp;

            temp = hs.next;
            hs.next = hf;
            hs = temp;
        }

        // next of tail to null
        if(hf != null){
            hf.next = null;
        }
    }
}
