package com.fastdata.algorithm.easy.linked_list;

/**
 * @Author: Lucky
 * @Description: https://leetcode.com/problems/remove-linked-list-elements/
 * @Date: create in 1/7/21 - 1:21 PM
 */
public class RemoveLinkedListElements {
    public static void main(String[] args) {

    }

    private static ListNode removeElements(ListNode head, int val) {
        ListNode dummyHead = new ListNode(0);       // 虚拟头节点，这样才能删除第一个真实节点
        ListNode cur = dummyHead;
        cur.next = head;        // 将虚拟头结点指向真实的头节点
        while (cur != null && cur.next != null) {
            if (cur.next.val == val) {
                cur.next = cur.next.next;       // 删除操作，及当前节点的next指向下一个节点的next
            } else {
                cur = cur.next;
            }
        }
        return dummyHead.next;
    }
}
