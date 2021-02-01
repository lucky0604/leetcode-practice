package com.fastdata.algorithm.easy.linked_list;

/**
 * @Author: Lucky
 * @Description: https://leetcode.com/problems/reverse-linked-list/
 * @Date: create in 1/6/21 - 11:52 AM
 */
public class ReverseLinkedList {
    public static void main(String[] args) {

    }

    private static ListNode reverseList(ListNode node) {
        /**
         * recursive
         */
//        if (node == null) return null;
//        if (node.next == null) return node;
//
//        ListNode newHead = reverseList(node.next);
//        node.next.next = node;
//        node.next = null;
//        return newHead;
        if (node == null || node.next == null) return node;
        ListNode newNode = null;
        while (node != null) {
            ListNode tmp = node.next;
            node.next = newNode;
            newNode = node;
            node = tmp;
        }
        return newNode;
    }
}
