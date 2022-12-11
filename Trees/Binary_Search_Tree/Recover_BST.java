package com.company.Trees.Binary_Search_Tree;

import com.company.Trees.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Recover_BST {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode();

        root.left = new TreeNode(3);
        root.left.left = new TreeNode();

        root.left.right = new TreeNode(2);
        root.left.right.left = new TreeNode();
        root.left.right.right = new TreeNode();

        recoverTree(root);
    }

    static void recoverTree(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        HelperFunc(root,list);
        Collections.sort(list);
        CheckTree(root,list,0);
    }

    static void HelperFunc(TreeNode root,List<Integer> list){
        if(root.val == -1) return;

        HelperFunc(root.left,list);
        list.add(root.val);
        HelperFunc(root.right,list);
    }

    static void CheckTree(TreeNode root,List<Integer> list,int i){
        if(root.val == -1) return;
        CheckTree(root.left,list,i);
        if(list.get(i) != root.val) root.val = list.get(i);
        CheckTree(root.right,list,i+1);
    }
}
