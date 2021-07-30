package com.fastdata.algorithm.easy.dynamic_programic;

/**
 * @Author: lucky
 * @License: (C) Copyright
 * @Contact: lucky_soft@163.com
 * @Date: 7/27/21 10:53 AM
 * @Version: 1.0
 * @Description: https://leetcode.com/problems/build-array-from-permutation/
 **/

public class BuildArrayFromPermutation {

    public int[] buildArray(int[] nums) {
        int length = nums.length;
        int[] ret = new int[length];
        for (int i = 0; i < length; i ++) {
            ret[i] = nums[nums[i]];
        }
        return ret;
    }
}
