package com.fastdata.algorithm.medium.sort;

import java.util.Arrays;

/**
 * @Author: Lucky
 * @Description: https://leetcode.com/problems/minimum-difference-between-largest-and-smallest-value-in-three-moves/
 * @Date: created in 2021/3/28 - 13:09
 */
// TODO: to be understand
public class MinimumDifferenceBetweenLargestAndSmallestValueInThreeMoves {

    public int minDifference(int[] nums) {
        int length = nums.length;
        if (length < 5) return 0;
        Arrays.sort(nums);
        int ret = Integer.MAX_VALUE;
        for (int i = 0; i < 4; i ++) {
            ret = Math.min(ret, nums[length - 4 + i] - nums[i]);
        }
        return ret;
    }
}
