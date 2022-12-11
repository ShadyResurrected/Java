package com.company.Miscellaneous;
//https://leetcode.com/problems/search-in-rotated-sorted-array/submissions/
public class RotatedBinarySearch {
    public static void main(String[] args) {
        int[] arr ={4,5,6,7,0,1,2};
        int target = 0;
        int pivot = PivotFind(arr);
        int FirstSearch = Search(arr,target,0,pivot);
        int SecondSearch = Search(arr,target,pivot+1,arr.length-1);
        if(FirstSearch != -1){
            System.out.println(FirstSearch);
        } else{
            System.out.println(SecondSearch);
        }
    }

    public int search(int[] arr, int target) {
        int pivot = PivotFind(arr);
        if(pivot == -1){
            return Search(arr,target,0,arr.length-1);
        }
        if(arr[pivot] == target){
            return pivot;
        }
        if(target >= arr[0]){
            return Search(arr,target,0,pivot-1);
        }
        return Search(arr,target,pivot+1,arr.length-1);
    }

    static int PivotFind(int[] arr){
        int start = 0;
        int end = arr.length - 1;
        while(start <= end){
            int mid = start + (end-start)/2;
            if(mid < end && arr[mid] > arr[mid+1]){
                return mid;
            }
            if(arr[mid] < arr[mid-1]){
                return mid-1;
            }
            if(arr[start] >= arr[mid]){
                end = mid - 1;
            }
            if(arr[start] < arr[mid]){
                start = mid + 1;
            }
        }
        return -1;
    }

    static int Search(int[] arr,int target,int start,int end){
        while(start <= end){
            int mid = start + (end-start)/2;
            if(arr[mid] > target){
                end = mid - 1;
            } else if(arr[mid] < target){
                start = mid + 1;
            } else{
                return mid;
            }
        }
        return -1;
    }

    static int DuplicateValuesPivotFind(int[] arr){
        int start = 0;
        int end = arr.length - 1;
        while(start <= end){
            int mid = start + (end-start)/2;
            if(mid < end && arr[mid] > arr[mid+1]){
                return mid;
            }
            if(arr[mid] < arr[mid-1]) {
                return mid - 1;
            }
            // if elements at the start,end and middle are duplicates
            if(arr[mid] == arr[end] && arr[mid] == arr[start]){
                //skip the duplicates
                // but what if that these duplicates are pivot
                if(arr[start] > arr[start+1]){
                    return start;
                }
                start++;

                if(arr[end] < arr[end-1]){
                    return end-1;
                }
                end--;
            }
            //left side is sorted, so pivot should be in right
            else if(arr[start] < arr[mid] || (arr[start] == arr[mid] && arr[mid] > arr[end])){
                start = mid + 1;
            } else{
                end = mid - 1;
            }
        }
        return -1;
    }
}
