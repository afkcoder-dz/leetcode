package com.java.leetcode.binarytree;

import com.java.leetcode.objects.TreeNode;

import java.util.*;

public class BinaryTreeRightSideView {

    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            TreeNode lastNode = null;

            for (int i = 0; i < levelSize; i++) {
                TreeNode current = queue.poll();
                lastNode = current;

                if (current.left != null) { // this ensures every node in the queue is non-null
                    queue.add(current.left);
                }
                if (current.right != null) {
                    queue.add(current.right);
                }
            }
            // Add the last node of the current level to the result
            result.add(lastNode.val);
        }
        return result;
    }

    public List<Integer> rightSideView1(TreeNode root) {
        List<Integer> result = new LinkedList<>();
        DFS(root, 0, result);
        return result;

    }

    public void DFS(TreeNode root, int depth, List<Integer> result){
        if(root == null){
            return;
        }
        if(depth == result.size()){
            result.add(root.val);
        }
        DFS(root.right, depth + 1, result);
        DFS(root.left, depth + 1, result);
    }











    public List<Integer> rightSideView0(TreeNode root) {
        List<Integer> result = new LinkedList<>();
        if (root == null) return result;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while (!q.isEmpty()) {
            int size = q.size();
            Stack<TreeNode> stack = new Stack<>();
            for (int i = 0; i < size; i++) {
                TreeNode node = q.poll();
                // Add the first node of the level to the result
                /* if (i == 0) {
                    result.add(current.val);
                } */
                stack.push(node);
                if (node.left != null) {
                    q.offer(node.left);
                }
                if (node.right != null) {
                    q.offer(node.right);
                }
            }
            TreeNode rightestNodeInLevel = stack.pop();
            result.add(rightestNodeInLevel.val);
        }
        return result;
    }
}
