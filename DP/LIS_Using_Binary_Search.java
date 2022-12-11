package com.company.DP;

import java.util.ArrayList;

public class LIS_Using_Binary_Search {
    public static void main(String[] args) {
        int[] arr = {1,7,8,4,5,6,-1,9};
        ArrayList<Integer> temp = new ArrayList<>();
        temp.add(arr[0]);

        for(int i = 1;i < arr.length;i++){
            if(arr[i] > temp.get(temp.size()-1)) temp.add(arr[i]);
            else{
                int index = lowerBound(temp,arr[i]);
                temp.set(index,arr[i]);
            }
        }

        System.out.println(temp.size());
    }

    private static int lowerBound(ArrayList<Integer> temp, int target) {
        int start = 0;
        int end = temp.size()-1;
        while(start <= end){
            int mid = start + (end-start)/2;
            if(temp.get(mid) > target) end = mid - 1;
            else if(temp.get(mid) < target) start = mid+1;
            else return mid;
        }
        return start;
    }
}
