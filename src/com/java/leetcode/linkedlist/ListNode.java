package com.java.leetcode.linkedlist;

public class ListNode {
    int val;
    com.java.leetcode.linkedlist.ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    public static void printListNode(ListNode node){
        StringBuilder res = new StringBuilder();
        while(node != null){
            res.append(node.val);
            if(node.next != null){
                res.append(" -> ");
            }
            node = node.next;
        }
        System.out.println(res.toString());
    }

}
