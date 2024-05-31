package com.java.leetcode.binarytree;

import com.java.leetcode.objects.TreeNode;

import java.util.Stack;

public class BSTIterator {
    private TreeNode current;
    Stack<TreeNode> stack;

    public BSTIterator(TreeNode root) {
       current = root;
       stack = new Stack<>();
    }

    public int next() {
        int result = Integer.MIN_VALUE;
        if(!stack.isEmpty() || current != null) {
            while (current != null) {
                stack.push(current);
                current = current.left;
            }
            current = stack.pop();
            result = current.val;
            current = current.right;
        }
        return result;
    }

    public boolean hasNext() {
        return !stack.isEmpty() || current != null;
    }


    public static void main(String[] args) {
        TreeNode root = new TreeNode(7, new TreeNode(3), new TreeNode(15,new TreeNode(9),new TreeNode(20)));
        BSTIterator bstIterator = new BSTIterator(root);
        System.out.println(bstIterator.next());
        System.out.println(bstIterator.next());
    }






}
