package com.company.Trees;

import java.util.LinkedList;
import java.util.Stack;

// Traversing the tree in the order : Root , Left , Right
public class PreOrder_Traversal {
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

        PreOrderTraversal(root);
        System.out.println();
        PreOrderTraversalIterative(root);
    }

    static void PreOrderTraversal(TreeNode root){
        if(root.val == -1){
            return;
        }
        System.out.println(root.val);
        PreOrderTraversal(root.left);
        PreOrderTraversal(root.right);
    }

    static void PreOrderTraversalIterative(TreeNode root){
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while(!stack.isEmpty()){
            int size = stack.size();
            for (int i = 0; i < size; i++){
                System.out.println(stack.peek().val);
                root = stack.pop();
                if(root.right.val != -1){
                    stack.push(root.right);
                }
                if(root.left.val != -1){
                    stack.push(root.left);
                }
            }
        }
    }
}
