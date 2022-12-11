package com.company.OOPS_concepts.Generics;

import java.util.ArrayList;
//https://docs.oracle.com/javase/tutorial/java/generics/index.html

public class CustomGenArrayList<T> {

    // Object type is used because in the original implementation of ArrayList the same is used
    // Object class is the super class of every class i.e. inherited by all

    //Here T defines the type we are adding int the ArrayList
    private Object[] data;
    private static int DEFAULT_SIZE = 10;
    private int size = 0; // it is working as an index value

    public CustomGenArrayList() {
        this.data = new Object[DEFAULT_SIZE];
    }

    public void add(T num){
        if(isFull()){
            resize();
        }
        data[size++] = num;
    }

    public void resize() {
        Object[] temp = new Object[DEFAULT_SIZE * 2];

        // copy the elements from the previous arrayList
        for (int i = 0; i < data.length ; i++){
            temp[i] = data[i];
        }

        // Now the new array is temp
        data = temp;
        // When this function is over temp will go out of scope because its scope is limited to inside this function
    }

    public T remove(){
        T removed = (T)(data[--size]); // here a smaller type is being added in the bigger one, hence type casting is required
        return removed;
    }

    public T get(int index){
        return (T)data[index];
    }

    public int size(){
        return size;
    }

    public void set(int index, T value){
        data[index] = value;
    }

    public boolean isFull() {
        return size == data.length;
    }

    public static void main(String[] args) {
        ArrayList list = new ArrayList();
        CustomGenArrayList list1 = new CustomGenArrayList();
    }
}
