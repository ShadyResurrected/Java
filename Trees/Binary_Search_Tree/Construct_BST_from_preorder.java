package com.company.Trees.Binary_Search_Tree;

import com.company.Trees.TreeNode;

public class Construct_BST_from_preorder {
    public static void main(String[] args) {
        int[] preOrder = {8,5,1,7,10,12};
    }

    public static TreeNode preOrderTree(int[] preOrder) {
        // Write your code here
        return bstFromPreorder(preOrder,Integer.MAX_VALUE,new int[]{0});
    }

    static TreeNode bstFromPreorder(int[] preOrder,int upperBound,int[] i){
        if(i[0] == preOrder.length || preOrder[i[0]] > upperBound) return null;
        TreeNode root = new TreeNode(preOrder[i[0]++]);
        root.left = bstFromPreorder(preOrder,root.val,i);
        root.right = bstFromPreorder(preOrder, upperBound, i);
        return root;
    }


}
