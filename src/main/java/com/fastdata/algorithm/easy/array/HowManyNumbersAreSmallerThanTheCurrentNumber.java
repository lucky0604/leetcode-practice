package com.fastdata.algorithm.easy.array;

import java.util.Arrays;

/**
 * @Author: Lucky
 * @Description: https://leetcode.com/problems/how-many-numbers-are-smaller-than-the-current-number/
 * @Date: create in 12/29/20 - 10:46 AM
 */
public class HowManyNumbersAreSmallerThanTheCurrentNumber {
    public static void main(String[] args) {
        int[] nums = new int[]{6,5,4,8};
        smallerNumbersThanCurrent(nums);
    }

    private static int[] smallerNumbersThanCurrent(int[] nums) {
        int[] res = new int[nums.length];
        for (int i = 0; i < nums.length; i ++) {
            int total = 0;
            for (int j = 0; j < nums.length; j ++) {
                if (j != i && nums[i] > nums[j]) {
                    total ++;
                }
            }
            res[i] = total;
        }
        System.out.println("res = " + Arrays.toString(res));
        return res;
    }
}
