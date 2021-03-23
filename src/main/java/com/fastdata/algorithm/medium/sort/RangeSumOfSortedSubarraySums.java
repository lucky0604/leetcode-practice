package com.fastdata.algorithm.medium.sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @Author: Lucky
 * @Description: https://leetcode.com/problems/range-sum-of-sorted-subarray-sums/
 * @Date: create in 3/23/21 - 10:05 AM
 */
public class RangeSumOfSortedSubarraySums {

    public int rangeSum(int[] nums, int n, int left, int right) {
        List<Long> ret = new ArrayList<>();
        long temp = 0, ans = 0, mod = 1000000007;
        for (int i = 0; i < nums.length; i ++) {
            for (int j = i; j < nums.length; j ++) {
                temp = 0;
                for (int k = i; k <= j; ++k) {
                    temp += nums[k];
                }
                ret.add(temp);
            }
        }
        Collections.sort(ret);
        -- left;
        -- right;
        for (int i = left; i <= right; i ++) {
            ans = (ans + ret.get(i)) % mod;
        }
        return (int) ans;
    }
}
