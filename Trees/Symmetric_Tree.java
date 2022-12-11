package com.company.Trees;

public class Symmetric_Tree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);

        root.left.left = new TreeNode(3);
        root.left.left.left = new TreeNode();
        root.left.left.right = new TreeNode();

        root.left.right = new TreeNode(4);
        root.left.right.left = new TreeNode();
        root.left.right.right = new TreeNode();

        root.right.right = new TreeNode(3);
        root.right.right.right = new TreeNode();
        root.right.right.left = new TreeNode();

        root.right.left = new TreeNode(4);
        root.right.left.left = new TreeNode();
        root.right.left.right = new TreeNode();

        if(root.left.val == -1 && root.right.val == -1) System.out.println(true);
        if(root.left.val == -1 || root.right.val == -1) System.out.println(false);
        boolean ans = IfSymmetric(root.left,root.right);
        System.out.println(ans);
    }

    static boolean IfSymmetric(TreeNode LeftRoot, TreeNode RightRoot){
        boolean current = false;
        if(LeftRoot.val == -1 && RightRoot.val == -1) return true;

        current = IfSymmetric(LeftRoot.left,RightRoot.right);
        current = IfSymmetric(LeftRoot.right,RightRoot.left);
        if(LeftRoot.val == RightRoot.val) return true;
        return current;
    }
}
