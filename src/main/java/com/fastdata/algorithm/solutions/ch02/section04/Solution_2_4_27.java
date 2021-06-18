package com.fastdata.algorithm.solutions.ch02.section04;

import com.fastdata.algorithm.utils.ArrayUtil;

/**
 * @Author: lucky
 * @License: (C) Copyright
 * @Contact: lucky_soft@163.com
 * @Date: 2021-06-07 11:39 AM
 * @Version: 1.0
 * @description:
 **/

public class Solution_2_4_27 {

    private class PriorityQueue<Key extends Comparable<Key>> {
        private Key[] priorityQueue;
        private int size = 0;

        private Key min;

        PriorityQueue(int size) {
            priorityQueue = (Key[]) new Comparable[size + 1];
        }

        public boolean isEmpty() {
            return size == 0;
        }

        public int size() {
            return size;
        }

        public void insert(Key key) {
            if (size != priorityQueue.length - 1) {
                size ++;

                if (min == null || ArrayUtil.less(key, min)) {
                    min = key;
                }
                priorityQueue[size] = key;
                swim(size);
            }
        }

        Key deleteMax() {
            if (size == 0) {
                throw new RuntimeException("Priority Queue underflow");
            }

            size --;

            Key max = priorityQueue[1];
            ArrayUtil.exchange(priorityQueue, 1, size + 1);
            if (max == min) {
                min = null;
            }
            priorityQueue[size + 1] = null;
            sink(1);
            return max;
        }

        private void swim(int index) {
            while (index / 2 >= 1 && ArrayUtil.less(priorityQueue[index / 2], priorityQueue[index])) {
                ArrayUtil.exchange(priorityQueue, index / 2, index);
                index = index / 2;
            }
        }

        private void sink(int index) {
            while (index * 2 <= size) {
                int selectedChildIndex = index * 2;
                if (index * 2 + 1 <= size && ArrayUtil.less(priorityQueue[index * 2], priorityQueue[index * 2 + 1])) {
                    selectedChildIndex = index * 2 + 1;
                }
                if (ArrayUtil.more(priorityQueue[selectedChildIndex], priorityQueue[index])) {
                    ArrayUtil.exchange(priorityQueue, index, selectedChildIndex);
                } else {
                    break;
                }

                index = selectedChildIndex;
            }
        }

        public Key min() {
            return min;
        }
    }
}
