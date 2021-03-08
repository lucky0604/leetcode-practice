package com.fastdata.algorithm.medium.heap;

import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @Author: Lucky
 * @Description: https://leetcode.com/problems/split-array-into-consecutive-subsequences/
 * @Date: create in 3/8/21 - 11:18 AM
 */
public class SplitArrayIntoConsecutiveSubsequences {

    public boolean isPossible(int[] nums) {
        HashMap<Integer, Integer> availableMap = new HashMap<>();
        HashMap<Integer, Integer> wantMap = new HashMap<>();

        for (int i : nums) {
            availableMap.put(i, availableMap.getOrDefault(i, 0) + 1);
        }

        for (int i = 0; i < nums.length; i ++) {
            if (availableMap.get(nums[i]) <= 0) {
                continue;
            } else if (wantMap.getOrDefault(nums[i], 0) > 0) {
                availableMap.put(nums[i], availableMap.getOrDefault(nums[i], 0) - 1);
                wantMap.put(nums[i], wantMap.getOrDefault(nums[i], 0) - 1);
                wantMap.put(nums[i] + 1, wantMap.getOrDefault(nums[i] + 1, 0) + 1);
            } else if (availableMap.getOrDefault(nums[i], 0) > 0 && availableMap.getOrDefault(nums[i] + 1, 0) > 0 && availableMap.getOrDefault(nums[i] + 2, 0) > 0) {
                availableMap.put(nums[i], availableMap.getOrDefault(nums[i], 0) - 1);
                availableMap.put(nums[i] + 1, availableMap.getOrDefault(nums[i] + 1, 0) - 1);
                availableMap.put(nums[i] + 2, availableMap.getOrDefault(nums[i] + 2, 0) - 1);
                wantMap.put(nums[i] + 3, wantMap.getOrDefault(nums[i] + 3, 0) + 1);
            } else {
                return false;
            }
        }

        return true;
    }
}
