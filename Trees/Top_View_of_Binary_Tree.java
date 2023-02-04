package com.company.Trees;

import java.util.*;

class NewTuple{
    TreeNode node;
    int x;
    public NewTuple(TreeNode node,int x){
        this.node = node;
        this.x = x;
    }
}

public class Top_View_of_Binary_Tree {
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

        List<Integer> list = new ArrayList<>();
        Queue<NewTuple> queue = new LinkedList<>();
        TreeMap<Integer, List<Integer>> tMap = new TreeMap<>();
        TopView(root,queue,tMap,list);
        System.out.println(list);
    }

    private static void TopView(TreeNode root, Queue<NewTuple> queue, TreeMap<Integer, List<Integer>> tMap, List<Integer> list) {
        if(root == null) return;
        queue.offer(new NewTuple(root,0));
        while(!queue.isEmpty()){
            NewTuple t1 = queue.poll();
            TreeNode node = t1.node;

            int x = t1.x;

            if(!tMap.containsKey(x)){
                List<Integer> ele = new ArrayList<>();
                ele.add(node.val);
                tMap.put(x,ele);
            }

            if (node.left.val != -1) queue.offer(new NewTuple(node.left,x-1));
            if (node.right.val != -1) queue.offer(new NewTuple(node.right,x+1));
        }

        for (List<Integer> row : tMap.values()){
            list.addAll(row);
        }
    }
}
