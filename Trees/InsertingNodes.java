package com.company.Trees;
// Forming the tree
//           1
//          /   \
//         2      3
//        / \    /
//       4   5  6
//              \
//               7


public class InsertingNodes {
    public static void main(String[] args) {
        TreeNode node = new TreeNode(1);
        node.left = new TreeNode(2);
        node.left.left = new TreeNode(4);
        node.left.right = new TreeNode(5);
        node.left.left.left = new TreeNode();
        node.left.left.right = new TreeNode();
        node.left.right.left = new TreeNode();
        node.left.right.right = new TreeNode();

        node.right = new TreeNode(3);
        node.right.left = new TreeNode(6);
        node.right.left.right = new TreeNode(7);
    }
}
