package com.fastdata.algorithm.medium.sort;

import com.fastdata.algorithm.medium.linked_list.ListNode;

import java.util.List;

/**
 * @Author: Lucky
 * @Description: https://leetcode.com/problems/sort-list/
 * @Date: create in 4/1/21 - 10:32 AM
 */
public class SortList {

    // use merge sort

    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode mid = getMid(head);
        ListNode secondHead = mid.next;
        // split the list
        mid.next = null;
        ListNode l = sortList(head);
        ListNode r = sortList(secondHead);
        return merge(l, r);
    }

    private static ListNode merge(ListNode l, ListNode r) {
        ListNode dummy = new ListNode(0);   // result listnode
        ListNode cur = dummy;
        while (l != null && r != null) {
            if (l.val > r.val) {
                cur.next = r;
                r = r.next;
            } else {
                cur.next = l;
                l = l.next;
            }
            cur = cur.next;
        }
        if (l != null) cur.next = l;
        if (r != null) cur.next = r;
        return dummy.next;
    }

    private static ListNode getMid(ListNode head) {
        // use slow and fast pointer for selecting the mid node
        ListNode fast = head;
        ListNode slow = fast;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
}
