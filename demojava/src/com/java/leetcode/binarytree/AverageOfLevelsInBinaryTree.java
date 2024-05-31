package com.java.leetcode.binarytree;

import com.java.leetcode.objects.TreeNode;

import java.util.*;

public class AverageOfLevelsInBinaryTree {
    public static List<Double> averageOfLevels(TreeNode root) {
        if (root == null) return null;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        List<Double> result = new ArrayList<>();
        while (!queue.isEmpty()) {
            double currentLevelSum = 0;
            int currentLevelCount = queue.size();
            for (int i = 0; i < currentLevelCount; i++) {
                TreeNode current = queue.poll();
                currentLevelSum += current.val;
                if (current.left != null) queue.offer(current.left);
                if (current.right != null) queue.offer(current.right);
            }
            result.add(currentLevelSum / currentLevelCount);
        }
        return result;
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(5);
        node1.left = new TreeNode(2);
        node1.right = new TreeNode(-3);

        System.out.println(averageOfLevels(node1));


        TreeSet c= new TreeSet();

    }

}
