package com.java.leetcode.binarytree;

import com.java.leetcode.objects.TreeNode;

import java.util.*;

public class ZigzagLevelOrderTraversal {
    public List<List<Integer>> zigzagLevelOrder1(TreeNode root) {
        List<List<Integer>> result = new LinkedList<>();
        if (root == null) return result;

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        boolean leftToRight = true;

        while (!q.isEmpty()) {
            int levelSize = q.size();
            List<Integer> levelValues = new LinkedList<>();

            for (int i = 0; i < levelSize; i++) {
                TreeNode node = q.poll();
                if (node != null) {
                    if (leftToRight) {
                        levelValues.add(node.val);
                    } else {
                        levelValues.add(0, node.val);
                    }

                    if (node.left != null) {
                        q.offer(node.left);
                    }
                    if (node.right != null) {
                        q.offer(node.right);
                    }
                }
            }
            leftToRight = !leftToRight;
            result.add(levelValues);
        }
        return result;
    }

    public List<List<Integer>> zigzagLevelOrder2(TreeNode root) {
        List<List<Integer>> result = new LinkedList<>();
        if (root == null) return result;

        Stack<TreeNode> currentLevelStack = new Stack<>();
        Stack<TreeNode> nextLevelStack = new Stack<>();

        currentLevelStack.push(root);
        boolean leftToRight = true;

        while (!currentLevelStack.isEmpty()) {
            List<Integer> levelValues = new LinkedList<>();
            while (!currentLevelStack.isEmpty()) {
                TreeNode node = currentLevelStack.pop();
                levelValues.add(node.val);

                if (leftToRight) {
                    if (node.left != null) {
                        nextLevelStack.push(node.left);
                    }
                    if (node.right != null) {
                        nextLevelStack.push(node.right);
                    }
                } else {

                    if (node.right != null) {
                        nextLevelStack.push(node.right);
                    }
                    if (node.left != null) {
                        nextLevelStack.push(node.left);
                    }
                }
            }
            result.add(levelValues);
            leftToRight = !leftToRight;
            Stack<TreeNode> temp = currentLevelStack;
            currentLevelStack = nextLevelStack;
            nextLevelStack = temp;
        }
        return result;
    }




    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        ZigzagLevelOrderTraversal traversal = new ZigzagLevelOrderTraversal();
        List<List<Integer>> result = traversal.zigzagLevelOrder2(root);

        System.out.println("Zigzag Level Order Traversal: " + result);
    }
}


