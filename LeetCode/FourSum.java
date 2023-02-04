package com.company.LeetCode;

import java.lang.reflect.Array;
import java.util.*;

public class FourSum {
    public static void main(String[] args) {
        int[] arr = {-249, 421 ,-451, -389 ,750 ,353, 633, 299, 640, 905 ,-113, -657 };
        int target = 1566;

        // Using three pointers and binary search
//        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
//        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
//        HashMap<ArrayList,Integer> hmap = new HashMap<>();
//        Arrays.sort(arr);
//
//        int row = 0;
//        for(int i = 0; i < arr.length-1; i++){
//            for(int j = i + 1; j < arr.length-1; j++){
//                for(int k = j + 1; k < arr.length; k++){
//                    int rem_Sum = target - (arr[i] + arr[j] + arr[k]);
//                    // Doing binary search in the right half of the array
//                    int low = k+1;
//                    int high = arr.length-1;
//                    while(low <= high){
//                        int mid = (low+high)/2;
//                        if(arr[mid] > rem_Sum){
//                            high = mid - 1;
//                        }else if(arr[mid] < rem_Sum){
//                            low = mid + 1;
//                        }else{
//                            list.add(new ArrayList<>());
//                            list.get(row).add(arr[i]);
//                            list.get(row).add(arr[j]);
//                            list.get(row).add(arr[k]);
//                            list.get(row).add(rem_Sum);
//                            row++;
//                            break;
//                        }
//                    }
//                }
//            }
//        }
//
//        for(int i = 0; i < list.size(); i++){
//            for(int j = 0; j < list.get(i).size(); j++){
//                System.out.print(list.get(i).get(j));
//            }
//            System.out.println();
//        }
//
//         Removing the duplicate values from the arrayList
//        for(int i = 0; i < list.size(); i++){
//            if(hmap.containsKey(list.get(i))){
//                continue;
//            }else
//                hmap.put(list.get(i),i);
//        }
//        Iterator<ArrayList> itr = hmap.keySet().iterator();
//        while (itr.hasNext()){
//            ArrayList<Integer> key = itr.next();
//            ans.add(key);
//        }
//
//        for(int i = 0; i < ans.size(); i++){
//            System.out.println(ans.get(i));
//        }

        // Optimized approach

        ArrayList<ArrayList<Integer>> list1 = new ArrayList<>();
        Arrays.sort(arr);
        int count = 0;
        for(int i = 0; i < arr.length-1; i++){
            for(int j = i + 1; j < arr.length-1; j++){
                // Using the two pointers
                int left = j + 1;
                int right = arr.length-1;
                int rem_sum = target - (arr[i] + arr[j]);
                while(left < right){
                    int total_rem = arr[left] + arr[right];
                    if(total_rem < rem_sum){
                        left++;
                    }else if(total_rem > rem_sum){
                        right--;
                    }else{
                        list1.add(new ArrayList<>());
                        list1.get(count).add(arr[i]);
                        list1.get(count).add(arr[j]);
                        list1.get(count).add(arr[left]);
                        list1.get(count).add(arr[right]);
                        count++;

                        // Jumping over the duplicate values for left and right pointer
                        while(left < arr.length-1 && arr[left+1] == arr[left]){
                            left = left + 1;
                        }

                        while(right > 0 && arr[right-1] == arr[right]){
                            right = right - 1;
                        }

                        left++;
                        right--;
                    }
                }

                // Jumping over the duplicate values for j
                while(j < arr.length-1 && arr[j+1] == arr[j]){
                    j = j + 1;
                }
            }

            // Jumping over the duplicate values for i
            while(i < arr.length - 1 && arr[i+1] == arr[i]){
                i = i + 1;
            }
        }

        for(int i = 0; i < list1.size(); i++){
            System.out.println(list1.get(i));
        }
    }
}
