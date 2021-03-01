package com.fastdata.algorithm.medium.heap;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @Author: Lucky
 * @Description: https://leetcode.com/problems/top-k-frequent-elements/
 * @Date: create in 3/1/21 - 10:09 AM
 */
public class TopKFrequentElements {

    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i ++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        Queue<Integer> pq = new PriorityQueue<>((p, q) -> map.get(q) - map.get(p));
        for (Integer i: map.keySet()) {
            pq.add(i);
        }
        int[] ret = new int[k];
        int index = 0;
        while (!pq.isEmpty() && index < k) {
            ret[index] = pq.poll();
            index ++;
        }
        return ret;
    }
}
