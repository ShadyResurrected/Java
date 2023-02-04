package com.company.Stacks;

import java.util.Arrays;
import java.util.Stack;

public class Next_Greater_Element_2 {
    public static void main(String[] args) {
        int[] nums = {1,2,1};
        int[] ans = new int[nums.length];
        Arrays.fill(ans,-1);
        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();
        for (int num : nums) {
            stack1.push(num);
        }
        while(!stack1.isEmpty()){
            stack2.push(stack1.pop());
        }
        int i = 0;
        while(i < nums.length){
            if(!stack2.isEmpty() && nums[i] < stack2.peek()){
                ans[i] = stack2.peek();
                i++;
                if(!stack2.isEmpty()) stack1.push(stack2.pop());
            }else if(!stack1.isEmpty() && nums[i] < stack1.peek()){
                ans[i] = stack1.peek();
                i++;
                if(!stack2.isEmpty()) stack1.push(stack2.pop());
            }else{
                if(!stack2.isEmpty()) stack1.push(stack2.pop());
            }
        }
        System.out.println(Arrays.toString(ans));
    }
}
