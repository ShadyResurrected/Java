package com.company.Trees.Binary_Search_Tree;

import com.company.Trees.TreeNode;

import java.util.Stack;

public class Two_Sum {
    public static void main(String[] args) {

    }


    static class BSTIterator{

        private Stack<TreeNode> stack = new Stack<>();
        // if reverse is true it means we are finding before
        // if reverse is false it means we are finding after
        boolean reverse = true;
        BSTIterator(TreeNode root,boolean isReverse){
            // Write your code here
            reverse = isReverse;
            fillStack(root);
        }

        int next(){
            // Write your code here
            TreeNode node = stack.pop();
            if(!reverse) fillStack(node.right);
            else fillStack(node.left);
            return node.val;
        }

        boolean hasNext(){
            // Write your code here
            return !stack.isEmpty();
        }

        private void fillStack(TreeNode root){
            // Inserting the nodes first time
            while(root != null){
                stack.push(root);
                if(reverse == true) root = root.right;
                else root = root.left;
            }
        }
    }

    public static boolean pairSumBst(TreeNode root, int k) {
        // Write your code here.
        BSTIterator iteratorN = new BSTIterator(root,false);
        BSTIterator iteratorB = new BSTIterator(root,true);

        int i = iteratorN.next();
        int j = iteratorB.next();
        while(i < j){
            if(i+j < k) i = iteratorN.next();
            else if(i + j > k) j = iteratorB.next();
            else return true;
        }

        return false;
    }
}
