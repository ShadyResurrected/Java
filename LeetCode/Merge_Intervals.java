package com.company.LeetCode;
// Coding Ninjas remaining
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Merge_Intervals {
    public static void main(String[] args) {
        int[][] intervals = {{1,3},{2,6},{8,10},{9,9},{15,18}};
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        List<int[]> list = new ArrayList<>();
        int current_start = intervals[0][0];
        int current_end = intervals[0][1];
        for(int i = 0; i < intervals.length; i++){
            int new_start = intervals[i][0];
            int new_end = intervals[i][1];
            if(current_end >= new_start){
                current_end = Math.max(current_end,new_end);
            }else{
                list.add(new int[]{current_start,current_end});
                current_start = new_start;
                current_end = new_end;
            }
        }
        list.add(new int[]{current_start,current_end});
        System.out.println(Arrays.toString(list.toArray(new int[list.size()][])));
    }
}
