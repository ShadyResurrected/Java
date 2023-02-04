package com.company.GFG;

public class TwoD_Hopscotch {
    public static void main(String[] args) {
        int n = 3;
        int m = 3;
        int[][] mat = {{5, 9, 7},
                {6, 4, 5},
                {8, 1, 2}};
        int ty = 0;
        int i = 1;
        int j = 1;
        int res = hopscotch(n,m,mat,ty,i,j);
        System.out.println(res);
    }
    static int hopscotch(int n, int m, int mat[][], int ty, int i, int j)
    {
        // code here
        int steps = 1;
        if(ty == 1) steps = 2;

        int[] delRow = {-1,   0,   1,   1,    1,   0};
        int[] delCol = { 0,   1,   1 ,  0,  -1,   -1};

        int res = HelperFunc(n,m,mat,i,j,delRow,delCol,steps);
        return res;
    }

    static int HelperFunc(int n,int m,int[][] mat,int i,int j,int[] delRow,int[] delCol,int steps){
        int total = 0;
        // Considering all the 6-directions
        for(int k = 0;k < 6;k++){
            int newRow = i + delRow[k];
            int newCol = j + delCol[k];
            // Checking the validity of the new cell calculated
            if(newRow >= 0 && newCol >= 0 && newRow < n && newCol < m){
                total += mat[newRow][newCol];
            }
        }
        return total;
    }

}
