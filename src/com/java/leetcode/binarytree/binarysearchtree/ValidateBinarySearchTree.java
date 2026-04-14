package com.java.leetcode.binarytree.binarysearchtree;

import com.java.leetcode.objects.TreeNode;

public class ValidateBinarySearchTree {
    private int prev = Integer.MIN_VALUE;
    private boolean result = true;
    private int count = 0;

    public boolean isValidBST(TreeNode root) {
        if (root == null) return false;
        isValidBST(root.left);
        count++;
        if (count > 1 && root.val <= prev) {
            result = false;
        }
        prev = root.val;
        isValidBST(root.right);
        return result;
    }

    public boolean isValidBS1(TreeNode root) {
        return isValidBSTHelper1(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public boolean isValidBSTHelper1(TreeNode root, long minVal, long maxVal) {
        if (root == null) return true;
        if (root.val >= maxVal || root.val <= minVal) return false;
        return isValidBSTHelper1(root.left, minVal, root.val) && isValidBSTHelper1(root.right, root.val, maxVal);
    }


    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(2147483647, new TreeNode(-2147483648), null);
        TreeNode node2 = new TreeNode(6, new TreeNode(3), new TreeNode(7));
        TreeNode node3 = new TreeNode(5, new TreeNode(4), node2);
        ValidateBinarySearchTree validateBinarySearchTree = new ValidateBinarySearchTree();
        //  System.out.println(validateBinarySearchTree.isValidBST(node1));
        System.out.println(validateBinarySearchTree.isValidBST(node3));
    }


}
