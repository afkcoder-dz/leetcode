package com.java.leetcode.linkedlist;

import java.util.HashSet;
import java.util.Set;

public class LinkedListCycle {

    //Solution #0: Two-Pointer Method (Floyd's Cycle-Finding Algorithm)
    //Time Complexity: O(n) — In the worst-case scenario, each node is visited once.
    //Space Complexity: O(1) — Constant space is used.
   public static boolean hasCycle0(ListNode head){
       ListNode fast = head;
       ListNode slow = head;
       while (fast!= null && fast.next != null) {
           fast = fast.next.next;
           slow = slow.next;
           if(slow == fast) {
               return true;
           }
       }
       return false;
   }

   // Solution #1: Hash Table Method
   //Time Complexity: O(n) —  In the worst-case scenario, each node is visited once.
   //Space Complexity: O(n) — To store visited nodes.
    public static boolean hasCycle1(ListNode head){
       Set<ListNode> nodeCache = new HashSet<>();
        while (head!= null) {
            if(nodeCache.contains(head)) {
                return true;
            }
            nodeCache.add(head);
            head = head.next;
        }
        return false;
    }

    public static void main(String[] args) {

    }

}
