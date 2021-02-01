package com.fastdata.algorithm.easy.array;

import java.util.Arrays;

/**
 * @Author: Lucky
 * @Description: https://leetcode.com/problems/number-of-good-pairs/
 * @Date: create in 12/28/20 - 12:51 PM
 */
public class NumberOfGoodPairs {
    public static void main(String[] args) {
        int[] nums = new int[]{1,1,1,1};
        int res = numIdenticalPairs(nums);
        System.out.println("res = " + res);
    }

    private static int numIdenticalPairs(int[] nums) {
        int count = 0;
        for (int i = 0; i < nums.length; i ++) {
            for (int j = i + 1; j < nums.length; j ++) {
                if (nums[i] == nums[j]) {
                    count ++;
                }
            }
        }
        return count;
    }
}
