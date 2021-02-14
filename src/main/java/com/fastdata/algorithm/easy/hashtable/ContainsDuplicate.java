package com.fastdata.algorithm.easy.hashtable;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: Lucky
 * @Description: https://leetcode.com/problems/contains-duplicate/
 * @Date: created in 2021/2/14 - 13:59
 */
public class ContainsDuplicate {

    public boolean containsDuplicate(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i ++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        for (Integer i : map.keySet()) {
            if (map.get(i) > 1) {
                return true;
            }
        }
        return false;
    }
}
