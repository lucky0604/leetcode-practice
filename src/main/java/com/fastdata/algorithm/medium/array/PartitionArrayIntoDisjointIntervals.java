package com.fastdata.algorithm.medium.array;

/**
 * @Author: lucky
 * @License: (C) Copyright
 * @Contact: lucky_soft@163.com
 * @Date: 2021-06-07 10:00 AM
 * @Version: 1.0
 * @description: https://leetcode.com/problems/partition-array-into-disjoint-intervals/
 **/
// TODO: to be understand
public class PartitionArrayIntoDisjointIntervals {

    public int partitionDisjoint(int[] nums) {
        // init the current max and next max value
        int currentMax = nums[0];
        int nextMax = nums[0];
        int ret = 0;
        for (int i = 1; i < nums.length; i ++) {
            int currentVal = nums[i];
            nextMax = Math.max(currentVal, nextMax);
            if (currentVal < currentMax) {
                currentMax = nextMax;
                ret = i;
            }
        }
        return ret + 1;
    }
}
