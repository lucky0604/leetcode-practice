package com.fastdata.algorithm.easy.linked_list;

/**
 * @Author: Lucky
 * @Description: https://leetcode.com/problems/convert-binary-number-in-a-linked-list-to-integer/
 * @Date: create in 1/5/21 - 12:17 PM
 */
public class ConvertBinaryNumberInALinkedListToInteger {

    public static void main(String[] args) {

    }

    private static int getDecimalValue(ListNode head) {
        int ret = 0;
        while (head != null) {
            /**
             * 利用左移操作符
             * 初始ret为0，在内存中即为：00000..00000
             * << 1，即左移1位，在内存中仍为：00000...00000
             * 当head = [1,0,1]时，第一次循环
             * ret += 1
             * 左移一位后变为00000...00001
             * 第二次循环先左移一位变为00000...00010
             * 然后加上0，变为00000.00010
             * 第三次循环先左移一位变为00000...00100
             * 然后加上1，变为00000...00101
             */
            ret = ret << 1;         // 等价于 res = res * 2
            ret += head.val;
            head = head.next;
        }
        return ret;
    };
}

class ListNode {
    int val;
    ListNode next;
    ListNode() {};

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
