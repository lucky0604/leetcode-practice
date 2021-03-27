package com.fastdata.algorithm.medium.sort;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * @Author: Lucky
 * @Description: https://leetcode.com/problems/minimum-deletions-to-make-character-frequencies-unique/
 * @Date: create in 3/27/21 - 10:20 AM
 */
public class MinimumDeletionsToMakeCharacterFrequenciesUnique {

    public int minDeletions(String s) {
        // store the frequency in a map
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i ++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }

        // use max heap for sorting frequencies
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for (Map.Entry<Character, Integer> item: map.entrySet()) {
            pq.add(item.getValue());
        }
        int count = 0;
        while (pq.size() > 0) {
            int maxFrequency = pq.remove();
            if (pq.size() == 0) {
                return count;
            }
            if (maxFrequency == pq.peek()) {
                if (maxFrequency > 1) {
                    // decrease the frequencies
                    pq.add(maxFrequency - 1);
                }
                count ++;
            }
        }
        return count;
    }
}
