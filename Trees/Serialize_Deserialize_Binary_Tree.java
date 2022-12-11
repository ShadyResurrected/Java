package com.company.Trees;

import java.util.*;

public class Serialize_Deserialize_Binary_Tree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);

        root.left = new TreeNode(2);
        root.left.left = new TreeNode();
        root.left.right = new TreeNode();

        root.right = new TreeNode(3);

        root.right.left = new TreeNode(4);
        root.right.left.right = new TreeNode();
        root.right.left.left = new TreeNode();

        root.right.right = new TreeNode(5);
        root.right.right.left = new TreeNode();
        root.right.right.right = new TreeNode();

        String ans = serialize(root);
        System.out.println(ans);
        deserialize(ans);
    }

    // Encodes a tree to a single string.
    public static String serialize(TreeNode root) {
        if(root == null) return "";
        List<String> list = new ArrayList<>();
        FindString(root,list);
        String str = "";
        for(int i = 0; i < list.size(); i++){
            str += list.get(i);
            if(i != list.size()-1) str += ",";
        }
        return str;
    }

    // Decodes your encoded data to tree.
    public static TreeNode deserialize(String data) {
        if(data == "") return null;
        String[] strArray = null;
        strArray = data.split(",");
        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode root = new TreeNode(Integer.parseInt(strArray[0]));
        queue.offer(root);
        for (int i = 1 ;i < strArray.length;i++){
            TreeNode currentNode = queue.poll();
            if(!strArray[i].equals("null")){
                TreeNode left = new TreeNode(Integer.parseInt(strArray[i]));
                currentNode.left = left;
                queue.offer(left);
            }
            if(!strArray[++i].equals("null")){
                TreeNode right = new TreeNode(Integer.parseInt(strArray[i]));
                currentNode.right = right;
                queue.offer(right);
            }
        }
        return root;
    }

    static void FindString(TreeNode root,List<String> list){
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            TreeNode currentNode = queue.poll();
            if(currentNode.val != -1001){ // used -1001 to avoid collision of values in leetcode
                // To run this code here replace the value with -1
                list.add(String.valueOf(currentNode.val));
                if (currentNode.left != null) queue.offer(currentNode.left);
                else queue.offer(new TreeNode(-1001));
                if (currentNode.right != null) queue.offer(currentNode.right);
                else queue.offer(new TreeNode(-1001));
            } else list.add("null");
        }
    }
}
