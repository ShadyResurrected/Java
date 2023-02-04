package com.company.Trees;

public class Count_Total_Nodes_In_Complete_Binary_Tree {
    public static void main(String[] args) {

    }
    public int countNodes(TreeNode root) {
        if(root == null) return 0;
        int left = HeightLeft(root);
        int right = HeightRight(root);

        if(left == right) return ((int)Math.pow(2,left) - 1);

        return 1 + countNodes(root.right) + countNodes(root.left);
    }

    static int HeightLeft(TreeNode root){
        int count = 1;
        while(root.left != null){
            count++;
            root = root.left;
        }
        return count;
    }

    static int HeightRight(TreeNode root){
        int count = 1;
        while(root.right != null){
            count++;
            root = root.right;
        }
        return count;
    }
}
