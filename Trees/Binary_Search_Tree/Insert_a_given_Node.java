package com.company.Trees.Binary_Search_Tree;

import com.company.Trees.TreeNode;

public class Insert_a_given_Node {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode();

        root.right = new TreeNode(3);
        root.right.left = new TreeNode();
        root.right.right = new TreeNode();

        HelperFunc(root,4,root);
    }

    static void HelperFunc(TreeNode root,int val,TreeNode prev){
        if(root.val == -1){
            if(prev.val >= val) prev.left = new TreeNode(val);
            else prev.right = new TreeNode(val);
            return;
        }
        TreeNode cur = root;
        if(root.val < val) HelperFunc(root.right,val,cur);
        if(root.val > val) HelperFunc(root.left,val,cur);
    }
}
