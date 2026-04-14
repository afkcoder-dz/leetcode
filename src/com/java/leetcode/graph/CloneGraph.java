package com.java.leetcode.graph;


import java.util.*;


class Node {
    public int val;
    public List<Node> neighbors;

    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }

    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }

    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}

public class CloneGraph {

    public Node cloneGraph(Node node) {
        Map<Integer, Node> existedNodeMap = new HashMap<>();
        return dfsClone(node, existedNodeMap);
    }

    private Node dfsClone(Node node, Map<Integer, Node> existedNodeMap) {
        if (node == null) return null;

        if (existedNodeMap.containsKey(node.val)) {
            return existedNodeMap.get(node.val);
        }
        Node cloneNode = new Node(node.val);
        existedNodeMap.put(cloneNode.val, cloneNode);
        for (Node n : node.neighbors) {
            cloneNode.neighbors.add(dfsClone(n, existedNodeMap));
        }
        return cloneNode;
    }


    public Node cloneGraph1(Node node) {
        if (node == null) return null;
        Node newNode = new Node(node.val);
        Map<Node, Node> nodeMap = new HashMap<>();
        nodeMap.put(node, newNode);
        Queue<Node> queue = new LinkedList<>();
        queue.offer(node);

        while(!queue.isEmpty()){
            Node originalNode = queue.poll();
            for (Node origNeighbor : originalNode.neighbors) {
                if(!nodeMap.containsKey(origNeighbor)) {
                    Node newNeighborNode = new Node(origNeighbor.val);
                    nodeMap.put(origNeighbor, newNeighborNode);
                    queue.offer(origNeighbor);
                }
                nodeMap.get(originalNode).neighbors.add(nodeMap.get(origNeighbor));
            }
        }
        return newNode;
    }

}
