package com.company.LeetCode;

import java.util.Arrays;

public class Best_Poker_Hand {
    public static void main(String[] args) {
        int[] ranks = {13,12,3,4,7};
        String[] suits = {"a","a","a","a","a"};

        // For suits
        int countSuit = 0;
        for(int i = 0; i < suits.length-1; i++){
            if(suits[i].equals(suits[i + 1])){
                countSuit++;
            }else
                break;
        }
        if(countSuit == 4){
            System.out.println("Flush");
        }


        // For ranks
        Arrays.sort(ranks);
        int countRank = 1;
        int prevRank = ranks[0];
        for (int i = 1; i < ranks.length; i++){
            if(ranks[i] == prevRank){
                countRank++;
            }else {
                prevRank = ranks[i];
                countRank = 1;
            }

            if(countRank == 3){
                System.out.println("Three of a Kind");
                break;
            }
        }

        if(countRank == 2){
            System.out.println("Pair");
        }
        if(countRank == 1){
            System.out.println("High Card");
        }
    }
}
