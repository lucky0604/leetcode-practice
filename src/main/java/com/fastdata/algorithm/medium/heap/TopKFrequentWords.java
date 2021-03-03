package com.fastdata.algorithm.medium.heap;

import java.util.*;

/**
 * @Author: Lucky
 * @Description: https://leetcode.com/problems/top-k-frequent-words/
 * @Date: create in 3/3/21 - 12:33 PM
 */
public class TopKFrequentWords {

    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> map = new HashMap<>();
        Arrays.stream(words).sorted();
        for (int i = 0; i < words.length; i ++) {
            map.put(words[i], map.getOrDefault(words[i], 0) + 1);
        }
        Queue<String> pq = new PriorityQueue<>((p, q) -> map.get(p).equals(map.get(q)) ? q.compareTo(p): map.get(p) - map.get(q));
        for (String s: map.keySet()) {
            pq.add(s);
            if (pq.size() > k) pq.poll();
        }
        List<String> ret = new ArrayList<>();
        int curr = 0;
        while (!pq.isEmpty()) {
            ret.add(pq.poll());
        }
        Collections.reverse(ret);
        return ret;
    }
}
