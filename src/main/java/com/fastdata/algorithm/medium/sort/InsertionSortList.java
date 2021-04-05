package com.fastdata.algorithm.medium.sort;

import com.fastdata.algorithm.medium.linked_list.ListNode;

/**
 * @Author: Lucky
 * @Description: https://leetcode.com/problems/insertion-sort-list/
 * @Date: created in 2021/4/4 - 21:58
 */
// TODO: to be understand
public class InsertionSortList {

    public ListNode insertionSortList(ListNode head) {
        if (head == null) return head;
        ListNode node = new ListNode(head.val);
        head = head.next;
        while (head != null) {
            ListNode prev = null, curr = node;
            while (curr != null && curr.val < head.val) {
                prev = curr;
                curr = curr.next;
            }
            ListNode tmp = new ListNode(head.val);
            if (prev == null) {
                tmp.next = curr;
                node = tmp;
            } else {
                prev.next = tmp;
                tmp.next = curr;
            }
            head = head.next;
        }
        return node;
    }
}
