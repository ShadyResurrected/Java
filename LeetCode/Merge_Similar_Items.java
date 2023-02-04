package com.company.LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Merge_Similar_Items {
    public static void main(String[] args) {
//        int[][] items1 = {{1,1},{4,5},{3,8}};
//        int[][] items2 = {{3,1},{1,5}};
//        int[][] items1 = {{1,3},{2,2}};
//        int[][] items2 = {{7,1},{2,2},{1,4}};
        int[][] items1 = {{5,1},{4,2},{3,3},{2,4},{1,5}};
        int[][] items2 = {{7,1},{6,2},{5,3},{4,4}};
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(items1, (a, b) -> Integer.compare(a[0], b[0]));
        Arrays.sort(items2, (a, b) -> Integer.compare(a[0], b[0]));
        MergeSimilar(items1,items2,ans);
        System.out.println(ans);
    }

    private static void MergeSimilar(int[][] items1, int[][] items2, List<List<Integer>> ans) {
        int p1 = 0;
        int p2 = 0;
        while(p1 < items1.length && p2 < items2.length){
            if(items1[p1][0] == items2[p2][0]){
                List<Integer> row = new ArrayList<>();
                row.add(items1[p1][0]);
                row.add(items1[p1][1] + items2[p2][1]);
                ans.add(row);
                p1++;
                p2++;
            }else{
                List<Integer> row = new ArrayList<>();
                row.add(items1[p1][0]);
                row.add(items1[p1][1]);
                ans.add(row);
                p1++;
            }
        }

        // For the remaining list
        while (p1 < items1.length){
            List<Integer> row = new ArrayList<>();
            row.add(items1[p1][0]);
            row.add(items1[p1][1]);
            ans.add(row);
            p1++;
        }

        while (p2 < items2.length){
            List<Integer> row = new ArrayList<>();
            row.add(items2[p2][0]);
            row.add(items2[p2][1]);
            ans.add(row);
            p2++;
        }
    }
}
