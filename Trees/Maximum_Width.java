package com.company.Trees;

import java.util.LinkedList;
import java.util.Queue;

class Pair1{
    TreeNode node;
    int index;
    public Pair1(TreeNode node,int index){
        this.node = node;
        this.index = index;
    }
}

public class Maximum_Width {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);

        root.left = new TreeNode(3);
        root.left.left = new TreeNode(8);
        root.left.left.left = new TreeNode();
        root.left.left.right = new TreeNode();

        root.left.right = new TreeNode();

        root.right = new TreeNode(7);
        root.right.left = new TreeNode();

        root.right.right = new TreeNode(4);
        root.right.right.left = new TreeNode();
        root.right.right.right = new TreeNode();

        Queue<Pair1> queue = new LinkedList<>();
        int ans = HelperFunc(root,queue);
        System.out.println(ans);
    }


    // Considering the 0-based indexing
    static int HelperFunc(TreeNode root,Queue<Pair1> queue){
        int ans = 0;
        queue.offer(new Pair1(root,0));
        while(!queue.isEmpty()){
            int size = queue.size();
            int min_index = queue.peek().index;
            int leftMost = 0;
            int rightMost = 0;
            for(int i = 0;i < size; i++){
                TreeNode node = queue.peek().node;
                int current_Index = queue.peek().index - min_index;
                queue.poll();

                if(i == 0) leftMost = current_Index;
                if(i == size-1) rightMost = current_Index;

                if(node.left != null) queue.offer(new Pair1(node.left,2*(current_Index) + 1));
                if(node.right != null) queue.offer(new Pair1(node.right,2*(current_Index) + 2));
            }
            ans = Math.max(ans,rightMost-leftMost+1);
        }
        return ans;
    }
}
