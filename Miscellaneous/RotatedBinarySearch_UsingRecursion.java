package com.company.Miscellaneous;

public class RotatedBinarySearch_UsingRecursion {
    public static void main(String[] args) {
        int[] arr = {5,6,7,8,9,1,2,3};
        int target = 7;
        System.out.println(search(arr,0,arr.length-1,target));
    }

    static int search(int[] arr, int start,int end,int target){
        if(start > end){
            return -1;
        }
        int mid = start + (end-start)/2;
        if(target == arr[mid]){
            return mid;
        }
//        Below condition shows that array in first half is sorted
        if(arr[start] <= arr[mid]){
            if(target >= arr[start] && target <= arr[mid]){
                return search(arr,start,mid-1,target);
            }else
                return search(arr,mid+1,end,target);
        }

//        Case 2
        if(target >= arr[mid] && target <=arr[end]){
            return search(arr,mid+1,end,target);
        }else
            return search(arr,start,mid-1,target);
    }
}
