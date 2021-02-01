package com.fastdata.algorithm.easy.sort.heap_sort;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * @Author: Lucky
 * @Description: https://leetcode.com/problems/sort-array-by-increasing-frequency/
 * @Date: create in 1/22/21 - 10:18 AM
 */
public class SortArrayByIncreasingFrequency {

    public int[] frequencySort(int[] nums) {
        // track of the occurrence of each number in a map
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i ++) {
            int number = nums[i];
            map.put(number, map.getOrDefault(number, 0) + 1);
        }

        // keep the map entry with lesser value at the top(min heap)
        PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>(new Comparator<Map.Entry<Integer, Integer>>() {
            @Override
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                return (o1.getValue() == o2.getValue()) ? o2.getKey() - o1.getKey(): o1.getValue() - o2.getValue();
            }
        });

        // put the values in the min heap
        for (Map.Entry<Integer, Integer> entry: map.entrySet()) {
            pq.offer(entry);
        }

        /**
         * the map entries in this order in the min heap {3,1} {1, 2} {2, 3}
         * put the number in the returned array based on the number of times it occurs
         */
        int j = 0;
        while (!pq.isEmpty()) {
            Map.Entry<Integer, Integer> entry = pq.poll();
            for (int i = 0; i < entry.getValue(); i ++) {
                nums[j ++] = entry.getKey();
            }
        }
        return nums;
    }
}
