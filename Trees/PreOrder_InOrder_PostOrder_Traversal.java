package com.company.Trees;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class Pair{
    TreeNode node;
    int num;

    public Pair(TreeNode node,int num){
        this.node = node;
        this.num = num;
    }
}

public class PreOrder_InOrder_PostOrder_Traversal {
    public static void main(String[] args) {
        TreeNode node = new TreeNode(1);
        node.left = new TreeNode(2);
        node.left.left = new TreeNode(3);
        node.left.right = new TreeNode(4);
        node.left.left.left = new TreeNode();
        node.left.left.right = new TreeNode();
        node.left.right.left = new TreeNode();
        node.left.right.right = new TreeNode();

        node.right = new TreeNode(5);
        node.right.left = new TreeNode(6);
        node.right.right = new TreeNode(7);
        node.right.left.left = new TreeNode();
        node.right.left.right = new TreeNode();
        node.right.right.left = new TreeNode();
        node.right.right.right = new TreeNode();

        List<List<Integer>> Traversals = new ArrayList<>();
        for (int i = 0;i < 3;i++) Traversals.add(new ArrayList<>());
        Stack<Pair> stack = new Stack<>();

        AllTraversals(node,Traversals,stack);
        System.out.println(Traversals);
    }

    private static void AllTraversals(TreeNode root, List<List<Integer>> traversals,Stack<Pair> stack) {
        Pair node = new Pair(root,1);
        stack.push(node);
        while(!stack.isEmpty()){
            int number = stack.peek().num;
            TreeNode Node = stack.peek().node;
            int place = number - 1;
            if(number == 1){
                traversals.get(place).add(Node.val);
                stack.peek().num += 1;
                if(Node.left.val != -1){
                    stack.push(new Pair(Node.left,1));
                }
            }else if(number == 2){
                traversals.get(place).add(Node.val);
                stack.peek().num += 1;
                if(Node.right.val != -1){
                    stack.push(new Pair(Node.right,1));
                }
            }else if(number == 3){
                traversals.get(place).add(Node.val);
                stack.pop();
            }
        }
    }
}
