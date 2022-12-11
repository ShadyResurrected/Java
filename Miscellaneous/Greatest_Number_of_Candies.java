package com.company.Miscellaneous;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/kids-with-the-greatest-number-of-candies/
public class Greatest_Number_of_Candies {
    public static void main(String[] args) {
        int[] candies = {12,1,12};
        int extraCandies = 10;
        System.out.println(ExtraCandy(candies,extraCandies));
    }

    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        ArrayList<Boolean> result = new ArrayList<>();
        for(int i = 0; i < candies.length; i++){
            int MAX = candies[i] + extraCandies;
            int count = 0;
            for(int k:candies){
                if(MAX < k){
                    result.add(false);
                    break;
                }
                count++;
            }
            if(count == candies.length){
                result.add(true);
            }
        }

        return result;
    }

    static List<Boolean> ExtraCandy(int[] candies,int extraCandies){
        ArrayList<Boolean> result = new ArrayList<>();
        for(int i = 0; i < candies.length; i++){
            int MAX = candies[i] + extraCandies;
            int count = 0;
            for(int k:candies){
                if(MAX < k){
                    result.add(false);
                    break;
                }
                count++;
            }
            if(count == candies.length){
                result.add(true);
            }
        }

        return result;
    }
}
