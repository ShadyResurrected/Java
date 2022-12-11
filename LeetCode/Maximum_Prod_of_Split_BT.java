package com.company.LeetCode;

import com.company.Trees.TreeNode;

public class Maximum_Prod_of_Split_BT {
    static long mod = (long)1e9 + 7;
    public static void main(String[] args) {
//        TreeNode root = new TreeNode(1);
//
//        root.left = new TreeNode(2);
//        root.left.left = new TreeNode(4);
//        root.left.right = new TreeNode(5);
//
//        root.right = new TreeNode(3);
//        root.right.left = new TreeNode(6);

        TreeNode root = new TreeNode(1);

        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);

        root.right.right = new TreeNode(4);
        root.right.right.left = new TreeNode(5);

        root.right.right.right = new TreeNode(6);


        int ans = maxProduct(root);
        System.out.println(ans);
    }
    static int maxProduct(TreeNode root) {
        long[] ans = new long[2];
        TotalSum(root,ans);
        HelperFunc(root,ans);
        return (int)(ans[0]%mod);
    }

    static void TotalSum(TreeNode root,long[] value){
        if(root == null) return;

        value[1] += root.val;

        TotalSum(root.left,value);
        TotalSum(root.right,value);
    }

    static void CalcSum(TreeNode root,long[] value){
        if(root == null) return;

        value[0] += root.val;

        CalcSum(root.left,value);
        CalcSum(root.right,value);
    }

    static void HelperFunc(TreeNode root,long[] ans){
        if(root == null) return;

        long[] subtree = new long[1];
        CalcSum(root.left,subtree);

        ans[0] = Math.max(ans[0],(subtree[0] * (ans[1] - subtree[0])));

        HelperFunc(root.left,ans);

        subtree[0] = 0;
        CalcSum(root.right,subtree);

        ans[0] = Math.max(ans[0],(subtree[0] * (ans[1] - subtree[0])));
        HelperFunc(root.right,ans);
    }
}
