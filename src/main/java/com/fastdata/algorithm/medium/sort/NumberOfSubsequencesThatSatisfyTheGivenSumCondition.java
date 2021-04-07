package com.fastdata.algorithm.medium.sort;

import java.util.Arrays;

/**
 * name: NumberOfSubsequencesThatSatisfyTheGivenSumCondition
 * date: 4/7/21 10:37 AM
 * author: lucky
 * version: 1.0
 * description: https://leetcode.com/problems/number-of-subsequences-that-satisfy-the-given-sum-condition/
 */

public class NumberOfSubsequencesThatSatisfyTheGivenSumCondition {

    int mod = 1000000007;

    public int numSubSeq(int[] nums, int target) {
        /**
         * given n numbers, there are 2^(n-1) subsequences
         * for example:
         * when a <= b <= c, and a + c <= target
         * {a, b, c} -> {a}, {a, b}, {a,c}, {a,b,c} -> 2 ^ (3 - 1)
         */
        Arrays.sort(nums);
        int[] pow_result = new int[nums.length];
        pow_result[0] = 1;
        for (int i = 1; i < nums.length; i ++) {
            pow_result[i] = (2 * pow_result[i - 1] + 1) % mod;
        }
        int ret = 0;
        for (int i = 0; i < nums.length && 2 * nums[i] <= target; i ++) {
            ret = (ret + 1) % mod;
            int l = i;
            int r = nums.length - 1;
            while (l + 1 < r) {
                int mid = (l + r) / 2;
                if ((nums[mid] + nums[i]) > target) r = mid - 1;
                else l = mid;
            }
            if (r > i && nums[r] + nums[i] <= target){
                ret = (ret + pow_result[r - i - 1]) % mod;
            } else if (l > i) {
                ret = (ret + pow_result[l - i - 1]) % mod;
            }
        }
        return ret;
    }
}
