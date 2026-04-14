package com.java.leetcode.objects;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode() {
    }

    public TreeNode(int val) {
        this.val = val;
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
    public static void printBinaryTree(TreeNode root) {

        List<Integer> result = new ArrayList<>();
        if(root == null) System.out.println("[]");
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()) {
            TreeNode current = queue.poll();
            if (current == null) {
                result.add(null); // Add null for missing nodes
                continue;
            }
            result.add(current.val);
            queue.add(current.left);
            queue.add(current.right);
        }

        // Trim trailing nulls to avoid unnecessary null placeholders
        while (result.size() > 0 && result.get(result.size() - 1) == null) {
            result.remove(result.size() - 1);
        }
        System.out.println(result);
    }


    // Helper function to add nodes for testing
    public static TreeNode insertLevelOrder(int[] arr, int i) {
        if (i < arr.length) {
            TreeNode node = new TreeNode(arr[i]);
            node.left = insertLevelOrder(arr, 2 * i + 1);
            node.right = insertLevelOrder(arr, 2 * i + 2);
            return node;
        }
        return null;
    }

}