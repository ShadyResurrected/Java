package com.company.Miscellaneous;

import java.util.ArrayList;

public class LinearSearch_UsingRecursion {
    public static void main(String[] args) {
        int[] arr = {2,3,4,4,4,7,1};
        System.out.println(isFound(arr,1,0));
        System.out.println(findAll(arr,4,0,new ArrayList<>()));
        System.out.println(findAll2(arr,4,0));

    }

    static boolean isFound(int[] arr,int target,int index){
        if(index == arr.length){
            return false;
        }
        if(arr[index] == target){
            return true;
        }
        return isFound(arr,target,index+1);
    }
//    If list will be initialised inside the function then on every call new function will be created which leads to memory wastage
    static ArrayList<Integer> findAll(int[] arr, int target, int index, ArrayList<Integer> list){
        if(index == arr.length){
            return list;
        }
        if(arr[index] == target){
            list.add(index);
        }
        return findAll(arr,target,index+1,list);
    }

    static ArrayList<Integer> findAll2(int[] arr, int target, int index){
        ArrayList<Integer> list = new ArrayList<>();
        if(index == arr.length){
            return list;
        }
        if(arr[index] == target){
            list.add(index);
        }
        ArrayList<Integer> ansFromBelowCalls = findAll2(arr,target,index+1);

//        This method appends all of the elements in the specified collection to the end of this list
        list.addAll(ansFromBelowCalls);

        return list;
    }
}
