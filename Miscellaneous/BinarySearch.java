package com.company.Miscellaneous;

public class BinarySearch {
    public static void main(String[] args){
        int[] arr = {7,5,4,3,2,1};
        int num1 = 1;
        int result = OrderAgnostic(arr,num1);
        System.out.println(result);
    }

    static int SearchA(int[] arr, int num){
        int start = 0;
        int end = arr.length - 1;
        while(start <= end){
//            int mid = (start+end)/2;
            int mid = start + (end-start)/2;
            if(arr[mid] == num){
                return mid;
            }
            if(num < arr[mid]){
                end = mid - 1;
            }
            if(num > arr[mid]){
                start = mid + 1;
            }
        }
        return -1;
    }

    static int SearchD(int[] arr, int num){
        int start = 0;
        int end = arr.length - 1;
        while(start <= end){
//            int mid = (start+end)/2;
            int mid = start + (end-start)/2;
            if(arr[mid] == num){
                return mid;
            }
            if(num < arr[mid]){
                start = mid + 1;
            }
            if(num > arr[mid]){
                end = mid - 1;
            }
        }
        return -1;
    }

    static int OrderAgnostic(int[] arr,int num){
        int start = 0;
        int end = arr.length - 1;
        if(arr[start] > arr[end]){
            int resultD = SearchD(arr,num);
            return resultD;
        } else if(arr[start] < arr[end]){
            int resultA = SearchA(arr,num);
            return resultA;
        }
        return -1;
    }
}
