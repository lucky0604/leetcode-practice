package com.fastdata.algorithm.easy.linked_list;

/**
 * @Author: Lucky
 * @Description: https://leetcode.com/problems/palindrome-linked-list/
 * @Date: create in 1/7/21 - 12:43 PM
 */
public class PalindromeLinkedList {

    public static void main(String[] args) {

    }

    private static boolean isPalindrome(ListNode head) {
        ListNode pre = null;
        // 第一个节点
        ListNode cur = head;
        if (head == null || head.next == null) return true;
        // 找到最后一个节点，最后一个节点有一个特征，及next指针为空
        // while循环结束，cur node为最后一个节点
        while (cur.next != null) {
            // 遍历到最后一个节点，此时cur存到pre
            pre = cur;
            cur = cur.next;
        }
        // 若首尾不等，则不是回文链表
        if (head.val != cur.val) return false;
        ListNode next = head.next;
        // 若相等，则去掉首尾节点
        head.next = null;
        pre.next = null;

        return isPalindrome(next);
    }
}
