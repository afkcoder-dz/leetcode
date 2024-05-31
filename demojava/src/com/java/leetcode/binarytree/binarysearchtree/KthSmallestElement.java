package com.java.leetcode.binarytree.binarysearchtree;

import com.java.leetcode.objects.TreeNode;

import java.util.Stack;

public class KthSmallestElement {
    int i = 0;
    int result = Integer.MIN_VALUE;

    public int kthSmallest(TreeNode root, int k) {
        if (root == null) return result;
        kthSmallest(root.left, k);
        if (++i == k ) {
            result = root.val;
        }
        kthSmallest(root.right, k);

        return result;
    }

    // iterative
    public int kthSmallest2(TreeNode root, int k) {
        int i = 0;
        int result = Integer.MIN_VALUE;
        if(root == null) return Integer.MIN_VALUE;
        Stack<TreeNode> stack = new Stack<>();

        while (!stack.isEmpty() || root != null) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if (++i == k) {
                result = root.val;
            }
            root = root.right;
        }
        return result;
    }


    public int kthSmallest3(TreeNode root, int k) {
        int count = countNodes(root.left);
        if (k <= count) {
            return kthSmallest(root.left, k);
        } else if (k > count + 1) {
            return kthSmallest(root.right, k-1-count); // 1 is counted as current node
        }

        return root.val;
    }

    public int countNodes(TreeNode n) {
        if (n == null) return 0;

        return 1 + countNodes(n.left) + countNodes(n.right);
    }


    public static void main(String[] args) {
        // Example binary tree represented as an array
        TreeNode root = new TreeNode(3, new TreeNode(1, null, new TreeNode(2)), new TreeNode(4));
        KthSmallestElement kthSmallestElement = new KthSmallestElement();
        System.out.println(kthSmallestElement.kthSmallest2(root, 1));
    }
}
