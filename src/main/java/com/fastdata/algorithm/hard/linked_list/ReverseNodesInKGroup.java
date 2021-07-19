package com.fastdata.algorithm.hard.linked_list;

import com.fastdata.algorithm.medium.linked_list.ListNode;

/**
 * @Author: lucky
 * @License: (C) Copyright
 * @Contact: lucky_soft@163.com
 * @Date: 7/19/21 11:36 AM
 * @Version: 1.0
 * @Description: https://leetcode.com/problems/reverse-nodes-in-k-group/
 **/

public class ReverseNodesInKGroup {

    public ListNode reverseKGroup(ListNode head, int k) {
        // if k = 1, no need to reverse
        if (k == 1) {
            return head;
        }
        ListNode root = new ListNode(-1);
        root.next = head;
        int count = countNodes(head);
        int reverseCount = count / k;
        ListNode node = root;
        while (reverseCount > 0) {
            node = reverse(node, k);
            reverseCount --;
        }
        return root.next;
    }

    private ListNode reverse(ListNode head, int k) {
        ListNode curr = head.next;
        ListNode tail = null;
        ListNode reversed = null;

        while (k > 0 && curr != null) {
            ListNode newNode = curr.next;
            curr.next = reversed;
            reversed = curr;
            curr = newNode;
            if (reversed.next == null) {
                tail = reversed;
            }
            k --;
        }

        tail.next = curr;
        head.next = reversed;
        return tail;
    }

    private int countNodes(ListNode head) {
        int count = 0;
        while (head != null) {
            count ++;
            head = head.next;
        }
        return count;
    }
}
