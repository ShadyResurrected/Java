package com.company.Trees;

import java.util.Arrays;
import java.util.HashMap;

public class Construct_Binary_Tree_From_PostOrder_Inorder {
    public static void main(String[] args) {
        int[] inorder = {9,3,15,20,7};
        int[] postorder = {9,15,7,20,3};
//        int[] inorder = {40,20,50,10,60,30};
//        int[] postorder = {40,50,20,60,30,10};
        TreeNode root = buildTree(inorder,postorder);
    }
    public static TreeNode buildTree(int[] inorder, int[] postorder) {
        HashMap<Integer,Integer> hMap = new HashMap<>();
        for (int i = 0;i < inorder.length;i++){
            hMap.put(inorder[i],i);
        }
        TreeNode root = FindRoot(postorder,0,postorder.length-1,inorder,0,inorder.length-1,hMap);
        return root;
    }

    static TreeNode FindRoot(int[] postorder,int postStart,int postEnd,int[] inorder,int inStart,int inEnd, HashMap<Integer,Integer> hMap){
        if(inStart > inEnd || postStart > postEnd) return null;

        TreeNode root = new TreeNode(postorder[postEnd]);
        int inRoot = hMap.get(root.val);
        int numLeft = inRoot - inStart;

        root.left = FindRoot(postorder,postStart,postStart + numLeft-1,inorder,inStart,inRoot-1,hMap);
        root.right = FindRoot(postorder,postStart + numLeft,postEnd-1,inorder,inRoot+1,inEnd,hMap);

        return root;
    }
}
