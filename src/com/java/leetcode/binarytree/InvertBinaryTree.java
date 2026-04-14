package com.java.leetcode.binarytree;

import com.java.leetcode.objects.TreeNode;

import java.util.*;

public class InvertBinaryTree {
    public static TreeNode invertTree(TreeNode root) {
        if(root == null) return null;
        if(root.left == null && root.right == null) return root;

        TreeNode revertedRight = invertTree(root.right);
        TreeNode revertedLeft = invertTree(root.left);
        root.left = revertedRight;
        root.right = revertedLeft;
        return root;
    }


    public static void main(String[] args) {
        TreeNode root1 = new TreeNode(2);
        root1.left = new TreeNode(1);
        root1.right = new TreeNode(3);
          printBinaryTree(root1);
          printBinaryTree(invertTree(root1));


        TreeNode root2 = new TreeNode(4);
        root2.left = new TreeNode(2, new TreeNode(1), new TreeNode(3));
        root2.right = new TreeNode(7, new TreeNode(6 ), new TreeNode(9));
        printBinaryTree(root2);
        printBinaryTree(invertTree(root2));

    }


    private static void printBinaryTree(TreeNode root) {

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

}
