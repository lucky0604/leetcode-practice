package com.fastdata.algorithm.easy.heap;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @Author: Lucky
 * @Description: https://leetcode.com/problems/last-stone-weight/
 * @Date: create in 1/19/21 - 9:57 AM
 */
public class LastStoneWeight {
    public int lastStoneWeight(int[] stones) {
        // corner case
        if (stones.length == 0) return 0;
        Queue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        for (int stone: stones) {
            maxHeap.add(stone);
        }
        while (maxHeap.size() > 1) {
            maxHeap.offer(maxHeap.poll() - maxHeap.poll());
        }
        return maxHeap.poll();
    }
}
