package com.company.CodingNinjas;

import java.util.ArrayList;

public class Matrix_Median {
    public static void main(String[] args) {

    }

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
