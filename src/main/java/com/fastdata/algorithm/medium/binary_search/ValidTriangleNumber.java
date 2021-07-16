package com.fastdata.algorithm.medium.binary_search;

import java.util.Arrays;

/**
 * @Author: lucky
 * @License: (C) Copyright
 * @Contact: lucky_soft@163.com
 * @Date: 2021/7/16 13:58
 * @Version: 1.0
 * @description: https://leetcode.com/problems/valid-triangle-number/
 **/

public class ValidTriangleNumber {

    public int triangleNumber(int[] nums) {
        int count = 0;
        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 2; i ++) {
            for (int j = i + 1; j < nums.length - 1; j ++) {
                int sum = nums[i] + nums[j];

                // binary search
                int low = j + 1;
                int high = nums.length;
                while (low < high) {
                    int mid = (low + high) / 2;
                    if (sum > nums[mid]) {
                        low = mid + 1;
                    } else {
                        high = mid;
                    }
                }
                count += low - 1 - j;
            }
        }
        return count;
    }
}
