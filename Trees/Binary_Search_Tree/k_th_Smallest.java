package com.company.Trees.Binary_Search_Tree;

import com.company.Trees.TreeNode;

public class k_th_Smallest {
    public static void main(String[] args) {

    }


    static TreeNode FindNode(TreeNode root, int[] count, int k){
        if(root == null) return null;
        TreeNode left = FindNode(root.left,count,k);
        count[0] += 1;
        if(count[0] == k){
            return root;
        }
        TreeNode right = FindNode(root.right,count,k);
        return left != null ? left : right;
    }
}
