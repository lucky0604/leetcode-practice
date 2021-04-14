package com.fastdata.algorithm.solutions.ch02.section02;

import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

/**
 * @ClassName: Solution_2_2_15
 * @Description: TODO
 * @Create by: lucky
 * @Date: 4/14/21 11:57 AM
 */

public class Solution_2_2_15 {

    public static void main(String[] args) {
        Comparable[] arr = generateRandomArray(10);
        Queue<Queue<Comparable>> mergedQueue = bottomUpQueueMergedSort(arr);
        StdOut.println("");
        for (Comparable v: mergedQueue.peek()) {
            StdOut.println(v + " ");
        }
    }

    private static Comparable[] generateRandomArray(int arrLength) {
        Comparable[] arr = new Comparable[arrLength];
        for (int i = 0; i < arrLength; i ++) {
            arr[i] = StdRandom.uniform();
        }
        return arr;
    }

    private static Queue<Queue<Comparable>> bottomUpQueueMergedSort(Comparable[] arr) {
        Queue<Queue<Comparable>> sortedQueue = new Queue<>();
        for (Comparable v: arr) {
            Queue<Comparable> queue = new Queue<>();
            queue.enqueue(v);
            sortedQueue.enqueue(queue);
        }

        while (sortedQueue.size() > 1) {
            Queue<Comparable> q1 = sortedQueue.dequeue();
            Queue<Comparable> q2 = sortedQueue.dequeue();
            Queue<Comparable> mergedQueue = Solution_2_2_14.mergedQueue(q1, q2);
            sortedQueue.enqueue(mergedQueue);
        }
        return sortedQueue;
    }
}
