package com.fastdata.algorithm.solutions.ch02.section04;

import com.fastdata.algorithm.utils.ArrayUtil;

/**
 * @Author: lucky
 * @License: (C) Copyright
 * @Contact: lucky_soft@163.com
 * @Date: 5/29/21 11:58 AM
 * @Version: 1.0
 * @Description:
 **/

public class Solution_2_4_03_UnorderedArray<Key extends Comparable<Key>> {

    private Key[] priorityQueue;
    private int size = 0;

    Solution_2_4_03_UnorderedArray(int size) {
        priorityQueue = (Key[]) new Comparable[size];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    // O(1)
    public void insert(Key key) {
        if (size == priorityQueue.length) {
            throw new RuntimeException("Priority Queue is full");
        }
        priorityQueue[size] = key;
        size ++;
    }

    // O(n)
    public Key removeMax() {
        if (isEmpty()) {
            throw new RuntimeException("Priority queue underflow");
        }

        int maxValueIndex = 0;
        for (int i = 1; i < size; i ++) {
            if (ArrayUtil.less(priorityQueue[maxValueIndex], priorityQueue[i])) {
                maxValueIndex = i;
            }
        }
        ArrayUtil.exchange(priorityQueue, maxValueIndex, size - 1);
        Key maxValue = priorityQueue[size - 1];
        priorityQueue[size - 1] = null;
        size --;
        return maxValue;
    }
}
