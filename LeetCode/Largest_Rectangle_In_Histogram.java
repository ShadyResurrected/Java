package com.company.LeetCode;

import java.util.Stack;

public class Largest_Rectangle_In_Histogram {
    public static void main(String[] args) {
//        int[] histogram = {2,1,5,6,2,3,1};
//        int[] histogram = {3,2,5,1,4,2};
        int[] histogram = {1,2,2};
        int maxArea1 = Method1(histogram);
        int maxArea2 = Method2(histogram);
        int maxArea3 = Method3(histogram);
        System.out.println(maxArea1);
        System.out.println(maxArea2);
        System.out.println(maxArea3);
    }

    private static int Method3(int[] histogram) {
        Stack<Integer> stack = new Stack<>();
        int maxArea = 0;
        for(int i = 0;i <= histogram.length;i++){
            while(!stack.isEmpty() && (i == histogram.length || histogram[i] <= histogram[stack.peek()])){
                int width = i;
                int height = histogram[stack.pop()];
                if(!stack.isEmpty()) width = i - stack.peek() - 1;
                maxArea = Math.max(maxArea,height*width);
            }
            stack.push(i);
        }
        return maxArea;
    }

    private static int Method2(int[] histogram) {
        int area = 0;
        int[] left_small = new int[histogram.length];
        int[] right_small = new int[histogram.length];
        Stack<Integer> stackL = new Stack<>();

        // Finding the small element to the left of the current index from the starting
        for(int i = 0;i < histogram.length;i++){
            while(!stackL.isEmpty() && histogram[stackL.peek()] >= histogram[i]) stackL.pop();
            if(!stackL.isEmpty()){
                left_small[i] = stackL.peek()+1; // Adding 1 to ensure that boundary starts from immediate smaller block
            }else {
                left_small[i] = 0;
            }
            stackL.push(i);
        }

        Stack<Integer> stackR = new Stack<>();
        // Finding the small element to the right of the current index from the ending
        for(int i = histogram.length-1;i >= 0;i--){
                while(!stackR.isEmpty() && histogram[stackR.peek()] >= histogram[i]) stackR.pop();
                if(!stackR.isEmpty()){
                    right_small[i] = stackR.peek()-1;
                }else {
                    right_small[i] = histogram.length-1;
                }
            stackR.push(i);
        }

        int max_Area = 0;
        for (int i = 0;i < histogram.length;i++){
            int flag = (right_small[i]-left_small[i]+1)*histogram[i];
            max_Area = Math.max(max_Area,flag);
        }
        return max_Area;
    }

    static int Method1(int[] histogram){
        int maxArea = 0;
        for(int i = 0;i < histogram.length;i++){
            int minHeight = Integer.MAX_VALUE;
            for (int j = i; j < histogram.length; j++) {
                minHeight = Math.min(minHeight, histogram[j]);
                maxArea = Math.max(maxArea, minHeight * (j - i + 1));
            }
        }
        return maxArea;
    }

}
