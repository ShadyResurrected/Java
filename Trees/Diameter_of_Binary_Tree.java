package com.company.Trees;

public class Diameter_of_Binary_Tree {
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

        int[] maxi = new int[1];
        int ans = FindDiameter(root,maxi);
        System.out.println(maxi[0]);
    }

    static int FindDiameter(TreeNode root,int[] maxi){
        if(root.val == -1){
            return 0;
        }

        int leftH = FindDiameter(root.left,maxi);
        int rightH = FindDiameter(root.right,maxi);

        maxi[0] = Math.max(maxi[0],leftH+rightH);

        return 1 + Math.max(leftH,rightH);
    }
}
