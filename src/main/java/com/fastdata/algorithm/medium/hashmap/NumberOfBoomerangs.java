package com.fastdata.algorithm.medium.hashmap;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: lucky
 * @License: (C) Copyright
 * @Contact: lucky_soft@163.com
 * @Date: 2021/9/13 - 20:36
 * @Version: 1.0
 * @description: https://leetcode-cn.com/problems/number-of-boomerangs/
 **/

public class NumberOfBoomerangs {

    public int numberOfBoomerangs(int[][] points) {
        int ret = 0;
        for (int[] p : points) {
            Map<Integer, Integer> count = new HashMap<>();
            for (int[] q: points) {
                int distance = (p[0] - q[0]) * (p[0] - q[0]) + (p[1] - q[1]) * (p[1] - q[1]);
                count.put(distance, count.getOrDefault(distance, 0) + 1);
            }
            for (Map.Entry<Integer, Integer> entry: count.entrySet()) {
                int m = entry.getValue();
                ret += m * (m - 1);
            }
        }
        return ret;
    }
}
