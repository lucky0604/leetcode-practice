package com.fastdata.algorithm.medium.sort;

import java.util.*;

/**
 * @Author: Lucky
 * @Description: https://leetcode.com/problems/arithmetic-subarrays/
 * @Date: create in 3/20/21 - 10:18 AM
 */
public class ArithmeticSubarrays {

    public List<Boolean> checkArithmeticSubarrays(int[] nums, int[] l, int[] r) {
        List<Boolean> ret = new ArrayList<>();
        // 1, loop l array
        for (int i = 0; i < l.length; i ++) {
            // 2, createa new sub array
            int[] newArr = new int[r[i] - l[i] + 1];
            for (int j = 0; j < newArr.length; j ++) {
                newArr[j] = nums[l[i] + j];
            }
            // 3, sort the aray
            Arrays.sort(newArr);
            // 4, check if the difference is not the same by using set
            Set<Integer> set = new HashSet<>();
            for (int m = 0; m < newArr.length - 1; m ++) {
                set.add(newArr[m] - newArr[m + 1]);
            }
            if (set.size() != 1) {
                ret.add(false);
            } else {
                ret.add(true);
            }
        }
        return ret;
    }
}
