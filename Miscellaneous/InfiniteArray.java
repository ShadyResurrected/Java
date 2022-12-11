package com.company.Miscellaneous;
// https://www.geeksforgeeks.org/find-position-element-sorted-array-infinite-numbers/
public class InfiniteArray {
    public static void main(String[] args){
        int[] arr = new int[]{3, 5, 7, 9, 10, 90,
                100, 130, 140, 160, 170};
        int target = 10;
        int result = Infinite(arr,target);
        System.out.println(result);

    }
    static int Infinite(int[] arr, int target){
        int start = 0;
        int end = 1;
        // if the target element is greater than the element in end index than double the size of the chunk
        while(target > arr[end]){
            // new value of start
            int newStart = end + 1;
            // new value of the end
            // newend = end + (sizeofbox)*2
            end = end + (end - start + 1)*2;
            // updation of start value will take place here
            start = newStart;
        }

        return Search(arr,target,start,end);
    }
    static int Search(int[] arr, int target, int start, int end){
        while(start <= end){
            int mid = start + (end-start)/2;
            if(target < arr[mid]){
                end = mid - 1;
            }else if(target > arr[mid]){
                start = mid + 1;
            } else{
                return mid;
            }
        }
        return -1;
    }
}
