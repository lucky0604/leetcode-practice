package com.fastdata.algorithm.medium.linked_list;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Stack;

/**
 * @Author: Lucky
 * @Description: https://leetcode.com/problems/odd-even-linked-list/
 * @Date: create in 2/4/21 - 10:01 AM
 */
public class OddEvenLinkedList {
    public ListNode oddEvenList(ListNode head) {
        if (head == null) return null;
        ListNode evenNode = head.next;
        ListNode oddList = head;
        ListNode evenList = evenNode;
        while (oddList != null && oddList.next != null && oddList.next.next != null && evenList != null && evenList.next != null) {
            // connecting odd nodes to each other;
            oddList.next = oddList.next.next;
            oddList = oddList.next;

            // connecting even nodes to each other
            evenList.next = evenList.next.next;
            evenList = evenList.next;
        }

        if (evenList != null) {
            evenList.next = null;
        }
        oddList.next = evenNode;
        return head;
    }
}
