package com.company.Trees;

import java.util.*;

public class Bottom_View_of_a_Tree {
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

        Queue<NewTuple> queue = new LinkedList<>();
        TreeMap<Integer,TreeNode> tMap = new TreeMap<>();
        List<Integer> list = new ArrayList<>();
        BottomTraversal(root,queue,tMap,list);
        System.out.println(list);
    }

    static void BottomTraversal(TreeNode root,Queue<NewTuple> queue,TreeMap<Integer,TreeNode> tMap,List<Integer> list){
        if(root == null) return;
        queue.offer(new NewTuple(root,0));
        while(!queue.isEmpty()){
            NewTuple t1 = queue.poll();
            TreeNode currentNode = t1.node;
            int x = t1.x;

            tMap.put(x,currentNode);

            if(currentNode.left.val != -1) queue.offer(new NewTuple(currentNode.left,x-1));
            if(currentNode.right.val != -1) queue.offer(new NewTuple(currentNode.right,x+1));
        }

        for (TreeNode selectedNode : tMap.values()){
            list.add(selectedNode.val);
        }
    }
}
