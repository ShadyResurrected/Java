package com.company.Trees;

public class Children_Sum_Property {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(40);
        root.left = new TreeNode(10);
        root.right = new TreeNode(20);

        root.left.left = new TreeNode(2);
        root.left.left.left = new TreeNode();
        root.left.left.right = new TreeNode();

        root.left.right = new TreeNode(5);
        root.left.right.left = new TreeNode();
        root.left.right.right = new TreeNode();

        root.right.left = new TreeNode(30);
        root.right.left.left = new TreeNode();
        root.right.left.right = new TreeNode();

        root.right.right = new TreeNode(40);
        root.right.right.left = new TreeNode();
        root.right.right.right = new TreeNode();

        ChildrenPropertyCheck(root);
    }

    static void ChildrenPropertyCheck(TreeNode root){
        if(root.val == -1) return;

        if(root.left.val != -1 && root.right.val != -1 && root.left.val + root.right.val <= root.val){
            root.left.val = root.val;
            root.right.val = root.val;
        }else if(root.left.val != -1 && root.right.val != -1 && root.left.val + root.right.val > root.val){
            root.val = root.left.val + root.right.val;
        }
        if(root.left.val != -1) ChildrenPropertyCheck(root.left);
        if(root.right.val != -1) ChildrenPropertyCheck(root.right);

        if(root.left.val + root.right.val > root.val){
            root.val = root.left.val + root.right.val;
        }
    }
}
