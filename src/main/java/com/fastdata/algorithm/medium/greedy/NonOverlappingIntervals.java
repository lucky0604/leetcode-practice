package com.fastdata.algorithm.medium.greedy;

import java.util.Arrays;

/**
 * @Author: lucky
 * @License: (C) Copyright
 * @Contact: lucky_soft@163.com
 * @Date: 2021-06-05 10:27 AM
 * @Version: 1.0
 * @description: https://leetcode.com/problems/non-overlapping-intervals/
 **/

public class NonOverlappingIntervals {

    public int eraseOverlapIntervals(int[][] intervals) {
        int length = intervals.length;
        int ret = 0;
        if (length <= 1) {
            return 0;
        }
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        int[] tmp = new int[2];
        tmp[0] = Integer.MIN_VALUE;
        tmp[1] = Integer.MIN_VALUE;
        for (int i = 0; i < length; i ++) {
            if (tmp[1] > intervals[i][0]) {
                ret ++;
                tmp[1] = Math.min(tmp[1], intervals[i][1]);
            } else {
                tmp = intervals[i];
            }
        }
        return ret;
    }
}
