package com.java.leetcode.binarytree;

import com.java.leetcode.objects.TreeNode;

public class CountNodesOfCompleteTree {

    // recursive
    public static int countNodes(TreeNode root) {
        if (root == null) return 0;
        int leftHeight = getHeight(root.left);
        int rightHeight = getHeight(root.right);
        if (leftHeight == rightHeight) {
            // The last leaf node is on the right child tree.
            // the node count of a perfect binary tree is calculated as 2^height - 1;
            return (1 << leftHeight) + countNodes(root.right);
        } else {
            // The last leaf node is on the left child tree.
            return (1 << rightHeight) + countNodes(root.left);
        }
    }

    public static int getHeight(TreeNode root) {
        int height = 0;
        while (root != null) {
            height++;
            root = root.left;
        }
        return height;
    }


    // non-recursive
    public static int countNodes2(TreeNode root) {
        if(root == null)return 0;
        int count = 0;
        while(root != null) {
            int leftHeight = getHeight(root.left);
            int rightHeight = getHeight(root.right);
            if (leftHeight == rightHeight) {
                count += 1 << leftHeight;
                root = root.right;
            } else{
                count += 1 << rightHeight;
                root = root.left;
            }
        }
        return count;
    }


    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        node1.left = new TreeNode(2, new TreeNode(3), new TreeNode(4));
        node1.right = new TreeNode(2, new TreeNode(4), new TreeNode(3));
        System.out.println(countNodes(node1));
        System.out.println(countNodes2(node1));
    }

}
