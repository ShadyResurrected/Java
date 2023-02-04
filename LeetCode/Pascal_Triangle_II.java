package com.company.LeetCode;

import java.util.ArrayList;
import java.util.List;

public class Pascal_Triangle_II {
    public static void main(String[] args) {
        List<Integer> res = getRow(3);

    }

    static List<Integer> getRow(int rowIndex) {
        List<List<Integer>> adj = new ArrayList<>();
        HelperFunc(rowIndex,adj);
        return rowIndex != 0 ? adj.get(rowIndex-1) : adj.get(rowIndex);
    }

    static void HelperFunc(int rowIndex,List<List<Integer>> adj){
        for(int row = 0;row <= rowIndex; row++){
            List<Integer> currRow = new ArrayList<>();
            for(int col = 0;col <= row; col++){
                if(col == 0 || col == row) currRow.add(1);
                else{
                    int element = adj.get(row-1).get(col-1) + adj.get(row-1).get(col);
                    currRow.add(element);
                }
            }
            adj.add(new ArrayList<>());
            adj.get(row).addAll(currRow);
        }
    }
}
