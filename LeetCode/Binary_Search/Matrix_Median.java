package com.company.LeetCode.Binary_Search;

import java.util.ArrayList;
import java.util.Arrays;

public class Matrix_Median {
    public static void main(String[] args) {
        int[][] mat = {{2,6,9},{1,5,11},{3,7,8}};
    }

    // Optimal Approach
    static int FindMedian(ArrayList<ArrayList<Integer>> matrix){
        int n = matrix.size();
        int m = matrix.get(0).size();
        int low = 1;
        int high = 1000000000;
        while(low <= high){
            int mid = low + (high - low)/2;
            int count = 0;
            for(int i = 0; i < matrix.size(); i++){
                count += countElementsSmallerOrEqualTo(matrix.get(i),mid);
            }

            if(count <= (n*m)/2){
                low = mid + 1;
            }else
                high = mid - 1;
        }
        return low;
    }

    static int countElementsSmallerOrEqualTo(ArrayList<Integer> list,int target){
        int low = 0;
        int high = list.size() - 1;
        while(low <= high){
            int mid = low + (high-low)/2;
            if(list.get(mid) <= target){
                low = mid + 1;
            }else
                high = mid - 1;
        }
        return low;
    }
}
