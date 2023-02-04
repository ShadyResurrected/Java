package com.company.CodingNinjas;

import java.util.Arrays;

public class Chess_Tournament {
    public static void main(String[] args) {
//        int[] positions = {1,2,3,4,6};
//        int c = 3;
        int[] positions = {6, 2, 1 ,9 ,11 ,12 ,14};
        int c = 4;
        Arrays.sort(positions);
        int ans = FindLargestMinDistance(positions,c);
        int ans1 = FindLargestMinDistanceBinarySearch(positions,c);
        System.out.println(ans);
        System.out.println(ans1);
    }

    // Brute Force Approach
    private static int FindLargestMinDistance(int[] positions,int c) {
        int maxDistance = 0;
        for(int distance = 1; distance <= (positions[positions.length - 1] - positions[0]); distance++){
            if(isCompatible(positions,distance,c)){
                maxDistance = distance;
            }else
                break;
        }
        return maxDistance;
    }

    static int FindLargestMinDistanceBinarySearch(int[] positions,int c){
        int start = 0;
        int end = positions[positions.length - 1] - positions[0];
        while (start <= end){
            int mid = start + (end-start)/2;
            if(isCompatible(positions,mid,c)){
                start = mid + 1;
            }else
                end = mid - 1;
        }
        return end;
    }

    static boolean isCompatible(int[] positions, int distance,int c){
        int currentPos = positions[0];
        int chessPlayers = c;
        for(int i = 1; i < positions.length; i++){
            if(chessPlayers > 1){
                if(positions[i] - currentPos >= distance){
                    chessPlayers--;
                    currentPos = positions[i];
                }
            }else
                break;
        }
        return chessPlayers == 1;
    }
}
