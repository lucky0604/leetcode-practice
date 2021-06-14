package com.fastdata.algorithm.medium.sort;

import java.util.Arrays;

/**
 * @Author: lucky
 * @License: (C) Copyright
 * @Contact: lucky_soft@163.com
 * @Date: 2021-06-13 1:17 PM
 * @Version: 1.0
 * @description: https://leetcode.com/problems/minimize-maximum-pair-sum-in-array/
 **/

public class MinimizeMaximumPairSumInArray {

    public int minPairSum(int[] nums) {
        Arrays.sort(nums);
        int ret = 0;
        int i = 0;
        int j = nums.length - 1;
        while (i != j) {
            ret = Math.max(ret, nums[i] + nums[j]);
            i ++;
            j --;
        }
        return ret;
    }
}
