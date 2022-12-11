package com.company.Miscellaneous;

import java.util.Arrays;

public class Merge_Sort {
    public static void main(String[] args) {
        int[] arr = {8,3,4,12,5,6};
//        arr = mergeSort(arr);
//        System.out.println(Arrays.toString(arr));
        mergeSortInPlace(arr,0,arr.length);
        System.out.println(Arrays.toString(arr));
    }
//    New objects are created everytime
    static int[] mergeSort(int[] arr){
        if(arr.length == 1){
            return arr;
        }

        int mid = arr.length/2;

        int[] left = mergeSort(Arrays.copyOfRange(arr,0,mid));
        int[] right = mergeSort(Arrays.copyOfRange(arr,mid,arr.length));

        return merge(left,right);
    }

    static int[] merge(int[] first, int[] second){
        int[] mix = new int[first.length + second.length];
        int i = 0;
        int k = 0;
        int j = 0;
        while(i < first.length && j < second.length){
            if(first[i] < second[j]){
                mix[k] = first[i];
                i++;
            }else{
                mix[k] = second[j];
                j++;
            }
            k++;
        }

        //Now if one of the array has some elements remaining
        while(i < first.length){
            mix[k] = first[i];
            i++;
            k++;
        }
        while(j < second.length){
            mix[k] = second[j];
            j++;
            k++;
        }

        return mix;
    }


    static void mergeSortInPlace(int[] arr,int start,int end){
        if(end - start == 1){
            return; // When only one element is present in the array
        }
        int mid = (start + end)/2;

        mergeSortInPlace(arr,start,mid);
        mergeSortInPlace(arr,mid,end);

        mergeInPlace(arr, mid ,start, end);
    }
    static void mergeInPlace(int[] arr,int mid,int start,int end){
        int[] mix = new int[end-start]; // end-start gives us the length of the array
        int i = start;
        int j = mid;
        int k = 0;
        while(i < mid && j < end){
            if(arr[i] < arr[j]){
                mix[k] = arr[i];
                i++;
            }else{
                mix[k] = arr[j];
                j++;
            }
            k++;
        }
        //Now if one of the array has some elements remaining
        while(i < mid){
            mix[k] = arr[i];
            i++;
            k++;
        }
        while(j < end){
            mix[k] = arr[j];
            j++;
            k++;
        }

        for (int l = 0; l < mix.length; l++) {
            arr[start+l] = mix[l];
        }

    }
}
