package com.fastdata.algorithm.easy.dynamic_programic;

/**
 * @Author: lucky
 * @License: (C) Copyright
 * @Contact: lucky_soft@163.com
 * @Date: 2021-06-21 10:28 AM
 * @Version: 1.0
 * @description: https://leetcode.com/problems/maximum-subarray/
 **/

public class MaximumSubarray {

    public int maxSubArray(int[] nums) {
        int arraySum = Integer.MIN_VALUE;
        int sum = 0;
        for (int i = 0; i < nums.length; i ++) {
            sum = Math.max(nums[i], sum + nums[i]);
            if (sum > arraySum) {
                arraySum = sum;
            }
        }
        return arraySum;
    }
}
