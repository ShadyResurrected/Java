package com.company.DP;

public class Count_Square_Submatrices_With_All_Ones {
    public static int countSquares(int n, int m, int[][] arr) {
        // Write your code here.
        return HelperFunc(n,m,arr);
    }

    static int HelperFunc(int n,int m,int[][] arr){
        int res = 0;

        int[][] dpArr = new int[n][m];

        for(int i = 0;i < n; i++) dpArr[i][0] = arr[i][0];
        for(int i = 0;i < m; i++) dpArr[0][i] = arr[0][i];


        for(int i = 1;i < n; i++){
            for(int j = 1;j < m; j++){
                int up = dpArr[i-1][j];
                int diagonalLeft = dpArr[i-1][j-1];
                int left = dpArr[i][j-1];

                if(arr[i][j] != 0) dpArr[i][j] = Math.min(up,Math.min(diagonalLeft,left)) + 1;
            }
        }

        for(int[] row : dpArr) for(int ele : row) res += ele;

        return res;
    }
}
