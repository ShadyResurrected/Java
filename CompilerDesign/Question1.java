package com.company.CompilerDesign;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class Question1 {
    public static void main(String[] args) {
        int[] A = {1,2,3,4};
        int[][] P = {{2,2,4},{3,2,0},{1,0,0},{3,1,0}};
        int []res = query_game(4,A,4,P);
        System.out.println(Arrays.toString(res));
    }

    static int[] query_game(int N,int[] A,int Q,int[][] P){
        List<Integer> res = new ArrayList<>();
        int i = 0;
        int count = 0;
        while(i < Q){
            if(P[i][0] == 1){
                A = Reverse(A);
            }else if(P[i][0] == 2){
                Swap(P[i][1],P[i][2],A);
            }else if(P[i][0] == 3){
                int pos = HelperFunc(P[i][1],A);
                res.add(pos);
            }
            i++;
        }
        int[] result = new int[res.size()];
        for (int ele : res) result[count++] = ele;
        return result;
    }

    private static int HelperFunc(int ele, int[] A) {
        int pos = -1;
        for(int i = 0;i < A.length; i++){
            if(A[i] == ele){
                pos = i;
            }
        }
        return pos+1;
    }

    private static void Swap(int num1, int num2, int[] A) {
        int temp = A[num1-1];
        A[num1-1] = A[num2-1];
        A[num2-1] = temp;
    }

    static int[] Reverse(int[] A){
        int i = 0;
        int j = A.length - 1;
        while(i <= j){
            int temp = A[i];
            A[i] = A[j];
            A[j] = temp;

            i++; j--;
        }
        return A;
    }
}
