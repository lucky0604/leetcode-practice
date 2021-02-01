package com.fastdata.algorithm.easy.linked_list;

/**
 * @Author: Lucky
 * @Description: https://leetcode.com/problems/delete-node-in-a-linked-list/
 * @Date: create in 1/6/21 - 10:23 AM
 */
public class DeleteNodeInALinkedList {
    public static void main(String[] args) {

    }

    private static void deleteNode(ListNode node) {
        // 1, 将当前node的值更新为下一个node的值
        node.val = node.next.val;
        // 2, 定义一个temp node用来缓存当前node的next指针
        ListNode temp = node.next;
        // 3, 将当前node的next指针指向下一个node的next指针
        node.next = node.next.next;
        // 4, 将缓存的temp next指针设置为null
        temp.next = null;
    }
}