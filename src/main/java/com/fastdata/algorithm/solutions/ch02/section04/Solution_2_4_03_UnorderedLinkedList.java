package com.fastdata.algorithm.solutions.ch02.section04;

import com.fastdata.algorithm.utils.ArrayUtil;

/**
 * @Author: lucky
 * @License: (C) Copyright
 * @Contact: lucky_soft@163.com
 * @Date: 2021-05-30 3:41 PM
 * @Version: 1.0
 * @description:
 **/

public class Solution_2_4_03_UnorderedLinkedList<Key extends Comparable<Key>> {
    private class Node {
        Key key;
        Node next;
    }

    private Node priorityQueue;
    private int size = 0;

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    // O(1)
    public void insert(Key key) {
        Node oldFirst = priorityQueue;
        priorityQueue = new Node();
        priorityQueue.key = key;
        priorityQueue.next = oldFirst;
        size ++;
    }

    // O(N)
    public Key removeMax() {
        if (isEmpty()) {
            throw new RuntimeException("Priority queue underflow");
        }

        Key maxValue = priorityQueue.key;

        Node currentNode = priorityQueue;
        currentNode = currentNode.next;

        // find out max value
        while (currentNode != null) {
            if (ArrayUtil.less(maxValue, currentNode.key)) {
                maxValue = currentNode.key;
            }
            currentNode = currentNode.next;
        }

        if (maxValue == priorityQueue.key) {
            // first element is the max value
            priorityQueue = priorityQueue.next;
        } else {
            currentNode = priorityQueue;
            while (currentNode.next.key != maxValue) {
                currentNode = currentNode.next;
            }
            if (currentNode.next.next == null) {
                currentNode.next = null;
            } else {
                currentNode.next = currentNode.next.next;
            }
        }
        size --;
        return maxValue;
    }
}
