package com.company.Trees.Binary_Search_Tree;

import com.company.Trees.TreeNode;

import java.util.ArrayList;

public class Predecessor_Successor_BST {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(15);

        root.left = new TreeNode(10);
        root.right = new TreeNode(20);

        root.left.left = new TreeNode(8);
        root.left.left.left = new TreeNode();
        root.left.left.right = new TreeNode();

        root.left.right = new TreeNode(12);
        root.left.right.left = new TreeNode();
        root.left.right.right = new TreeNode();

        root.right.left = new TreeNode(16);
        root.right.left.left = new TreeNode();
        root.right.left.right = new TreeNode();

        root.right.right = new TreeNode(25);
        root.right.right.left = new TreeNode();
        root.right.right.right = new TreeNode();

        ArrayList<Integer> ans = predecessorSuccessor(root,10);

    }

    public static ArrayList<Integer> predecessorSuccessor(TreeNode root, int key) {
        // Write your code here.
        ArrayList<Integer>  list = new ArrayList<>();
        HelperFunc(root,key,list);
        ArrayList<Integer> ans = new ArrayList<>();
        ans.add(0,-1);
        ans.add(1,-1);
        for(int i = 0;i < list.size()-1; i++){
            if(list.get(i+1) == key) {
                ans.set(0,list.get(i));
                break;
            }
        }
        for(int i = 1;i < list.size()-1; i++){
            if(list.get(i-1) == key) {
                ans.set(1,list.get(i));
                break;
            }
        }
        return ans;
    }

    static void HelperFunc(TreeNode root,int key,ArrayList<Integer> list){
        if(root.val == -1) return;
        HelperFunc(root.left,key,list);
        list.add(root.val);
        HelperFunc(root.right,key,list);
    }
}
