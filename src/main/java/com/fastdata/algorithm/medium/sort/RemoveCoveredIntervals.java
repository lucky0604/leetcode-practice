package com.fastdata.algorithm.medium.sort;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @Author: Lucky
 * @Description: https://leetcode.com/problems/remove-covered-intervals/
 * @Date: create in 3/25/21 - 10:13 AM
 */
public class RemoveCoveredIntervals {

    public int removeCoveredIntervals(int[][] intervals) {
        // sort the matrix
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] == o2[0]) {
                    return o2[1] - o1[1];
                } else {
                    return o1[0] - o2[0];
                }
            }
        });
        int count = 1;
        int j = 0;
        for (int i = 1; i <intervals.length; i ++) {
            if (intervals[i][0] >= intervals[j][0] && intervals[i][1] <= intervals[j][1]) {
                continue;
            }
            j = i;
            count ++;
        }
        return count;
    }
}
