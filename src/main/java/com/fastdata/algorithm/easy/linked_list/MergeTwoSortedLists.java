package com.fastdata.algorithm.easy.linked_list;

/**
 * @Author: Lucky
 * @Description: https://leetcode.com/problems/merge-two-sorted-lists/
 * @Date: create in 1/6/21 - 12:49 PM
 */
public class MergeTwoSortedLists {
    public static void main(String[] args) {

    }

    private static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) return null;
        // 先设置一个新链表的固定头结点
        ListNode temp = new ListNode(0);
        // 新链表的尾结点
        ListNode dump = temp;
        while (l1 != null && l2 != null) {
            if (l1.val > l2.val) {
                dump.next = l2;
                l2 = l2.next;
            } else {
                dump.next = l1;
                l1 = l1.next;
            }
            dump = dump.next;
        }
        if (l1 == null) {
            dump.next = l2;
        }
        if (l2 == null) {
            dump.next = l1;
        }
        // 返回新链表的头的next，因为新链表头固定为0
        return temp.next;
    }
}
