package com.company.Trees;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Morris_Inorder_Traversal {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);

        root.left = new TreeNode(2);

        root.left.left = new TreeNode(4);
        root.left.left.left = new TreeNode();
        root.left.left.right = new TreeNode();

        root.left.right = new TreeNode(5);
        root.left.right.left = new TreeNode();

        root.left.right.right = new TreeNode(6);
        root.left.right.right.left = new TreeNode();
        root.left.right.right.right = new TreeNode();

        root.right = new TreeNode(3);
        root.right.left = new TreeNode();
        root.right.right = new TreeNode();

        HashMap<TreeNode,TreeNode> hMap = new HashMap<>();
        MorrisTraversal(root,root,new ArrayList<>(),hMap);
    }

    static void MorrisTraversal(TreeNode root,TreeNode cur, List<Integer> list,HashMap<TreeNode,TreeNode> hMap){
        while(cur.val != -1){
            if(cur.left.val == -1) {
                list.add(cur.val);
                cur = cur.right;
            }
            else {
                TreeNode rightMost = FindRightMost(cur.left);
                if(!hMap.containsKey(cur)){
                    hMap.put(cur,rightMost);
                }
                if(hMap.containsKey(cur) && hMap.get(cur).right == cur){
                    hMap.get(cur).right = new TreeNode();
                    list.add(cur.val);
                    cur = cur.right;
                }else{
                    rightMost.right = cur;
                    cur = cur.left;
                }
            }
        }
    }

    static TreeNode FindRightMost(TreeNode root){
        if(root.right.val == -1) return root;
        return FindRightMost(root.right);
    }
}
