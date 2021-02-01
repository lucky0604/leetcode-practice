package com.fastdata.algorithm.easy.linked_list;

/**
 * @Author: Lucky
 * @Description: https://leetcode.com/problems/linked-list-cycle/
 * @Date: create in 1/7/21 - 12:09 PM
 */
public class LinkedListCycle {
    public static void main(String[] args) {

    }

    private static boolean hasCycle(ListNode head) {
        /**
         * 基本思路：
         * 遍历 如果遇到null，则一定不是环形链表
         * 遍历 如果遇到之前重复的node，则一定是环形链表
         */
        // 只有一个节点或没有节点，不可构成环形节点
        if (head == null || head.next == null) {
            return false;
        }
        ListNode A = head;
        ListNode B = head.next;
        while (A != null && B != null) {
            if (A == B) {
                return true;
            }
            A = A.next;     // head.next    慢指针，按索引依次循环
            B = B.next;     // head.next.next   快指针，按索引跳格循环
            if (B != null) {    // 如果不是环形列表，快指针一定会先遇到null
                B = B.next;
            } else {
                return false;
            }
        }
        return false;
    }
}
