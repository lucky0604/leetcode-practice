package com.fastdata.algorithm.medium.linked_list;

/**
 * @Author: Lucky
 * @Description: https://leetcode.com/problems/design-front-middle-back-queue/
 * @Date: create in 2/6/21 - 10:12 AM
 */
public class FrontMiddleBackQueue {

    int count;
    ListNode start;
    ListNode middle;
    ListNode last;

    public FrontMiddleBackQueue() {
        count = 0;
        // place holder for start, middle, last
        start = new ListNode(-1);
        middle = new ListNode(-1);
        last = new ListNode(-1);

        start.next = last;
        last.prev = start;
    }

    public void pushFront(int val) {
        ListNode node = new ListNode(val);
        // insert new node in between start and start.next
        node.next = start.next;
        node.prev = start;

        // fix start and start.next to connect the new node
        start.next.prev = node;
        start.next = node;

        count ++;
        if (count == 1) {
            middle = node;
        } else if (count % 2 == 0) {
            middle = middle.prev;
        }
    }

    public void pushMiddle(int val) {
        ListNode node = new ListNode(val);

        if (count == 0) {
            node.prev = start;
            node.next = last;

            last.prev = node;
            start.next = node;
        } else if (count % 2 == 0) {
            node.next = middle.next;
            node.prev = middle;
            middle.next.prev = node;
            middle.next = node;
        } else {
            node.prev = middle.prev;
            node.next = middle;
            middle.prev.next = node;
            middle.prev = node;
        }
        middle = node;
        count ++;
        return;
    }

    public void pushBack(int val) {
        ListNode node = new ListNode(val);

        node.prev = last.prev;
        node.next = last;

        last.prev.next = node;
        last.prev = node;

        count ++;
        if (count == 1) {
            middle = node;
        } else if (count % 2 != 0) {        // if count is odd then middle will be set to the right side of the new node
            middle = middle.next;
        }
    }

    public int popFront() {
        if (count == 0) return -1;
        int result = start.next.val;
        // remove the start.next for pop operation
        removeNode(start.next);
        count --;
        if (count % 2 != 0) {
            middle = middle.next;
        }
        return result;
    }

    public int popMiddle() {
        if (count == 0) return -1;
        int result = middle.val;

        removeNode(middle);
        if (count % 2 != 0) {
            middle = middle.prev;       // if count is odd then set middle to the left node
        } else {
            middle = middle.next;       // if count is even then set middle to the right node
        }
        count --;
        return result;
    }

    public int popBack() {
        if (count == 0) return -1;
        int result = last.prev.val;
        removeNode(last.prev);
        count --;
        if (count % 2 == 0) {
            middle = middle.prev;
        }
        return result;
    }

    private void removeNode(ListNode node) {
        node.next.prev = node.prev;
        node.prev.next = node.next;
    }

    class ListNode {
        int val;
        ListNode next;
        ListNode prev;
        ListNode(int val) {
            this.val = val;
        }
    }
}
