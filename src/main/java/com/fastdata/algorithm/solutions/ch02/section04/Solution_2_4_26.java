package com.fastdata.algorithm.solutions.ch02.section04;

import com.fastdata.algorithm.utils.ArrayUtil;

/**
 * @Author: lucky
 * @License: (C) Copyright
 * @Contact: lucky_soft@163.com
 * @Date: 2021-06-06 8:35 PM
 * @Version: 1.0
 * @description:
 **/

public class Solution_2_4_26 {

    private enum Orientation {
        MIN, MAX;
    }

    private class PriorityQueue<Key extends Comparable<Key>> {
        private Key[] priorityQueue;
        private int size = 0;
        private Orientation orientation;

        PriorityQueue(int size, Orientation orientation) {
            priorityQueue = (Key[]) new Comparable[size + 1];
            this.orientation = orientation;
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

                priorityQueue[size] = key;
                swim(size);
            }
        }

        Key deleteTop() {
            if (size == 0) {
                throw new RuntimeException("Priority Queue underflow");
            }

            size -- ;

            Key topElement = priorityQueue[1];
            ArrayUtil.exchange(priorityQueue, 1, size + 1);

            priorityQueue[size + 1] = null;
            sink(1);

            return topElement;
        }

        private void swim(int index) {
            Key aux = priorityQueue[index];
            boolean exchangeRequired = false;

            while (index / 2 >= 1) {
                if ((orientation == Orientation.MAX && ArrayUtil.less(priorityQueue[index / 2], aux)) ||
                        (orientation == Orientation.MIN && ArrayUtil.more(priorityQueue[index / 2], aux))) {
                    priorityQueue[index] = priorityQueue[index / 2];
                    exchangeRequired = true;
                } else {
                    break;
                }

                index = index / 2;
            }

            if (exchangeRequired) {
                priorityQueue[index] = aux;
            }
        }

        private void sink(int index) {
            Key aux = priorityQueue[index];
            while (index * 2 <= size) {
                int selectedChildIndex = index * 2;
                if (index * 2 + 1 <= size && (
                                (orientation == Orientation.MAX && ArrayUtil.less(priorityQueue[index * 2], priorityQueue[index * 2 + 1]))
                                || (orientation == Orientation.MIN && ArrayUtil.more(priorityQueue[index * 2], priorityQueue[index * 2 + 1]))
                        )) {
                    selectedChildIndex = index * 2 + 1;
                }

                if ((orientation == Orientation.MAX && ArrayUtil.more(priorityQueue[selectedChildIndex], aux))
                || (orientation == Orientation.MIN && ArrayUtil.less(priorityQueue[selectedChildIndex], aux))) {
                    priorityQueue[index] = priorityQueue[selectedChildIndex];
                } else {
                    break;
                }

                index = selectedChildIndex;
            }

            // no need to check if an exchange is required
            // the value of index is only updated when an exchange happens
            priorityQueue[index] = aux;
        }
    }
}
