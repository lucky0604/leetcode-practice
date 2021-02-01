package com.fastdata.algorithm.easy.heap;

import java.util.Optional;
import java.util.PriorityQueue;

/**
 * @Author: Lucky
 * @Description: https://leetcode.com/problems/kth-largest-element-in-a-stream/
 * @Date: create in 1/19/21 - 10:04 AM
 */
public class KthLargestElementInAStream {

    /**
     * 通过PriorityQueue，由于每次都是取最小元素，因此只需要保存前k个元素
     */

    private int k;
    private PriorityQueue<Integer> pq;
    public KthLargestElementInAStream(int k, int[] nums) {
        this.k = k;
        this.pq = new PriorityQueue<>();
        for (int i: nums) {
            pq.add(i);
            maintainKLength();
        }
    }

    public int add(int val) {
        pq.add(val);
        maintainKLength();
        return Optional.ofNullable(pq.peek()).orElse(-1);
    }

    private void maintainKLength() {
        if (pq.size() > k) {
            pq.poll();
        }
    }
}
