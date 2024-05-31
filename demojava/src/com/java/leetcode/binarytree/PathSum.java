package com.java.leetcode.binarytree;

import com.java.leetcode.objects.TreeNode;

import java.util.Stack;

public class PathSum {


    // recursive
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) return false;
        if (root.left == null && root.right == null) return root.val == targetSum;
        return hasPathSum(root.left, targetSum - root.val) || hasPathSum(root.right, targetSum - root.val);
    }

    // non-recursive
    public boolean hasPathSum1(TreeNode root, int targetSum) {
        if (root == null) return false;
        Stack<TreeNode> path = new Stack<>();
        Stack<Integer> pathValue = new Stack<>();
        path.push(root);
        pathValue.push(root.val);
        while (!path.isEmpty()) {
            TreeNode node = path.pop();
            int tempValue = pathValue.pop();
            if (node.left == null && node.right == null && tempValue == targetSum) return true;
            if (node.left != null) {
                path.push(node.left);
                pathValue.push(node.left.val + tempValue);
            }
            if (node.right != null) {
                path.push(node.right);
                pathValue.push(node.right.val + tempValue);
            }
        }
        return false;
    }

    public boolean hasPathSum2(TreeNode root, int targetSum) {
        if (root == null) return false;
        Stack<NodeWithSum> stack = new Stack<>();
        stack.push(new NodeWithSum(root, root.val));
        while (!stack.isEmpty()) {
            NodeWithSum nodeWithSum = stack.pop();
            TreeNode currentNode = nodeWithSum.node;
            int currentSum = nodeWithSum.sum;
            if (currentNode.left == null && currentNode.right == null && currentSum == targetSum) return true;
            if (currentNode.right != null) {
                stack.push(new NodeWithSum(currentNode.right, currentSum + currentNode.right.val));
            }
            if (currentNode.left != null) {
                stack.push(new NodeWithSum(currentNode.left, currentSum + currentNode.left.val));
            }
        }
        return false;
    }


    private static class NodeWithSum {
        TreeNode node;
        int sum;

        public NodeWithSum(TreeNode node, int sum) {
            this.node = node;
            this.sum = sum;
        }
    }
}
