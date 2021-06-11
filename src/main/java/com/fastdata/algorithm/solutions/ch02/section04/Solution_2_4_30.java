package com.fastdata.algorithm.solutions.ch02.section04;

import com.fastdata.algorithm.utils.ArrayUtil;

/**
 * @Author: lucky
 * @License: (C) Copyright
 * @Contact: lucky_soft@163.com
 * @Date: 2021-06-11 1:37 PM
 * @Version: 1.0
 * @description:
 **/

public class Solution_2_4_30 {

    private class DynamicMedianFindingHeap<Key extends Comparable<Key>> {
        private PriorityQueueResize<Key> minPriorityQueue;
        private PriorityQueueResize<Key> maxPriorityQueue;

        private int size;

        DynamicMedianFindingHeap() {
            minPriorityQueue = new PriorityQueueResize<>(PriorityQueueResize.Orientation.MIN);
            maxPriorityQueue = new PriorityQueueResize<>(PriorityQueueResize.Orientation.MAX);
            size = 0;
        }

        // O(lg N)
        public void insert(Key key) {
            if (size == 0 || ArrayUtil.less(key, maxPriorityQueue.peek())) {
                maxPriorityQueue.insert(key);
            } else {
                minPriorityQueue.insert(key);
            }

            if (minPriorityQueue.size() > maxPriorityQueue.size() + 1) {
                Key keyToBeMoved = minPriorityQueue.deleteTop();
                maxPriorityQueue.insert(keyToBeMoved);
            } else if (maxPriorityQueue.size() > minPriorityQueue.size() + 1) {
                Key keyToBeMoved = maxPriorityQueue.deleteTop();
                minPriorityQueue.insert(keyToBeMoved);
            }

            size ++;
        }

        // O(1)
        public Key findTheMedian() {
            Key median;

            if (minPriorityQueue.size() > maxPriorityQueue.size()) {
                median = minPriorityQueue.peek();
            } else {
                median = maxPriorityQueue.peek();
            }

            return median;
        }

        // O(lg N)
        public Key deleteMedian() {
            Key median;
            if (minPriorityQueue.size() > maxPriorityQueue.size()) {
                median = minPriorityQueue.deleteTop();
            } else {
                median = maxPriorityQueue.deleteTop();
            }

            size --;
            return median;
        }
    }
}
