package com.company.Heap;

import java.util.*;

public class Kth_largest_element {
    public static void main(String[] args) {
        int[] nums = {1,3,2,4,8,5};
        int k = 2;
        System.out.println(findKthLargest(nums,k));
    }

    public static int findKthLargest(int[] nums, int k) {
        return HelperFunc(nums,k);
    }

    static int HelperFunc(int[] arr,int k){
        int left = 0, right = arr.length - 1, kth;
        while (true) {
            int idx = partition(left, right, arr);
            if (idx == k - 1) {
                kth = arr[idx];
                break;
            }
            if (idx < k - 1) {
                left = idx + 1;
            } else {
                right = idx - 1;
            }
        }
        return kth;
    }

    static int partition(int left,int right,int[] arr){
        int pivot = arr[left] ;
        int l = left + 1 ;
        int r = right;
        while (l <= r) {
            if (arr[l] < pivot && arr[r] > pivot) {
                int temp=arr[l];
                arr[l]=arr[r];
                arr[r]=temp;
                l++ ;
                r-- ;
            }
            if (arr[l] >= pivot) {
                l++;
            }
            if (arr[r] <= pivot) {
                r--;
            }
        }
        int temp2=arr[left];
        arr[left]=arr[r];
        arr[r]=temp2;
        return r;
    }
}
