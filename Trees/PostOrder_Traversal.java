package com.company.Trees;

import java.util.Stack;

// Traversing the tree in the order : Left , Right , Root
public class PostOrder_Traversal {
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

        PostOrder(root);

        System.out.println();

        // Using two stack
        PostOrderIterative(root);
    }

    static void PostOrder(TreeNode root){
        if(root.val == -1){
            return;
        }
        PostOrder(root.left);
        PostOrder(root.right);
        System.out.println(root.val);
    }

    static void PostOrderIterative(TreeNode root){
        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();
        stack1.push(root);
        while(!stack1.isEmpty()){
            root = stack1.pop();
            stack2.push(root);
            if(root.left.val != -1) stack1.push(root.left);
            if(root.right.val != -1) stack1.push(root.right);
        }

        while (!stack2.isEmpty()){
            System.out.println(stack2.pop().val);
        }
    }
}
