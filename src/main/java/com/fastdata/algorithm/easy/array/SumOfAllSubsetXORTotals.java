package com.fastdata.algorithm.easy.array;

/**
 * @Author: lucky
 * @License: (C) Copyright
 * @Contact: lucky_soft@163.com
 * @Date: 2021-05-23 1:18 PM
 * @Version: 1.0
 * @description: https://leetcode.com/problems/sum-of-all-subset-xor-totals/
 **/

public class SumOfAllSubsetXORTotals {

    int ret = 0;

    public int subsetXORTotals(int[] nums) {
        ret = 0;
        return findSubsetTotals(nums, 0, 0);
    }

    public int findSubsetTotals(int[] nums, int idx, int curr) {
        if (idx == nums.length) {
            return curr;
        }
        return findSubsetTotals(nums, idx + 1, curr ^ nums[idx]) + findSubsetTotals(nums, idx + 1, curr);
    }
}
