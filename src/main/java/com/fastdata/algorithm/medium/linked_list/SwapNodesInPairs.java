package com.fastdata.algorithm.medium.linked_list;

/**
 * @Author: Lucky
 * @Description: https://leetcode.com/problems/swap-nodes-in-pairs/
 * @Date: create in 2/7/21 - 12:33 PM
 */
public class SwapNodesInPairs {

    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode fast = head;
        ListNode slow;
        ListNode tmp;
        ListNode newStart = head.next;      // new start node
        while (true) {
            slow = fast.next;
            tmp = slow.next;
            slow.next = fast;       // swap
            if (tmp == null || tmp.next == null) {
                fast.next = tmp;
                break;
            }
            fast.next = tmp.next;
            fast = tmp;
        }
        return newStart;
    }
}
