package com.company.Trees;

import java.util.*;

class Tuple{
    TreeNode node;
    int x_coordinate;
    int y_coordinate;
    public Tuple(TreeNode node,int x,int y){
        this.node = node;
        this.x_coordinate = x;
        this.y_coordinate = y;
    }
}

public class Vertical_Order_Traversal {
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
        Queue<Tuple> queue = new LinkedList<>();
        TreeMap<Integer,TreeMap<Integer, List<Integer>>> tMapVertical = new TreeMap<>();
        VerticalOrderTraversal(root,queue,tMapVertical);
    }

    private static void VerticalOrderTraversal(TreeNode root, Queue<Tuple> queue, TreeMap<Integer, TreeMap<Integer, List<Integer>>> tMapVertical) {
        Tuple t1 = new Tuple(root,0,0);
        queue.offer(t1);
        while(!queue.isEmpty()){
            Tuple tuple = queue.poll();
            TreeNode node = tuple.node;

            int x = tuple.x_coordinate;
            int y = tuple.y_coordinate;

            if(!tMapVertical.containsKey(x)){
                tMapVertical.put(x,new TreeMap<>());
            }
            if(!tMapVertical.get(x).containsKey(y)){
                tMapVertical.get(x).put(y, new ArrayList<>());
            }
            // Adding the node val in the list
            tMapVertical.get(x).get(y).add(node.val);

            if(node.left.val != -1){
                queue.offer(new Tuple(node.left, x-1, y+1));
            }
            if(node.right.val != -1){
                queue.offer(new Tuple(node.right, x+1, y+1));
            }
        }

        List<List<Integer>> ans = new ArrayList<>();
        for(TreeMap<Integer, List<Integer>> level : tMapVertical.values()){
            ans.add(new ArrayList<>());
            for (List<Integer> nodes : level.values()){
                Collections.sort(nodes);
                ans.get(ans.size()-1).addAll(nodes);
            }
        }
        System.out.println(ans);
    }
}
