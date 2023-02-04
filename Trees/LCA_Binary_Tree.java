package com.company.Trees;

import java.util.ArrayList;
import java.util.List;

public class LCA_Binary_Tree {
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

//      TreeNode LCA = lowestCommonAncestor(root,new TreeNode(4),new TreeNode(7));
        TreeNode LCA = FindLCA(root,new TreeNode(4),new TreeNode(7));
        System.out.println(LCA.val);
    }

    static TreeNode FindLCA(TreeNode root, TreeNode p, TreeNode q){
        if(root == null || root == p || root == q) return root;

        TreeNode left = FindLCA(root.left,p,q);
        TreeNode right = FindLCA(root.right,p,q);;

        if(left == null) return right;
        else if(right == null) return left;

        //both left and right are not null, we found our result
        return root;
    }

    private static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        List<TreeNode> list1 = new ArrayList<>();
        List<TreeNode> list2 = new ArrayList<>();
        boolean ans = HelperFunction(root,p,list1);
        boolean ans1 = HelperFunction(root,q,list2);

        TreeNode res = new TreeNode(0);
        int i = 0; int j = 0;
        while(i < list1.size() && j < list2.size()){
            if(list1.get(i) != list2.get(j)){
                res = list1.get(i-1);
                break;
            }
            i++; j++;
        }
        if(i == list1.size()) return list1.get(list1.size()-1);
        if(j == list2.size()) return list2.get(list2.size()-1);
        return res;
    }

    static boolean HelperFunction(TreeNode root, TreeNode val, List<TreeNode> list){
        if(root == null) return false;

        list.add(root);
        if(root.val == val.val) return true;
        boolean Left = false, Right = false;
        if(root.left != null) Left = HelperFunction(root.left,val,list);
        if(root.right != null) Right = HelperFunction(root.right,val,list);
        if(!(Left||Right)) list.remove(list.size()-1);
        return Left || Right;

    }
}
