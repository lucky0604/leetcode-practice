package com.fastdata.algorithm.medium.sort;

import java.util.ArrayList;
import java.util.List;

/**
 * name: InsertInterval
 * date: 4/9/21 12:09 PM
 * author: lucky
 * version: 1.0
 * description: https://leetcode.com/problems/insert-interval/
 */
// TODO: to be understand
public class InsertInterval {

    /**
     * if the current interval is before the new one (current interval's end is less than the new interval start ) --> add the current interval
     * if the new interval is before the current one (the condition before is wrong and the new interval's end is less than the current interval's start) --> add the new interval and mark as done (to just add remaning intervals)
     * else merge
     * if after iterating over all intervals the new one not added yet --> add it
     * @param intervals
     * @param newInterval
     * @return
     */
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> ret = new ArrayList<>();
        boolean done = false;
        for (int i = 0; i < intervals.length; i ++) {
            if (done || newInterval[0] > intervals[i][1]) {
                ret.add(intervals[i]);
            } else {
                if (newInterval[1] < intervals[i][0]) {
                    ret.add(newInterval);
                    i --;
                    done = true;
                } else {
                    newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
                    newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
                }
            }
        }
        if (done == false) ret.add(newInterval);
        return ret.toArray(new int[ret.size()][]);
    }
}
