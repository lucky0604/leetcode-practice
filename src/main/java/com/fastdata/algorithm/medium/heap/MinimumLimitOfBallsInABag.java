package com.fastdata.algorithm.medium.heap;

/**
 * @Author: Lucky
 * @Description: https://leetcode.com/problems/minimum-limit-of-balls-in-a-bag/
 * @Date: create in 3/4/21 - 1:05 PM
 */
// TODO: to be understand
public class MinimumLimitOfBallsInABag {

    public int minimumSize(int[] nums, int maxOperations) {
        int min = 0;
        int max = 1000000000;
        while (min + 1 < max) {
            int mid = (max - min) / 2 + min;
            int count = 0;
            for (int a: nums) {
                count += (a - 1) / mid;
            }
            if (count <= maxOperations) {
                max = mid;
            } else {
                min = mid;
            }
        }
        return max;
    }
}
