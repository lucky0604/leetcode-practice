package com.fastdata.algorithm.solutions.ch02.section04;

import com.fastdata.algorithm.utils.ArrayUtil;

/**
 * @Author: lucky
 * @License: (C) Copyright
 * @Contact: lucky_soft@163.com
 * @Date: 6/1/21 11:21 AM
 * @Version: 1.0
 * @Description:
 **/

public class Solution_2_4_19_MaxPQ {

    private Comparable[] priorityQueue;

    Solution_2_4_19_MaxPQ(Comparable[] array) {
        priorityQueue = array;

        // Heapify - O(N)
        int startPosition = (array.length - 1) / 2;// position 0 is not used

        for (int i = startPosition; i >= 1; i --) {
            sink(i);
        }
    }

    private void sink(int index) {
        int indexOfBiggestChild;
        while (index * 2 < priorityQueue.length) {
            indexOfBiggestChild = index * 2;
            if (indexOfBiggestChild + 1 < priorityQueue.length && priorityQueue[indexOfBiggestChild].compareTo(priorityQueue[indexOfBiggestChild + 1]) < 0) {
                indexOfBiggestChild = indexOfBiggestChild + 1;
            }

            if (priorityQueue[index].compareTo(priorityQueue[indexOfBiggestChild]) < 0) {
                ArrayUtil.exchange(priorityQueue, index, indexOfBiggestChild);
            } else {
                break;
            }

            index = indexOfBiggestChild;
        }
    }

    Comparable[] getPriorityQueue() {
        return priorityQueue;
    }
}
