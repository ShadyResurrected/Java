package com.company.Trees;

import java.util.HashMap;
import java.util.List;

public class Morris_Preorder_Traversal {
    public static void main(String[] args) {

    }
    static void MorrisTraversal(TreeNode root, TreeNode cur, List<Integer> list, HashMap<TreeNode,TreeNode> hMap){
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
                    cur = cur.right;
                }else{
                    list.add(cur.val);
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
