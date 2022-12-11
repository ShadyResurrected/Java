package com.company.OOPS_concepts.Generics;

import com.company.Stacks.CustomQueue;

import java.util.ArrayList;

public class CustomArrayList {

    private int[] data;
    private static int DEFAULT_SIZE = 10;
    private int size = 0; // it is working as an index value

    public CustomArrayList() {
        this.data = new int[DEFAULT_SIZE];
    }

    public void add(int num){
        if(isFull()){
            resize();
        }
        data[size++] = num;
    }

    public void resize() {
        int[] temp = new int[DEFAULT_SIZE * 2];

        // copy the elements from the previous arrayList
        for (int i = 0; i < data.length ; i++){
            temp[i] = data[i];
        }

        // Now the new array is temp
        data = temp;
        // When this function is over temp will go out of scope because its scope is limited to inside this function
    }

    public int remove(){
        int removed = data[--size];
        return removed;
    }

    public int get(int index){
        return data[index];
    }

    public int size(){
        return size;
    }

    public void set(int index, int value){
        data[index] = value;
    }

    public boolean isFull() {
        return size == data.length;
    }

    public static void main(String[] args) {
        ArrayList list = new ArrayList();
        CustomArrayList list1 = new CustomArrayList();
    }
}
