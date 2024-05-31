package com.java.leetcode.binarytree.binarysearchtree;

import com.java.leetcode.objects.TreeNode;

import java.util.Stack;

public class GetMinimumAbsoluteDifference {
    private static int mindiff = Integer.MAX_VALUE;
    private static TreeNode prev = null;

    public static int getMinimumDifference(TreeNode root) {
        // in-order traversal
        if (root == null) return mindiff;
        getMinimumDifference(root.left);
        if (prev != null) {
            mindiff = Math.min(mindiff, root.val - prev.val);
        }
        prev = root;
        getMinimumDifference(root.right);
        return mindiff;
    }


    public static int getMinimumDifference1(TreeNode root) {
        // in-order traversal
        if (root == null) return mindiff;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode current = root;

        while(current != null || !stack.isEmpty()) {
            while(current != null) {
                stack.push(current);
                current = current.left;
            }

            current = stack.pop();
            if(prev != null) {
                mindiff = Math.min(mindiff, current.val - prev.val);
            }
            prev = current;

            current = current.right;
        }
        return mindiff;
    }







    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(0);
        root.right = new TreeNode(48);
        root.left.left = null;
        root.left.right = null;
        root.right.left = new TreeNode(12);
        root.right.right = new TreeNode(49);
        System.out.println(getMinimumDifference(root));
        System.out.println(getMinimumDifference1(root));
    }

}
