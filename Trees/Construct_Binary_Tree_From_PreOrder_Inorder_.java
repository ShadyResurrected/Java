package com.company.Trees;

import java.util.Arrays;

public class Construct_Binary_Tree_From_PreOrder_Inorder_ {
    public static void main(String[] args) {
        int[] preorder = {3,9,20,15,7};
        int[] inorder = {9,3,15,20,7};
        TreeNode root = buildTree(preorder,inorder);
    }
    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        TreeNode root = FindRoot(preorder,inorder);
        return root;
    }

    static TreeNode FindRoot(int[] preorder,int[] inorder){
        if(preorder.length == 0 || inorder.length == 0) return null;
        int rootVal = preorder[0];

        for(int i = 0;i < inorder.length;i++){
            if(rootVal == inorder[i]){
                rootVal = i;
                break;
            }
        }

        TreeNode root = new TreeNode(inorder[rootVal]);

        int[] InorderNew =  Arrays.copyOfRange(inorder, 0, rootVal);

        TreeNode leftSubtree = FindRoot(Arrays.copyOfRange(preorder, 1, InorderNew.length+1),Arrays.copyOfRange(inorder, 0, rootVal));

        TreeNode rightSubtree = FindRoot(Arrays.copyOfRange(preorder, InorderNew.length+1, preorder.length),Arrays.copyOfRange(inorder, rootVal+1, inorder.length));

        root.left = leftSubtree;
        root.right = rightSubtree;

        return root;
    }
}
