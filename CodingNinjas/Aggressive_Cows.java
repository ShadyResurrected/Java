package com.company.CodingNinjas;

import java.util.ArrayList;

public class Aggressive_Cows {
    public static void main(String[] args) {

    }

    // Brute Force
    static int FindLargestMinDistance(ArrayList<Integer> stalls,int k){
        int minDistance = 0;
        int maxDistance = stalls.get(stalls.size()-1) - stalls.get(0);
        for(int distance = 1; distance <= maxDistance; distance++){
            if(isCompatible(stalls,k,distance)){
                minDistance = distance;
            }else
                break;
        }
        return minDistance;
    }

    static boolean isCompatible(ArrayList<Integer> stalls, int k, int distance){
        int cows = k;
        int currentPos = stalls.get(0);
        for(int i = 1; i < stalls.size(); i++){
            if(cows > 1){
                if(stalls.get(i) - currentPos >= distance){
                    currentPos = stalls.get(i);
                    cows--;
                }
            }else
                break;
        }

        return cows == 1;
    }
}
