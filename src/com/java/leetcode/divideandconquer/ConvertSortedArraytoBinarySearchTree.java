package com.java.leetcode.divideandconquer;

import com.java.leetcode.objects.TreeNode;

public class ConvertSortedArraytoBinarySearchTree {
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums == null || nums.length == 0) return null;
        return helper(nums, 0, nums.length - 1);
    }

    private TreeNode helper(int[] nums, int start, int end) {
        if(start > end) {
            return null;
        }
        int mid = (start + end) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = helper(nums, start, mid - 1);
        root.right = helper(nums, mid + 1, end);
        return root;
    }

    public static void main(String[] args) {
        ConvertSortedArraytoBinarySearchTree test = new ConvertSortedArraytoBinarySearchTree();
        TreeNode.printBinaryTree(test.sortedArrayToBST(new int[]{-10, -3, 0, 5, 9}));
    }
}
