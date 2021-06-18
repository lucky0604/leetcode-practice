package com.fastdata.algorithm.medium.linked_list;

/**
 * @Author: lucky
 * @License: (C) Copyright
 * @Contact: lucky_soft@163.com
 * @Date: 2021-05-23 12:00 PM
 * @Version: 1.0
 * @description: https://leetcode.com/problems/reverse-linked-list-ii/
 **/

public class ReverseLinkedListII {

    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (left == right) {
            return head;
        }

        // create a dummy node to store the head
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        // initial left node, right node
        // create a pre-node to store old left node: pre.next = leftNode
        ListNode pre = dummy;
        ListNode leftNode = head;
        ListNode rightNode = head;

        // find the left node at the right position
        for (int i = 1; i < left; i ++) {
            pre = pre.next;
            leftNode = leftNode.next;
        }

        for (int i = 1; i < right; i ++) {
            rightNode = rightNode.next;
        }

        // while left node equals the right node, it will be done, so if they're not equal, loop the list
        while (leftNode != rightNode) {
            pre.next = leftNode.next;
            leftNode.next = rightNode.next;
            rightNode.next = leftNode;
            leftNode = pre.next;
        }

        return dummy.next;
    }
}
