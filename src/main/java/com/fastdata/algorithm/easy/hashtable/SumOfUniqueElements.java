package com.fastdata.algorithm.easy.hashtable;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: Lucky
 * @Description: https://leetcode.com/problems/sum-of-unique-elements/
 * @Date: create in 2/9/21 - 10:26 AM
 */
public class SumOfUniqueElements {

    public static void main(String[] args) {
        int[] nums = new int[]{1,1,1,1,1,1};
        int ret = sumOfUnique(nums);
        System.out.println(ret);
    }

    public static int sumOfUnique(int[] sums) {
        Map<Integer, Integer> numMap = new HashMap<>();
        for (int i = 0; i < sums.length; i ++) {
            numMap.put(sums[i], numMap.getOrDefault(sums[i], 0) + 1);
        }
        int sum = 0;
        for (Integer k: numMap.keySet()) {
            if (numMap.get(k).equals(1)) {
                sum += k;
            }
        }
        return sum;
    }
}
