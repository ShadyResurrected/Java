package com.company.Trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// Traversing all the nodes level wise
public class LevelOrder_Traversal {
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

        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> list = new ArrayList<>();
        LevelOrder(root,queue,list);
        System.out.println(list);
    }

    static void LevelOrder(TreeNode root,Queue<TreeNode> queue,List<List<Integer>> list){
        if(root == null){
            return;
        }
        queue.offer(root);
        while (!queue.isEmpty()){
            int size = queue.size();
            List<Integer> row = new ArrayList<>();
            for (int i = 0; i < size; i++){
                if(queue.peek().left.val  != -1){
                    queue.offer(queue.peek().left);
                }
                if(queue.peek().right.val  != -1){
                    queue.offer(queue.peek().right);
                }
                row.add(queue.poll().val);
            }
            list.add(row);
        }
    }
}
