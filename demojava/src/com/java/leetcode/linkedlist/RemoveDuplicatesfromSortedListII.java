package com.java.leetcode.linkedlist;

import com.java.leetcode.Utils;

import java.util.HashMap;
import java.util.Map;

public class RemoveDuplicatesfromSortedListII {
    public static void main(String[] args) {
        ListNode testNode = new ListNode(1,new ListNode(1, new ListNode(1, new ListNode(2, new ListNode(3)))));
        ListNode testNode1 = new ListNode(1,new ListNode(2, new ListNode(3, new ListNode(3, new ListNode(4, new ListNode(5))))));
        ListNode.printListNode(testNode1);
        ListNode.printListNode(deleteDuplicates(testNode1));
    }
    public static ListNode deleteDuplicates(ListNode head) {
        Map<Integer, Integer> count = new HashMap<>();

        ListNode current = head;
        ListNode prev = null;
        ListNode res = null;

        while (current != null) {
            count.put(current.val, count.getOrDefault(current.val, 0) + 1);
            current = current.next;
        }

        current = head;

        while (current != null) {
            if (count.get(current.val) == 1) {
                if (prev != null) {
                    prev.next = current;
                    prev = prev.next;
                } else {
                    prev = current;
                    res = prev;
                }

            }
            current = current.next;
        }
        return res;
    }

}
