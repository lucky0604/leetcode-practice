package com.fastdata.algorithm.easy.array;

import java.util.Arrays;

/**
 * @Author: Lucky
 * @Description: https://leetcode.com/problems/running-sum-of-1d-array/
 * @Date: create in 12/26/20 - 10:16 AM
 */
public class RunningSumOf1DArray {
    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3,4,5};
        int[] result = runningSum(nums);
        System.out.println("result = " + Arrays.toString(result));
    }

    public static int[] runningSum(int[] nums) {
        int[] result = new int[nums.length];
        for (int i = 0; i < nums.length; i ++) {
            if (i == 0) {
                result[0] = nums[0];
            } else {
                result[i] = result[i - 1] + nums[i];
            }
        }
        return result;
    }

}
