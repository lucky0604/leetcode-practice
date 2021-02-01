package com.fastdata.algorithm.easy.two_sum;

import java.util.*;

/**
 * @Author: Lucky
 * @Description: https://leetcode.com/problems/two-sum/
 * @Date: create in 12/16/20 - 10:04 AM
 */
public class TwoSum {
    public static void main(String[] args) {
        int[] result = twoSum(new int[]{1,2,3,4},5);
        System.out.println("result = " + result);
    }

    /**
     * solution 1, use HashMap
     * @param nums
     * @param target
     * @return
     */
//    public static int[] twoSum(int[] nums, int target) {
//        Map<Integer, Integer> prevMap = new HashMap<Integer, Integer>();
//        for (int i = 0; i < nums.length; i ++) {
//            int diff = target - nums[i];
//            if (prevMap.containsKey(diff)) {
//                return new int[]{prevMap.get(diff), i};
//            }
//            prevMap.put(nums[i], i);
//        }
//        return new int[0];
//    }

    public static int[] twoSum(int[] nums, int target) {
//        int[] result = new int[2];
        if (nums.length == 0) return null;
        for (int i = 0; i < nums.length; i ++) {
            for (int j = i + 1; j < nums.length; j ++) {
                if (target - nums[i] == nums[j]) {
//                    result[0] = i;
//                    result[1] = j;
                    int[] result = new int[] {i, j};
                    return result;
                }
            }
        }
        return null;
    }
}
