package com.company.Miscellaneous;
// https://leetcode.com/problems/matrix-diagonal-sum/
public class Matrix_Diagonal_Sum {
    public static void main(String[] args) {
        int[][] mat = {
//                {1,2,3},
//                {4,5,6},
//                {7,8,9}
//                {1,1,1,1},
//                {1,1,1,1},
//                {1,1,1,1},
//                {1,1,1,1}
                {5}
        };
        System.out.println(diagonalSum(mat));
    }

    static int diagonalSum(int[][] mat){
        int ans = 0;
        for (int row = 0; row < mat.length ; row++){
            ans += mat[row][row];
        }

        for(int row = mat.length - 1; row >= 0; row--){
            ans += mat[row][mat.length - 1 - row];
        }

        if(mat.length % 2 == 1){
            ans -= mat[(mat.length -1)/2][(mat.length -1)/2];
        }

        return ans;
    }
}
