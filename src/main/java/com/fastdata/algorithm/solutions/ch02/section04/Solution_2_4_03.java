package com.fastdata.algorithm.solutions.ch02.section04;

import com.fastdata.algorithm.utils.ArrayUtil;


/**
 * @Author: lucky
 * @License: (C) Copyright
 * @Contact: lucky_soft@163.com
 * @Date: 2021-05-21 8:18 AM
 * @Version: 1.0
 * @description:
 **/

public class Solution_2_4_03<Key extends Comparable<Key>> {


    private Key[] priorityQueue;
    private int size = 0;

    public Solution_2_4_03(int size) {
        priorityQueue = (Key[]) new Comparable[size];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    // O(N)
    public void insert(Key key) {
        if (size == priorityQueue.length) {
            throw new RuntimeException("PriorityQueue is full");
        }

        int i = size - 1;
        while (i >= 0 && ArrayUtil.less(key, priorityQueue[i])) {
            priorityQueue[i + 1] = priorityQueue[i];
            i--;
        }
        priorityQueue[i + 1] = key;
        size++;
    }

    // O(1)
    public Key removeMax() {
        if (isEmpty()) {
            throw new RuntimeException("Priority queue underflow");
        }
        Key maxValue = priorityQueue[size - 1];
        priorityQueue[size - 1] = null;
        size--;
        return maxValue;
    }


}
