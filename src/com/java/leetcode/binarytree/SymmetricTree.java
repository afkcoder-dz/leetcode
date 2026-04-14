package com.java.leetcode.binarytree;

import com.java.leetcode.objects.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class SymmetricTree {


    // recursive
    public static boolean isSymmetric(TreeNode node) {
        if (node == null) return false;
        return isSymmetric(node.left, node.right);
    }

    public static boolean isSymmetric(TreeNode node1, TreeNode node2) {
        if (node1 == null & node2 == null) return true;
        if (node1 == null || node2 == null) return false;
        if (node1.val != node2.val) {
            return false;
        } else {
            return isSymmetric(node1.left, node2.right) && isSymmetric(node1.right, node2.left);
        }
    }

    // non-recursive
    public static boolean isSymmetric1(TreeNode node) {
        if (node == null) return false;
        Stack<TreeNode> stack = new Stack<>();
        stack.add(node.left);
        stack.add((node.right));

        while (!stack.isEmpty()) {
            TreeNode n1 = stack.pop();
            TreeNode n2 = stack.pop();
            if (n1 == null & n2 == null) continue;
            if (n1 == null || n2 == null || n1.val != n2.val) return false;
            stack.push(n1.left);
            stack.push(n2.right);
            stack.push(n1.right);
            stack.push(n2.left);
        }
        return true;
    }


    public static boolean isSymmetric0(TreeNode node) {
        if (node == null) return false;
        List<Integer> result1 = new ArrayList<>();
        List<Integer> result2 = new ArrayList<>();
        return rootLeftRightTraversal(node, result1).equals(rootRightLeftTraversal(node, result2));
    }


    public static List<Integer> rootLeftRightTraversal(TreeNode root, List<Integer> result) {
        if (root == null) {
            result.add(null);
        } else {
            result.add(root.val);
            rootLeftRightTraversal(root.left, result);
            rootLeftRightTraversal(root.right, result);
        }

        return result;
    }

    public static List<Integer> rootRightLeftTraversal(TreeNode root, List<Integer> result) {
        if (root == null) {
            result.add(null);
        } else {
            result.add(root.val);
            rootRightLeftTraversal(root.right, result);
            rootRightLeftTraversal(root.left, result);
        }
        return result;
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        node1.left = new TreeNode(2, new TreeNode(3), new TreeNode(4));
        node1.right = new TreeNode(2, new TreeNode(4), new TreeNode(3));
        System.out.println(isSymmetric0(node1));

        TreeNode node2 = new TreeNode(1);
        node2.left = new TreeNode(2, null, new TreeNode(3));
        node2.right = new TreeNode(2, null, new TreeNode(3));

        System.out.println(isSymmetric0(node2));

        System.out.println(isSymmetric(node1));
        System.out.println(isSymmetric(node2));
        System.out.println(isSymmetric1(node1));
        System.out.println(isSymmetric1(node2));
    }


}
