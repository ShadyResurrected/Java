package com.company.Trees;

import java.util.*;

public class Boundary_Traversal {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.left.left.left = new TreeNode();
        root.left.left.right = new TreeNode();
        root.left.right.left = new TreeNode();
        root.left.right.right = new TreeNode();

        root.right = new TreeNode(3);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode();
        root.right.left.left = new TreeNode();
        root.right.left.right = new TreeNode();
        root.right.left.right = new TreeNode(7);
        root.right.left.right.left = new TreeNode();
        root.right.left.right.right = new TreeNode();

        Queue<TreeNode> queue = new LinkedList<>();
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> list = new ArrayList<>();
        BoundaryTraversal(root,queue,stack,list);
        System.out.println(list);

//        Left Boundary of the tree (excluding the leaf nodes).
//        All the leaf nodes travelled in the left to right direction.
//        Right Boundary of the tree (excluding the leaf nodes), traversed in the reverse direction.
    }

    public static boolean isLeafNode(TreeNode node){
        return (node.left.val == -1) && (node.right.val == -1);
    }

    private static void LeafTraversal(TreeNode root, Queue<TreeNode> queue, List<Integer> list) {
        if(isLeafNode(root)) {
            list.add(root.val);
            return;
        }
        if(root.left.val != -1) LeftTraversal(root.left,queue,list);
        if(root.right.val != -1) LeftTraversal(root.right,queue,list);
    }

    private static void RightTraversal(TreeNode root, Stack<TreeNode> stack, List<Integer> list) {
        TreeNode temp = root.right;
        while(temp.val != -1){
            if(!isLeafNode(root)) stack.push(root);
            if(temp.right.val != -1) temp = temp.right;
            else temp = temp.left;
        }
        while (!stack.isEmpty()){
            list.add(stack.pop().val);
        }
    }
    private static void LeftTraversal(TreeNode root, Queue<TreeNode> queue, List<Integer> list) {
        TreeNode temp = root.left;
        while(temp.val != -1){
            if(!isLeafNode(temp)) list.add(temp.val);
            if(temp.left.val != -1) temp = temp.left;
            else temp = temp.right;
        }
    }

    private static void BoundaryTraversal(TreeNode root, Queue<TreeNode> queue, Stack<TreeNode> stack,List<Integer> list) {
        if(!isLeafNode(root)) list.add(root.val);
        LeftTraversal(root,queue,list);
        LeafTraversal(root,queue,list);
        RightTraversal(root,stack,list);
    }

}
