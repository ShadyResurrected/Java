package com.company.Miscellaneous;
//https://leetcode.com/problems/minimum-cost-to-move-chips-to-the-same-position/
public class Minimum_Cost_To_Move_Chips {
    public static void main(String[] args) {
        int[] position = {1,2,3,4,5};
        System.out.println(cost(position));
    }

    static int cost(int[] position){
        int min_Cost = 0;
        int gatherPos = 0;
        for(int i = position.length-1; i > 0; i--){
//            for(int j = 0; j < position.length; j++){
//                if(find == position[j]){
//                    min_Cost += 0;
//                    break;
//                }else if(position[i] == position[j]){
//                    break;
//                }else if((find + 1) == position[j]){
//                    min_Cost += 1;
//                    break;
//                }
//
//            }
            int j = 0;
            while(position[i] != gatherPos){
                if(position[i] - 2  == position[j]){
                    min_Cost += 0;
                    gatherPos = position[i] - 2;
                    position[i] = position[i] - 2;
                    j = -1;
                }else if(position[i] == position[j]){
                    break;
                }else if(position[i] - 1 == position[j]){
                    min_Cost += 1;
                    gatherPos = position[i] - 1;
                    position[i] = position[i] - 1;
                    j = -1;
                }
                j++;
            }
        }



        return min_Cost;
    }
}
