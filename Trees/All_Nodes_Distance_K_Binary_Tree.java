package com.company.Trees;

import java.util.*;

public class All_Nodes_Distance_K_Binary_Tree {
    public static void main(String[] args) {

    }

    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        Queue<TreeNode> queue = new LinkedList<>();
        //      Children Parent
        HashMap<TreeNode,TreeNode> hMap = new HashMap<>();
        HashSet<TreeNode> hSet = new HashSet<>();
        FindParentPointers(root,hMap,queue);
        List<Integer> ans = FindDistanceK(root,target,k,hSet,hMap,queue);
        return ans;
    }

    static void FindParentPointers(TreeNode root,HashMap<TreeNode,TreeNode> hMap,Queue<TreeNode> queue){
        queue.offer(root);
        while(!queue.isEmpty()){
            TreeNode node = queue.poll();
            if(node.left != null){
                queue.offer(node.left);
                hMap.put(node.left,node);
            }
            if(node.right != null){
                queue.offer(node.right);
                hMap.put(node.right,node);
            }
        }
    }

    static List<Integer> FindDistanceK(TreeNode root,TreeNode target,int k,HashSet<TreeNode> visited,HashMap<TreeNode,TreeNode> parentMap,Queue<TreeNode> queue){
        List<Integer> list = new ArrayList<>();
        int distance = 0;
        queue.offer(target);
        visited.add(target);
        while(distance != k){
            int size = queue.size();
            for(int i = 0;i < size; i++){
                TreeNode node = queue.poll();
                // Checking for its parent node
                if(!visited.contains(parentMap.get(node)) && parentMap.containsKey(node)) {
                    visited.add(parentMap.get(node));
                    queue.offer(parentMap.get(node));
                }

                // Checking for its left children
                if(!visited.contains(node.left) && node.left != null){
                    visited.add(node.left);
                    queue.offer(node.left);
                }

                // Checking for its right children
                if(!visited.contains(node.right) && node.right != null){
                    visited.add(node.right);
                    queue.offer(node.right);
                }
            }

            distance++;
        }

        while(!queue.isEmpty()) list.add(queue.poll().val);
        return list;
    }
}
