package com.fastdata.algorithm.solutions.ch02.section04;

import com.fastdata.algorithm.utils.ArrayUtil;

/**
 * @Author: lucky
 * @License: (C) Copyright
 * @Contact: lucky_soft@163.com
 * @Date: 2021-05-22 8:49 AM
 * @Version: 1.0
 * @description:
 **/

public class Solution_2_4_03_OrderedLinkedList<Key extends Comparable<Key>> {

    private class Node {
        Key key;
        Node next;
        Node previous;
    }

    private Node priorityQueue;
    private Node last;
    private int size = 0;

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    //O(N)
    public void insert(Key key) {
        // 0 or 1 element in the list
        if (size == 0 || ArrayUtil.less(key, priorityQueue.key)) {
            Node oldFirst = priorityQueue;

            priorityQueue = new Node();
            priorityQueue.key = key;
            priorityQueue.next = oldFirst;

            if (oldFirst != null) {
                oldFirst.previous = priorityQueue;
            }
            if (priorityQueue.next == null) {
                last = priorityQueue;
            }
        } else {
            Node current = priorityQueue;

            while (current.next != null && ArrayUtil.less(current.next.key, key)) {
                current = current.next;
            }

            Node newNode = new Node();
            newNode.key = key;
            newNode.next = current.next;
            current.next = newNode;
            newNode.previous = current;

            if (newNode.next == null) {
                last = newNode;
            } else {
                newNode.next.previous = newNode;
            }
        }
        size ++;
    }

    // O(1)
    public Key removeMax() {
        if (isEmpty()) {
            throw new RuntimeException("Priority queue underflow");
        }
        Key maxValue = last.key;

        last = last.previous;

        if (last != null) {
            last.next = null;
        }
        size --;
        return maxValue;
    }
}
