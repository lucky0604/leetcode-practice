package com.fastdata.algorithm.medium.linked_list;

import java.util.Stack;

/**
 * @Author: Lucky
 * @Description: https://leetcode.com/problems/flatten-a-multilevel-doubly-linked-list/
 * @Date: create in 2/4/21 - 10:55 AM
 */
// TODO: to be understand
public class FlattenAMultilevelDoublyLinkedList {
    public Node flattern(Node head) {
        if (head == null) return head;
        Stack<Node> stack = new Stack<>();
        Node tmp = head;
        while (tmp != null) {
            if (tmp.child != null) {
                if (tmp.next != null) {
                    stack.push(tmp.next);
                }
                tmp.next = tmp.child;
                tmp.child.prev = tmp;
                tmp.child = null;
            }

            if (tmp.next == null) {
                break;
            }
            tmp = tmp.next;
        }

        while (!stack.isEmpty()) {
            Node node = stack.pop();
            tmp.next = node;
            node.prev = tmp;
            tmp = tmp.next;
            while (tmp.next != null) {
                tmp = tmp.next;
            }
        }
        return head;
    }
}
