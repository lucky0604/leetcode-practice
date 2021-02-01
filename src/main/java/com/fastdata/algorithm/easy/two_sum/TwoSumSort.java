package com.fastdata.algorithm.easy.two_sum;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author: Lucky
 * @Description:
 * @Date: create in 12/16/20 - 11:25 AM
 */
public class TwoSumSort {
    public static void main(String[] args) {
        int[] arr = new int[]{2,6,3,5};
        int[] result = twoSum(arr, 5);
        System.out.println("result + " + result);
    }

    /**
     * 双指针法
     * @param nums
     * @param target
     * @return
     */
    public static int[] twoSum(int[] nums, int target) {
        if (nums.length == 0) return null;
        int i = 0;
        int j = nums.length - 1;
        while (i <= j) {
            if (nums[i] + nums[j] == target) {
                return new int[]{i+1, j + 1};
            } else if (nums[i] + nums[j] < target) {
                i ++;
            } else {
                j --;
            }
        }
        throw new IllegalArgumentException("no match");
    }
}
