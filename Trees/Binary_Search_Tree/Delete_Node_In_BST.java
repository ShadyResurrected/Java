package com.company.Trees.Binary_Search_Tree;

import com.company.Trees.TreeNode;

public class Delete_Node_In_BST {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);

        root.left = new TreeNode(5);
        root.right = new TreeNode();

        root.left.left = new TreeNode();
        root.left.right = new TreeNode();

        int key = 5;

    }

    public static TreeNode deleteNode(TreeNode root, int key) {
        //Write your code here.
        if(root == null) return null;
        if(root.val == key) return HelperFunc(root);

        TreeNode dummy = root;
        while(root != null){
            if(root.val > key){
                if(root.left != null && root.left.val == key){
                    root.left = HelperFunc(root.left);
                    break;
                }else root = root.left;
            }else{
                if(root.right != null && root.right.val == key){
                    root.right = HelperFunc(root.right);
                    break;
                }else root = root.right;
            }
        }
        return dummy;
    }

    static TreeNode HelperFunc(TreeNode root){
        if(root.left == null) return root.right;
        else if(root.right == null) return root.left;

        TreeNode rightChild = root.right;
        TreeNode lastRight = findRight(root.left);
        lastRight.right = rightChild;
        return root.left;
    }

    static TreeNode findRight(TreeNode root){
        if(root.right == null) return root;
        return findRight(root.right);
    }
}
