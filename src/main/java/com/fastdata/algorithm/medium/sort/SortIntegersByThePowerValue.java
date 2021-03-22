package com.fastdata.algorithm.medium.sort;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * @Author: Lucky
 * @Description: https://leetcode.com/problems/sort-integers-by-the-power-value/
 * @Date: create in 3/22/21 - 10:07 AM
 */
// TODO: to be understand
public class SortIntegersByThePowerValue {

    Map<Integer, Integer> map = new HashMap<>();

    public int getKth(int lo, int hi, int k) {
        map.put(1, 0);
        PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> (powerStep(o1) != powerStep(o2) ? powerStep(o2) - powerStep(o1) : o2 - o1));
        for (int i = lo; i <= hi; i ++) {
            pq.add(i);
            if (pq.size() > k)
                pq.poll();
        }
        return pq.peek();
    }

    private int powerStep(int num) {
        if (map.containsKey(num))
            return map.get(num);
        int res = 1 + ((num % 2 == 0) ? powerStep(num / 2) : powerStep(num * 3 + 1));
        map.put(num, res);
        return res;
    }
}
