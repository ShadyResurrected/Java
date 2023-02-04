package com.company.Trees;

import java.util.Stack;

// Traversing the tree in order : Left , Root , Right
public class Inorder_Traversal {
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

        InorderTraversal(root);
        System.out.println();
        InorderTraversalIterative(root);
    }

    static void InorderTraversal(TreeNode root){
        if(root.val == -1){
            return;
        }
        InorderTraversal(root.left);
        System.out.println(root.val);
        InorderTraversal(root.right);
    }

    private static void InorderTraversalIterative(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = root;
        while(true){
            if(node.val != -1){
                stack.push(node);
                node = node.left;
            }else{
                if(stack.isEmpty()){
                    break;
                }
                node = stack.pop();
                System.out.println(node.val);
                node = node.right;
            }
        }
    }
}
