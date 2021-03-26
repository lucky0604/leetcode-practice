package com.fastdata.algorithm.medium.sort;

import java.util.*;

/**
 * @Author: Lucky
 * @Description: https://leetcode.com/problems/least-number-of-unique-integers-after-k-removals/
 * @Date: create in 3/26/21 - 10:11 AM
 */
public class FindLeastNumOfUniqueIntegersAfterKRemovals {
    public int findLeastNumOfUniqueInts(int[] arr, int k) {
        if (arr == null || arr.length == 0) return 0;
        if (k >= arr.length) return 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i ++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }
        PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>((a, b) -> a.getValue() - b.getValue());
        for (Map.Entry<Integer, Integer> item: map.entrySet()) {
            pq.offer(item);
        }
        while (k > 0) {
            Map.Entry<Integer, Integer> entry = pq.poll();
            if (entry.getValue() > k) {
                entry.setValue(entry.getValue() - k);
                k = entry.getValue() - k;
                pq.offer(entry);
            } else {
                k = k - entry.getValue();
            }
        }
        return pq.size();
    }
}
