package com.company.LeetCode.Binary_Search;

public class Single_element_in_sorted_array {
    public static void main(String[] args) {
        int[] arr = {130, 200 ,200, 279, 279, 342, 342, 348, 348, 430, 430, 492, 492, 588, 588, 616, 616,
                708 ,708, 711, 711, 804, 804, 826, 826, 845, 845, 893 ,893, 965, 965, 1035 ,1035, 1103, 1103,
                1139, 1139, 1143, 1143, 1166, 1166 ,1240, 1240, 1282, 1282, 1336, 1336, 1384, 1384, 1447, 1447,
                1485, 1485, 1509, 1509, 1539 ,1539, 1556, 1556, 1647, 1647, 1736, 1736, 1777, 1777, 1842, 1842,
                1889, 1889, 1980, 1980, 2051, 2051, 2058, 2058, 2152, 2152, 2182, 2182, 2267 ,2267, 2324, 2324,
                2391, 2391, 2423, 2423, 2468, 2468, 2495, 2495
        };
        int start = 0;
        int end = arr.length - 2;
        while(start <= end){
            int mid = start + (end-start)/2;
            System.out.println(start);
            System.out.println(end);
            System.out.println(mid);
            // Checking for the left half of the array
            if(mid % 2 == 0){
                if(arr[mid] != arr[mid+1]){
                    end = mid - 1;
                }else
                    start = mid + 1;
            }else{   // Checking for the right half of the array
                if(arr[mid] != arr[mid+1]){
                    start = mid + 1;
                }else
                    end = mid - 1;
            }
        }
        System.out.println(arr[start]);
    }
}
