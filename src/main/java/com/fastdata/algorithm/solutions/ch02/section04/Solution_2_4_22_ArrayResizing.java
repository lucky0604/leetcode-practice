package com.fastdata.algorithm.solutions.ch02.section04;

import com.fastdata.algorithm.utils.ArrayUtil;

/**
 * @Author: lucky
 * @License: (C) Copyright
 * @Contact: lucky_soft@163.com
 * @Date: 6/2/21 11:47 AM
 * @Version: 1.0
 * @Description:
 **/

public class Solution_2_4_22_ArrayResizing<Key extends Comparable<Key>> {

    // heap-ordered complete binary tree
    private Key[] priorityQueue;

    // in priorityQueue[1..n] with pq[0] unused
    private int size = 0;

    int totalArrayAccesses;
    int totalArrayAccessesForInsert;
    int totalArrayAccessesForRemoveMaxium;

    int totalItemsInserted;
    int totalItemsRemoved;

    private Solution_2_4_22_ArrayResizing() {
        priorityQueue = (Key[]) new Comparable[2];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public void insert(Key key) {
        totalArrayAccesses = 0;
        totalItemsInserted ++;

        if (size == priorityQueue.length - 1) {
            resize(priorityQueue.length * 2, true);
        }

        size ++;

        priorityQueue[size] = key;
        totalArrayAccesses ++;
        totalArrayAccessesForInsert ++;

        swim(size);
    }

    public Key deleteMax() {
        totalArrayAccesses = 0;
        totalItemsRemoved ++;

        if (size == 0) {
            throw new RuntimeException("Priority queue under flow");
        }

        size --;

        Key max = priorityQueue[1];
        totalArrayAccesses ++;
        totalArrayAccessesForRemoveMaxium ++;

        ArrayUtil.exchange(priorityQueue, 1, size + 1);

        totalArrayAccesses += 4;
        totalArrayAccessesForRemoveMaxium += 4;

        priorityQueue[size + 1] = null;
        totalArrayAccesses ++;
        totalArrayAccessesForRemoveMaxium ++;

        sink(1);

        if (size == priorityQueue.length / 4) {
            resize(priorityQueue.length / 2, false);
        }
        return max;
    }

    private void swim(int index) {
        while (index / 2 >= 1) {
            totalArrayAccesses += 2;
            totalArrayAccessesForInsert += 2;
            if (ArrayUtil.less(priorityQueue[index / 2], priorityQueue[index])) {
                ArrayUtil.exchange(priorityQueue, index / 2, index);
                totalArrayAccesses += 4;
                totalArrayAccessesForInsert += 4;
            } else {
                break;
            }

            index = index / 2;
        }
    }

    private void sink(int index) {
        while (index * 2 <= size) {
            int highestChildIndex = index * 2;

            totalArrayAccesses += 2;
            totalArrayAccessesForRemoveMaxium += 2;
            if (index * 2 + 1 <= size && ArrayUtil.less(priorityQueue[index * 2], priorityQueue[index * 2 + 1])) {
                highestChildIndex = index * 2 + 1;
            }
            totalArrayAccesses += 2;
            totalArrayAccessesForRemoveMaxium += 2;
            if (ArrayUtil.more(priorityQueue[highestChildIndex], priorityQueue[index])) {
                ArrayUtil.exchange(priorityQueue, index, highestChildIndex);
                totalArrayAccesses += 4;
                totalArrayAccessesForRemoveMaxium += 4;
            } else {
                break;
            }
            index = highestChildIndex;
        }
    }

    private void resize(int newSize, boolean increasing) {
        Key[] newPriorityQueue = (Key[]) new Comparable[newSize];
        System.arraycopy(priorityQueue, 1, newPriorityQueue, 1, size);
        totalArrayAccesses += 2 * size;
        if (increasing) {
            totalArrayAccessesForInsert += 2 * size;
        } else {
            totalArrayAccessesForRemoveMaxium += 2 * size;
        }
        priorityQueue = newPriorityQueue;
    }
}
