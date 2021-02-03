package com.fastdata.algorithm.medium.linked_list;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @Author: Lucky
 * @Description: https://leetcode.com/problems/next-greater-node-in-linked-list/
 * @Date: create in 2/3/21 - 11:05 AM
 */
// TODO: to be understand
public class NextGreaterNodeInLinkedList {
    public int[] nextLargerNodes(ListNode head) {
        Map<ListNode, Integer> map = new HashMap<>();
        Stack<ListNode> stack = new Stack<>();

        ListNode curr = head;
        int count = 0;
        while (curr != null) {
            map.put(curr, count ++);
            curr = curr.next;
        }
        int[] ret = new int[count];
        curr = head;

        // main logic
        while (curr != null) {
            while (!stack.isEmpty() && stack.peek().val < curr.val) {
                ListNode pop = stack.pop();
                ret[map.get(pop)] = curr.val;
            }
            stack.push(curr);
            curr = curr.next;
        }

        while (!stack.isEmpty()) {
            ListNode pop = stack.pop();
            ret[map.get(pop)] = 0;
        }
        return ret;
    }
}
