package com.fastdata.algorithm.medium.linked_list;

import java.util.Stack;

/**
 * @Author: Lucky
 * @Description: https://leetcode.com/problems/add-two-numbers-ii/
 * @Date: create in 2/5/21 - 9:52 AM
 */
public class AddTwoNumbersII {

    public static void main(String[] args) {
        System.out.println(13 % 10);
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode res = null;
        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();
        while (l1 != null || l2 != null) {
            if (l1 != null) {
                stack1.push(l1.val);
                l1 = l1.next;
            }
            if (l2 != null) {
                stack2.push(l2.val);
                l2 = l2.next;
            }
        }

        int carry = 0;
        while (!stack1.isEmpty() || !stack2.isEmpty()) {
            int sum = 0;
            if (!stack1.isEmpty()) {
                sum += stack1.pop();
            }
            if (!stack2.isEmpty()) {
                sum += stack2.pop();
            }
            sum += carry;
            carry = sum / 10;
            ListNode node = new ListNode(sum % 10);
            if (res != null) {
                // 从最后一位开始，res作为新的链表
                node.next = res;
            }
            res = node;
        }

        // 若carry = 1，则说明需要进一位
        if (carry == 1) {
            ListNode node = new ListNode(1);
            node.next = res;
            res = node;
        }
        return res;
    }
}
