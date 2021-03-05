package com.fastdata.algorithm.medium.heap;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @Author: Lucky
 * @Description: https://leetcode.com/problems/reorganize-string/
 * @Date: create in 3/5/21 - 11:53 AM
 */
public class ReorganizeString {

    public String reorganizeString(String S) {
        // count each character
        char[] sArr = S.toCharArray();
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < sArr.length; i ++) {
            map.put(sArr[i], map.getOrDefault(sArr[i], 0) + 1);
        }
        Queue<Character> pq = new PriorityQueue<>((p, q) -> map.get(q) - map.get(p));
        pq.addAll(map.keySet());

        StringBuilder sb = new StringBuilder();
        while (pq.size() > 1) {
            char curr = pq.remove();
            char next = pq.remove();
            sb.append(curr);
            sb.append(next);
            map.put(curr, map.get(curr) - 1);
            map.put(next, map.get(next) - 1);
            // if still the count > 0, add the characters back to the heap
            if (map.get(curr) > 0)
                pq.add(curr);
            if (map.get(next) > 0)
                pq.add(next);
        }
        if (!pq.isEmpty()) {
            char last = pq.remove();
            if (map.get(last) > 1) {
                return "";
            }
            sb.append(last);
        }
        return sb.toString();
    }
}
