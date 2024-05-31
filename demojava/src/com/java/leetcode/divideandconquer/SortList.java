package com.java.leetcode.divideandconquer;


import com.java.leetcode.objects.ListNode;

public class SortList {
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode middle = findMiddle(head);
        ListNode right = middle.next;
        middle.next = null;

        ListNode sortedLeft = sortList(head);
        ListNode sortedRight = sortList(right);

        return mergeSortedList(sortedLeft, sortedRight);
    }


    private ListNode findMiddle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    private ListNode mergeSortedList(ListNode left, ListNode right) {
        ListNode dummy = new ListNode(-1);
        ListNode current = dummy;

        while (left != null && right != null) {
            if (left.val < right.val) {
                current.next = left;
                left = left.next;
            } else {
                current.next = right;
                right = right.next;
            }
            current = current.next;
        }

        if (left != null) {
            current.next = left;
        } else {
            current.next = right;
        }

        return dummy.next;
    }


    public static void main(String[] args) {
        // Example usage
        ListNode head = new ListNode(4, new ListNode(2, new ListNode(1, new ListNode(3))));

        SortList sorter = new SortList();
        ListNode sortedHead = sorter.sortList(head);

        // Print the sorted list
        while (sortedHead != null) {
            System.out.print(sortedHead.val + " ");
            sortedHead = sortedHead.next;
        }
    }
}

/**
 * Time Complexity:
 * O(nlogn)
 * <p>
 * Space Complexity:
 * O(logn)
 */