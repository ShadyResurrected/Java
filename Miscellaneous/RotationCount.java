package com.company.Miscellaneous;

public class RotationCount {
    public static void main(String[] args){
        int[] arr ={4,5,6,7,0,1,2};
        int Pivot = FindPivot(arr);
        if(Pivot == -1){
            System.out.println(0);
        } else{
            int result = Pivot + 1;
            System.out.println(result);
        }

    }

    static int FindPivot(int[] arr){
        int start = 0;
        int end = arr.length - 1;
        while(start <= end){
            int mid = start + (end-start)/2;
            if(mid < end && arr[mid] > arr[mid+1]){
                return mid;
            }
            if(mid > start && arr[mid] < arr[mid-1]){
                return mid-1;
            }
            if(arr[start] > arr[mid]){
                end = mid - 1;
            } else if(arr[start] < arr[mid]){
                start = mid + 1;
            }
        }

        return -1;

    }
}
