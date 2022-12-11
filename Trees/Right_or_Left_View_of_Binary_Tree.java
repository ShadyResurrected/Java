package com.company.Trees;

import java.util.ArrayList;
import java.util.List;

public class Right_or_Left_View_of_Binary_Tree {
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

        // For the right view of a binary tree
        List<Integer> list = new ArrayList<>();
        RightTraversal(root,list,0);
        System.out.println(list);

        // For the left view of a binary tree
        List<Integer> list1 = new ArrayList<>();
        LeftTraversal(root,list1,0);
        System.out.println(list1);
    }

    // Using the recursive approach
    // Using the reverse preorder traversal
    // Insert only the rightmost node in each level
    // Root --> Right --> Left
    static void RightTraversal(TreeNode root,List<Integer> list,int level){
        if(root.val == -1) return;

        // Only inserting the value of node in the list if level == list.size()
        if(level == list.size()) list.add(root.val);

        RightTraversal(root.right,list,level+1);
        RightTraversal(root.left,list,level+1);
    }

    // Using the recursive approach
    // Using the reverse preorder traversal
    // Insert only the leftmost node in each level
    // Root --> Left --> Right
    static void LeftTraversal(TreeNode root,List<Integer> list,int level){
        if(root.val == -1) return;

        // Only inserting the value of node in the list if level == list.size()
        if(level == list.size()) list.add(root.val);

        LeftTraversal(root.left,list,level+1);
        LeftTraversal(root.right,list,level+1);
    }
}
