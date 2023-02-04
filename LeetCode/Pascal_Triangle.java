package com.company.LeetCode;

import java.util.ArrayList;
import java.util.List;

public class Pascal_Triangle {
    public static void main(String[] args) {

        List<List<Integer>> ans = generate(5);
        for (int i = 0; i < ans.size(); i++){
            for(int j = 0 ; j < ans.get(i).size(); j++){
                System.out.println(ans.get(j));
            }
        }

    }

    static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> listOutput = new ArrayList<>();
        return  listOutput;
    }
}
