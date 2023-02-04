package com.company.Trees.Binary_Search_Tree;

import com.company.Trees.TreeNode;

class Node1{
    int LargestNode;
    int SmallestNode;
    int size;
    public Node1(int LargestNode,int SmallestNode,int size){
        this.LargestNode = LargestNode;
        this.SmallestNode = SmallestNode;
        this.size = size;
    }
}

public class Size_of_Largest_BST {
    public static void main(String[] args) {

    }

    static Node1 HelperFunc(TreeNode root){
        if(root == null) return new Node1(Integer.MIN_VALUE,Integer.MAX_VALUE,0);

        Node1 left = HelperFunc(root.left);
        Node1 right = HelperFunc(root.right);

        if(left.LargestNode < root.val && root.val < right.SmallestNode){
            return new Node1(Math.max(root.val,right.LargestNode),Math.min(root.val,left.SmallestNode),left.size+right.size+1);
        }

        return new Node1(Integer.MAX_VALUE,Integer.MIN_VALUE,Math.max(left.size,right.size));
    }
}
