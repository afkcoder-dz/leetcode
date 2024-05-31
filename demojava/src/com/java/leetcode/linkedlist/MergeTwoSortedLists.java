package com.java.leetcode.linkedlist;

/**
 * Example 1:
 * <p>
 * Input: list1 = [1,2,4], list2 = [1,3,4]
 * Output: [1,1,2,3,4,4]
 * <p>
 * Example 2:
 * <p>
 * Input: list1 = [], list2 = []
 * Output: []
 * Example 3:
 * <p>
 * Input: list1 = [], list2 = [0]
 * Output: [0]
 */
public class MergeTwoSortedLists {


    // time complexity O(m+n)
    // space complexity  O(1)
    public ListNode mergeTwoLists0(ListNode list1, ListNode list2) {

        ListNode head = new ListNode(0); // Important!!

        ListNode mergedList = head;
        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                mergedList.next = list1;
                list1 = list1.next;
            } else {
                mergedList.next = list2;
                list2 = list2.next;
            }
            mergedList = mergedList.next;
        }
        if (list1 == null) {
            mergedList.next = list2;
        } else {
            mergedList.next = list1;
        }

        return head.next;
    }

    /**
     * Use recursion
     */

    // This solution will result into Stack overflow error with some-thousand elements input.
    // time complexity O(m+n) * count the total recursive calls
    public ListNode mergeTwoLists1(ListNode list1, ListNode list2) {

         if(list1 == null) {
             return list2;
         }
         if(list2 == null) {
             return list1;
         }
         if(list1.val <= list2.val) {
             list1.next = mergeTwoLists1(list1.next, list2);
             return list1;
         } else {
            list2.next = mergeTwoLists1(list1, list2.next);
            return list2;
         }
    }
}
