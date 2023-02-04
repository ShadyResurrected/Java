package com.company.Trees;

import java.util.ArrayList;
import java.util.List;

public class Root_To_Node_Path {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(4);
        root.left.left.left = new TreeNode();
        root.left.left.right = new TreeNode();

        root.left.right = new TreeNode(5);

        root.left.right.left = new TreeNode(6);
        root.left.right.left.left = new TreeNode();
        root.left.right.left.right = new TreeNode();

        root.left.right.right = new TreeNode(7);
        root.left.right.right.left = new TreeNode();
        root.left.right.right.right = new TreeNode();

        root.right = new TreeNode(3);

        List<Integer> list = new ArrayList<>();
        boolean ans = HelperFunction(root,7,list);
        System.out.println(list);
    }

    static boolean HelperFunction(TreeNode root,int val,List<Integer> list){
        if(root.val == -1) return false;

        list.add(root.val);
        if(root.val == val) return true;
        boolean Left = false, Right = false;
        if(root.left != null) Left = HelperFunction(root.left,val,list);
        if(root.right != null) Right = HelperFunction(root.right,val,list);
        if(!(Left||Right)) list.remove(list.size()-1);
        return Left || Right;

    }
}
