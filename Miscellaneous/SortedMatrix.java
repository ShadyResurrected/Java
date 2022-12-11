package com.company.Miscellaneous;

import java.util.Arrays;

public class SortedMatrix {
    public static void main(String[] args) {
        int[][] matrix = {
                {1,2,3,4},
                {5,6,7,8},
                {9,10,11,12},
                {13,14,15,16}
        };
        int target = 16;
        System.out.println(Arrays.toString(search(matrix,target)));
    }

    // Search in the row provided between the columns provided
    static int[] binarySearch(int[][] matrix,int target,int row,int cStart,int cEnd){
        while(cStart <= cEnd){
            int mid = cStart + (cEnd - cStart)/2;
            if(matrix[row][mid] > target){
                cEnd = mid - 1;
            } else{
                cStart = mid + 1;
            }

            if(matrix[row][mid] == target){
                return new int[]{row,mid};
            }
        }

        return new int[]{-1,-1};
    }



    static int[] search(int[][] matrix,int target){
        int rows = matrix.length, cols;
        if(matrix[0].length == 0){
            cols = matrix[1].length;
        } else
        cols = matrix[0].length; //first row may be empty

        // This is the edge case
        if(rows == 1){
            return binarySearch(matrix,target,0,0,cols-1);
        }

        int rStart = 0;
        int rEnd = rows - 1;
        int cMid = cols/2;

        // run the loop till two rows are remaining
        while(rStart != (rEnd - 1)){
            int mid = rStart + (rEnd - rStart)/2;
            if(matrix[mid][cMid] == target){
                return new int[]{mid,cMid};
            }

            if(matrix[mid][cMid] < target){
                rStart = mid;
            } else
                rEnd = mid;
        }

        // now we have two rows remaining
        // check whether the middle rows contain the elements or not
        if(matrix[rStart][cMid] == target){
            return new int[]{rStart,cMid};
        }

        if(matrix[rStart+1][cMid] == target){
            return new int[]{rStart + 1,cMid};
        }

        // Search in the remaining portions
        //In 1st half
        if(matrix[rStart][cMid-1] == target){
            return new int[]{rStart,cMid-1};
        }
        //In 2nd half
//        target should be greater than the first and less than or equal to the last element
        if(matrix[rStart][cMid+1] == target && target <= matrix[rStart][cols-1]){
            return binarySearch(matrix,target,rStart,cMid+1,cols-1);
        }
        //In 3rd half
        if(matrix[rStart+1][cMid-1] == target){
            return new int[]{rStart+1,cMid-1};
        }
        //In 4th half
        if(matrix[rStart+1][cMid+1] == target && target <= matrix[rStart+1][cols-1]){
            return binarySearch(matrix,target,rStart+1,cMid+1,cols-1);
        }

        return new int[]{-1,-1};
    }
}
