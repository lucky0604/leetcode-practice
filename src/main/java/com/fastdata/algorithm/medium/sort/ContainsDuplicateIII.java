package com.fastdata.algorithm.medium.sort;

import java.util.TreeSet;

/**
 * @ClassName: ContainsDuplicateIII
 * @Description: https://leetcode.com/problems/contains-duplicate-iii/
 * @Create by: lucky
 * @Date: 4/14/21 11:05 AM
 */
// TODO: to understand the TreeSet api
public class ContainsDuplicateIII {

    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if (nums == null || nums.length <= 1) {
            return false;
        }
        TreeSet<Integer> treeSet = new TreeSet<>();
        for (int i = 0; i < nums.length; i ++) {
            Integer low = treeSet.floor(nums[i]);
            Integer high = treeSet.ceiling(nums[i]);

            if ((low != null && (long) nums[i] - low <= t) || (high != null && (long) high - nums[i] <= t)) {
                return true;
            }
            treeSet.add(nums[i]);

            if (i >= k) {
                treeSet.remove(nums[i - k]);
            }
        }
        return false;
    }
}
