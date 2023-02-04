package com.company.Trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Zig_Zag_Traversal {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.left.left.left = new TreeNode();
        root.left.left.right = new TreeNode();
        root.left.right.left = new TreeNode();
        root.left.right.right = new TreeNode();

        root.right = new TreeNode(3);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode();
        root.right.left.left = new TreeNode();
        root.right.left.right = new TreeNode();
        root.right.left.right = new TreeNode(7);
        root.right.left.right.left = new TreeNode();
        root.right.left.right.right = new TreeNode();

        List<List<Integer>> ans = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        PrintZigZag(root,ans,queue);
        System.out.println(ans);
    }

    static void PrintZigZag(TreeNode root,List<List<Integer>> ans,Queue<TreeNode> queue){
        if (root.val == -1) return;
        int flag = 1;
        queue.offer(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            List<Integer> row = new ArrayList<>();
            for (int i = 0; i < size; i++){
                if(queue.peek().left.val != -1) queue.offer(queue.peek().left);
                if(queue.peek().right.val != -1) queue.offer(queue.peek().right);
                row.add(queue.poll().val);
            }
            if(flag == -1){
                ReverseList(row);
                flag = 1;
            }else{
                flag = -1;
            }
            ans.add(row);
        }
    }

    static void ReverseList(List<Integer> list){
        int start = 0;
        int end = list.size() - 1;
        while (start <= end){
            int temp = list.get(start);
            list.set(start,list.get(end));
            list.set(end,temp);
            start++;
            end--;
        }
    }
}
