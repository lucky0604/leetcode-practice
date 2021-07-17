package com.fastdata.algorithm.medium.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author: lucky
 * @License: (C) Copyright
 * @Contact: lucky_soft@163.com
 * @Date: 2021/7/17 14:14
 * @Version: 1.0
 * @description:
 **/

public class FourSum {

    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> ret = new ArrayList<>();
        Arrays.sort(nums);

        if (nums == null || nums.length < 4) {
            return ret;
        }

        for (int i = 0; i < nums.length - 3; i ++) {
            if (i == 0 || nums[i] != nums[i - 1]) {
                for (int j = i + 1; j < nums.length - 2; j ++) {
                    if (j == i + 1 || nums[j] != nums[j - 1]) {
                        int start = j + 1;
                        int end = nums.length - 1;
                        int newTarget = target - nums[i] - nums[j];
                        while (start < end) {
                            if (nums[start] + nums[end] == newTarget) {
                                ret.add(Arrays.asList(nums[i], nums[j], nums[start], nums[end]));
                                while (start < end && nums[start] == nums[start + 1]) {
                                    start ++;
                                }
                                while (start < end && nums[end] == nums[end - 1]) {
                                    end --;
                                }
                                start ++;
                                end --;
                            } else if (nums[start] + nums[end] > newTarget) {
                                end --;
                            } else {
                                start ++;
                            }
                        }
                    }
                }
            }
        }

        return ret;
    }
}
