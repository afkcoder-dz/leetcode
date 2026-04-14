package com.java.leetcode.linkedlist;

public class RemoveDuplicatesfromSortedList {

    public ListNode deleteDuplicates(ListNode head) {
        ListNode current = head;
         while(current.next != null) {
             if(current.next.val == current.val){
                 current.next = current.next.next;
             }else {
                 current = current.next;
             }
         }

        return head;
    }

}
