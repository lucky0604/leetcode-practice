package com.fastdata.algorithm.medium.sort;

/**
 * @Author: lucky
 * @License: (C) Copyright
 * @Contact: lucky_soft@163.com
 * @Date: 2021-06-14 11:03 AM
 * @Version: 1.0
 * @description: https://leetcode.com/problems/maximum-ice-cream-bars/
 **/

public class MaximumIceCreamBars {

    public int maxIceCream(int[] costs, int coins) {
        int[] counter = new int[10001];
        int length = costs.length;
        for (int i = 0; i < length; i ++) {
            counter[costs[i]] ++;
        }
        int ret = 0;
        for (int i = 0; i < 10001; i ++) {
            if (counter[i] > 0) {
                int used = Math.min(i, counter[i]);
                coins -= used;
                ret += used;
            }
        }
        return ret;
    }
}
