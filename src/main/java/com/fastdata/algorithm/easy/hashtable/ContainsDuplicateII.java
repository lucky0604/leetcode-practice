package com.fastdata.algorithm.easy.hashtable;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: Lucky
 * @Description: https://leetcode.com/problems/contains-duplicate-ii/
 * @Date: created in 2021/2/24 - 21:21
 */
public class ContainsDuplicateII {

    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i ++) {
            Integer number = map.get(nums[i]);
            if (number == null) {
                map.put(nums[i], i);
            } else {
                int j = number;
                if (Math.abs(i - j) <= k) {
                    return true;
                }
                map.put(nums[i], i);
            }
        }
        return false;
    }
}
