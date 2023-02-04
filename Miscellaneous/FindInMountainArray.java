package com.company.Miscellaneous;

public class FindInMountainArray {
    public static int main(String[] args) {
        int[] arr={1,2,3,4,5,6,3,2};
        int target = 3;
        int peak = peakIndexInMountainArray(arr);
        int result1 = OrderAgnostic(arr,target,0,peak);
        if(result1 != -1){
            return result1;
        } else{
            return OrderAgnostic(arr,target,peak+1,arr.length-1);
        }

    }

    static int peakIndexInMountainArray(int[] arr) {
        int start = 0;
        int end = arr.length - 1;
        while(start < end){
            int mid = start + (end-start)/2;
            if(arr[mid] > arr[mid+1]){
                //Decreasing part of the array
                //this may be the ans, but look at left
                end = mid;
            } else if(arr[mid] < arr[mid+1]){
                //Increasing part of the array
                start = mid + 1;
            }
        }
        // Since start and end are always pointing to the best possible answer thus we return start or end.
        return start;
    }

    static int OrderAgnostic(int[] arr,int num,int start,int end){
        if(arr[start] > arr[end]){
            int resultD = SearchD(arr,num,start,end);
            return resultD;
        } else if(arr[start] < arr[end]){
            int resultA = SearchA(arr,num,start,end);
            return resultA;
        }
        return -1;
    }
    static int SearchA(int[] arr, int num,int start,int end){
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

    static int SearchD(int[] arr, int num,int start,int end){
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
}
