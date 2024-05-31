package com.java.leetcode.binarytree;

import com.java.leetcode.objects.TreeNode;

import java.util.Stack;

public class sumRootToLeafNumbers {

    // recursive DFS
    public int sumNumbers1(TreeNode root) {
        return sumNum(root, 0);
    }

    public int sumNum(TreeNode currentNode, int currentNum) {
        if (currentNode == null) return 0;
        currentNum = currentNum * 10 + currentNode.val;
        if (currentNode.left == null && currentNode.right == null) return currentNum;
        return sumNum(currentNode.left, currentNum) + sumNum(currentNode.right, currentNum);
    }

    // iterative pre-order traversal
    public int sumNumbers2(TreeNode root) {
        if (root == null) return 0;
        Stack<Pair> stack = new Stack<>();
        stack.push(new Pair(root, root.val));
        int totalSum = 0;

        while (!stack.isEmpty()) {
            Pair current = stack.pop();
            TreeNode currentNode = current.node;
            int currentNum = current.num;

            if (currentNode.left == null && currentNode.right == null) {
                totalSum += currentNum;
            }

            if (currentNode.right != null) {
                stack.push(new Pair(currentNode.right, currentNum * 10 + currentNode.right.val));
            }

            if (currentNode.left != null) {
                stack.push(new Pair(currentNode.left, currentNum * 10 + currentNode.left.val));
            }
        }
        return totalSum;
    }

    // iterative in-order traversal
    public static int sumNumbers3(TreeNode root) {
        {
            if (root == null) return 0;
            Stack<Pair> stack = new Stack<>();
            TreeNode current = root;
            int currentNum = 0;
            int totalSum = 0;

            while (!stack.isEmpty() || current != null) {
                // left first
                while (current != null) {
                    currentNum = currentNum * 10 + current.val;
                    stack.push(new Pair(current, currentNum));
                    current = current.left;
                }

                Pair currentPair = stack.pop();
                current = currentPair.node;
                currentNum = currentPair.num;
                // process current node
                if (current.left == null && current.right == null) {
                    totalSum += currentNum;
                }
                // turn to right subtree
                current = current.right;
            }
            return totalSum;
        }
    }

    // iterative post-order traversal
    public static int sumNumbers4(TreeNode root) {
        if (root == null) return 0;
        Stack<TreeNode> nodeStack = new Stack<>();
        Stack<Integer> numStack = new Stack<>();
        TreeNode current = root;
        TreeNode lastVisited = null;
        int currentNum = 0;
        int totalNum = 0;

        while (!nodeStack.isEmpty() || current != null) {
            while (current != null) {
                currentNum = currentNum * 10 + current.val;
                nodeStack.push(current);
                numStack.push(currentNum);
                current = current.left;
            }

            TreeNode topNode = nodeStack.peek();

            if (topNode.right != null && lastVisited != topNode.right) {
                current = topNode.right;
            } else {
                current = nodeStack.pop();
                currentNum = numStack.pop();
                if (current.left == null && current.right == null) {
                    totalNum += currentNum;
                }
                lastVisited = current;
                currentNum = currentNum/10;
                current = null;
            }
        }
        return totalNum;
    }


    static class Pair {
        TreeNode node;
        Integer num;

        public Pair(TreeNode node, Integer num) {
            this.node = node;
            this.num = num;
        }

    }


    public static void main(String[] args) {
        TreeNode root = new TreeNode(1, new TreeNode(2), new TreeNode(3));
        System.out.println(sumNumbers4(root));
        System.out.println(sumNumbers3(root));
    }

}
