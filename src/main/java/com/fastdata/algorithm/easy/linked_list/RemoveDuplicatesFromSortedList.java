package com.fastdata.algorithm.easy.linked_list;

/**
 * @Author: Lucky
 * @Description: https://leetcode.com/problems/remove-duplicates-from-sorted-list/
 * @tips: 根据题意，重复的元素一定是相邻的
 * @Date: create in 1/7/21 - 10:03 AM
 */
public class RemoveDuplicatesFromSortedList {

    public static void main(String[] args) {

    }

    private static ListNode deleteDuplicates(ListNode head) {
        /**
         * 基本思路：
         * 发现值相同则删除，temp.next = temp.next.next
         * 不同则下移 temp = temp.next
         */
        if (head == null) return null;
        // 定义真正的头节点
        ListNode temp = head;
        // 最后一个节点指向null, head只需移动至倒数第二个节点即可
        while (temp != null && temp.next != null) {
            if (temp.val != temp.next.val) {
                temp = temp.next;
            } else {
                temp.next = temp.next.next;
            }
        }
        // 返回头节点及返回整个链表
        return head;
    }
}
