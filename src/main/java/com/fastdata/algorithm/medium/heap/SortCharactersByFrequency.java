package com.fastdata.algorithm.medium.heap;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @Author: Lucky
 * @Description: https://leetcode.com/problems/sort-characters-by-frequency/discuss/?currentPage=1&orderBy=hot&query=&tag=java
 * @Date: created in 2021/2/28 - 22:25
 */
public class SortCharactersByFrequency {
    public String frequencySort(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c: s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        Queue<Character> pq = new PriorityQueue<>((a, b) -> (map.get(b) - map.get(a)));
        for (char c: map.keySet()) {
            pq.add(c);
        }
        StringBuilder sb = new StringBuilder();
        while (!pq.isEmpty()) {
            char c = pq.peek();
            int count = map.get(pq.poll());
            while (count -- > 0) {
                sb.append(c);
            }
        }
        return sb.toString();
    }
}
