package com.fastdata.algorithm.medium.sort;

// https://leetcode.com/problems/merge-intervals/
// TODO: to be understand
public class MergeIntervals {

    public int[][] merge(int[][] intervals) {
        int length = intervals.length;
        int merged = 0;
        merged = calculate(intervals);
        int[][] ret = new int[length - merged][2];
        int retIndex = 0;
        for (int i = 0; i < length; i ++) {
            if (intervals[i][0] != -1) {
                ret[retIndex][0] = intervals[i][0];
                ret[retIndex ++][1] = intervals[i][1];
            }
        }
        return ret;
    }

    public int calculate(int[][] intervals) {
        int length = intervals.length;
        int start;
        int end;
        int secondStart;
        int secondEnd;
        int merged = 0;
        for (int i = 0; i < length - 1; i ++) {
            start = intervals[i][0];
            end = intervals[i][1];
            for (int j = i + 1; j < length; j ++) {
                secondStart = intervals[j][0];
                secondEnd = intervals[j][1];
                if (end < secondStart || start > secondEnd) continue;
                else {
                    intervals[j][0] = Math.min(start, secondStart);
                    intervals[j][1] = Math.max(end, secondEnd);
                    intervals[i][0] = -1;
                    intervals[i][1] = -1;
                    merged ++;
                    break;
                }
            }
        }
        return merged;
    }
}
