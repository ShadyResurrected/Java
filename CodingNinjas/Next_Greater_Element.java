package com.company.CodingNinjas;

import java.util.Arrays;
import java.util.Stack;

public class Next_Greater_Element {
    public static void main(String[] args) {
        int[] nums = {4,12,5,3,1,2,5,3,1,2,4,6};
        int[] NGE = new int[nums.length];
        Arrays.fill(NGE,-1);
        Stack<Integer> stack = new Stack<>();
        for(int i = nums.length-1;i >= 0;i--){
            int currentElement = nums[i];
            if(!stack.isEmpty()){
                while(!stack.isEmpty() && stack.peek() <= currentElement){
                    stack.pop();
                }
                if(!stack.isEmpty()) NGE[i] = stack.peek();
            }
            stack.push(currentElement);
        }
        System.out.println(Arrays.toString(NGE));
    }
}
