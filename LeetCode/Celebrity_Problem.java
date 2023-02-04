package com.company.LeetCode;

import java.util.Stack;

public class Celebrity_Problem {
    public static void main(String[] args) {
        int N = 3;
        int M[][] = {{0, 1 ,0},
            {0, 0, 0},
            {0 ,1, 0}};
    }

    int celebrity(int M[][], int n)
    {
        // code here
        Stack<Integer> stack = new Stack<>();
        for(int row = 0;row < M.length;row++){
            stack.push(row);
        }
        while(stack.size() >= 2){
            int person1 = stack.pop();
            int person2 = stack.pop();
            if(M[person1][person2] == 1) stack.push(person2);
            else stack.push(person1);
        }
        int celeb = stack.pop();
        for(int i = 0;i < M.length;i++){
            if(i != celeb) if(M[celeb][i] == 1 || M[i][celeb] == 0) return -1;
        }
        return celeb;
    }
}
