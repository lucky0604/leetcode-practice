package com.fastdata.algorithm.easy.hashtable;

import java.util.Arrays;
import java.util.HashMap;

/**
 * @Author: Lucky
 * @Description: https://leetcode.com/problems/single-number/
 * @Date: create in 1/18/21 - 10:41 AM
 */
public class SingleNumber {

    public static void main(String[] args) {
        int[] nums = new int[]{4,1,2,1,2};
        int ret = singleNumber(nums);
        System.out.println(" ret = " + ret);
    }

    public static int singleNumber(int[] nums) {
        HashMap<Integer, Integer> ret = new HashMap<>();
        for (int i = 0; i < nums.length; i ++) {
            int count = 1;
            if (ret.containsKey(nums[i])) {
                ret.put(nums[i], ret.get(nums[i]) + 1);
            } else {
                ret.put(nums[i], count);
            }
        }

        for (int item: ret.keySet()) {
            if (ret.get(item) == 1) {
                return item;
            }
        }
        return 0;
    }
}
