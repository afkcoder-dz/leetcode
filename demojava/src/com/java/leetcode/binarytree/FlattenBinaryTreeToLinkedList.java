package com.java.leetcode.binarytree;

import com.java.leetcode.objects.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class FlattenBinaryTreeToLinkedList {

    private static TreeNode prev;
    public static void flatten1(TreeNode root) {
        if(root == null) return;
        flatten1(root.right);
        flatten1(root.left);
        root.right = prev;
        root.left = null;
        prev = root;
    }

    public static void flatten0(TreeNode root) {
        Queue<TreeNode> q = preOrderTraversal(root, new LinkedList<>());
        TreeNode current;
        TreeNode prev = root;
        q.poll();
        while(!q.isEmpty()){
           current = q.poll();
           prev.right = current;
           prev.left = null;
           prev = current;
        }

    }

     public  static Queue<TreeNode> preOrderTraversal(TreeNode root, Queue<TreeNode> q) {
         if(root == null) return q;
         q.offer(root);
         preOrderTraversal(root.left, q);
         preOrderTraversal(root.right,q);
         return q;
     }





    public static void main(String[] args) {
        TreeNode p = new TreeNode(1, new TreeNode(2,new TreeNode(3), new TreeNode(4)), new TreeNode(5,null,new TreeNode(6)));
        TreeNode.printBinaryTree(p);
       // flatten0(p);
        //TreeNode.printBinaryTree(p);
        flatten1(p);
        TreeNode.printBinaryTree(p);
    }

}
