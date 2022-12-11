package com.company.Trees;
import java.util.*;

public class Amount_Of_Time_For_Binary_Tree_To_Be_Infected {
    public static void main(String[] args) {

    }
    public int amountOfTime(TreeNode root, int start) {
        Queue<TreeNode> queue = new LinkedList<>();
        //      Children Parent
        HashMap<TreeNode,TreeNode> parentPointer = new HashMap<>();
        findParentPointer(root,queue,parentPointer);
        TreeNode startNode = findNode(root,start);
        HashSet<TreeNode> visited = new HashSet<>();
        int ans = findTime(root,startNode,queue,visited,parentPointer);
        return ans;
    }

    static void findParentPointer(TreeNode root,Queue<TreeNode> queue,HashMap<TreeNode,TreeNode> parentPointer){
        queue.offer(root);
        while(!queue.isEmpty()){
            TreeNode node = queue.poll();
            if(node.left != null){
                queue.offer(node.left);
                parentPointer.put(node.left,node);
            }
            if(node.right != null){
                queue.offer(node.right);
                parentPointer.put(node.right,node);
            }
        }
    }

    static TreeNode findNode(TreeNode root,int start){
        if(root == null) return null;

        if(root.val == start) return root;
        TreeNode Leftroot = findNode(root.left,start);
        TreeNode Rightroot = findNode(root.right,start);
        return Leftroot == null ? Rightroot : Leftroot;
    }

    static int findTime(TreeNode root,TreeNode startNode,Queue<TreeNode> queue,HashSet<TreeNode> visited,HashMap<TreeNode,TreeNode> parentPointer){
        int totalTime = -1;
        queue.offer(startNode);
        visited.add(startNode);
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0;i < size;i++){
                TreeNode node = queue.poll();

                // Checking all the nodes that it could burn
                // Checking for its parent node
                if(parentPointer.containsKey(node) && !visited.contains(parentPointer.get(node))){
                    visited.add(parentPointer.get(node));
                    queue.offer(parentPointer.get(node));
                }

                // Checking its left child
                if(node.left != null && !visited.contains(node.left)){
                    visited.add(node.left);
                    queue.offer(node.left);
                }

                // Checking its right child
                if(node.right != null && !visited.contains(node.right)){
                    visited.add(node.right);
                    queue.offer(node.right);
                }
            }
            totalTime++;
        }
        return totalTime;
    }
}
