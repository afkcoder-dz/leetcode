package com.java.leetcode.binarytree;

import java.util.LinkedList;
import java.util.Queue;

public class PopulatingNextRightPointersInEachNode {

    // iterative
    public Node connect(Node root) {
        if(root == null) return null;
        Queue<Node> q = new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()) {
            Node next = null;
            int size = q.size();
            for(int i = 0; i < size; i++) {
                Node current = q.poll();
                current.next = next;
                next = current;
                if (current.right != null) {
                    q.offer(current.right);
                }
                if (current.left != null) {
                    q.offer(current.left);
                }
            }
        }
        return root;
    }

    public static void main(String[] args) {
        Node node1 = new Node(1);
        Node node2 = new Node(2,new Node(4), new Node(5),null);
        Node node3 = new Node(3,null,new Node(7),null);
        node1.left = node2;
        node1.right = node3;
        PopulatingNextRightPointersInEachNode test = new PopulatingNextRightPointersInEachNode();
        test.connect(node1);
    }









}

class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
}