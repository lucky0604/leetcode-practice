package com.fastdata.algorithm.medium.two_pointers;

import java.util.Arrays;

/**
 * @Author: lucky
 * @License: (C) Copyright
 * @Contact: lucky_soft@163.com
 * @Date: 2021 10:10 AM
 * @Version: 1.0
 * @description: https://leetcode.com/problems/3sum-closest
 **/

public class Sum3Closest {

    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        Integer res = null;
        Integer mindist = null;
        for (int i = 0; i < nums.length - 2; i ++) {
            int n = nums[i];
            for (int low = i + 1, high = nums.length - 1; low < high;) {
                int sum = n + nums[low] + nums[high];
                int dist = Math.abs(target - sum);
                if (mindist == null || dist < mindist) {
                    res = sum;
                    mindist = dist;
                }
                if (sum > target) {
                    high --;
                } else if (sum < target) {
                    low ++;
                } else {
                    return target;
                }
            }
        }
        return res;
    }
}
