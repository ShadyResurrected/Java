package com.company.LinkedList.Questions;

public class Main {
    public static void main(String[] args) {
        LL list = new LL();
//        list.insertFirst(21);
//        list.insertFirst(21);
//        list.insertFirst(23);
//        list.insertFirst(25);
//        list.insertFirst(25);
//        list.insertFirst(25);
//        list.insertFirst(27);
//        list.insertFirst(34);
//        list.insertFirst(54);
//        list.insertLast(99);
//        list.InsertRec(90,3);
//        list.Display();
//        list.removeDuplicates();

        LL first = new LL();
        LL second = new LL();

        first.insertLast(2);
        first.insertLast(3);
        first.insertLast(7);

        second.insertLast(6);
        second.insertLast(8);
        second.insertLast(9);
        second.insertLast(14);

        LL ans = LL.merge(first,second);

        ans.Display();
    }
}
