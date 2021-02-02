package com.fastdata.algorithm.medium.linked_list;

/**
 * @Author: Lucky
 * @Description: https://leetcode.com/problems/swapping-nodes-in-a-linked-list/
 * @Date: create in 2/2/21 - 10:49 AM
 */
public class SwappingNodesInALinkedList {
    public ListNode swapNodes(ListNode head, int k) {
        /**
         * 基本思路：
         * use two more pointers first and second, denoting the nodes for swapping
         *
         * 1，Put slow at head, and put fast k-1 nodes after slow.
         * 2，first = fast.
         * 3，If fast isn't already at the last node, move slow and fast one node further until fast.next == null
         * 4，second = slow
         * 5，Swap the values of first and second
         */
        if (head == null) return null;
        ListNode fast = head;
        ListNode slow = head;
        ListNode first = head;
        ListNode second = head;
        for (int i = 0; i < k - 1; ++ i) {
            fast = fast.next;
        }
        first = fast;
        while (fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }
        second = slow;

        // swap the values
        int tmp = first.val;
        first.val = second.val;
        second.val = tmp;
        return head;
    }

    private void reverseLinkedList(ListNode head) {
        if (head == null) return;
        ListNode prev = null;
        ListNode curr = head;
        ListNode next = null;
        // 最终循环完的条件是curr为null
        while (curr != null) {
            // 首先避免当前指针在指向上一指针后链表断开，因此需要先保存下来
            next = curr.next;
            /**
             * 核心算法
             * 1,将当前指针的next指向上一节点
             * 2,指向完上一节点后，prev和curr都需要进一位
             */
            curr.next = prev;
            prev = curr;
            curr = next;
        }
    }
}
