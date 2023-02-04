package com.company.Trees;

public class Check_For_Symmetric_Binary_Tree {
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

//        First check the root and its left, right children before defining the left subtree and right subtree
//        if(root == null) return true;
//        if(root.left == null || root.right == null) return root.left == root.right;
        TreeNode LeftRoot = root.left;
        TreeNode RightRoot = root.right;
        boolean ans = Helper(LeftRoot,RightRoot);
        System.out.println(ans);
    }

    static boolean Helper(TreeNode LeftRoot,TreeNode RightRoot){
        if(LeftRoot == null || RightRoot == null) return LeftRoot == RightRoot;
        return LeftRoot.val == RightRoot.val && Helper(LeftRoot.left,RightRoot.right) && Helper(LeftRoot.right,RightRoot.left);
    }
}
