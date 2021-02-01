package com.fastdata.algorithm.easy.array;

import java.util.Arrays;

/**
 * @Author: Lucky
 * @Description: https://leetcode.com/problems/shuffle-the-array/
 * @Date: create in 12/28/20 - 11:41 AM
 */
public class ShuffleTheArray {
    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3,4,4,3,2,1};
        int n = 4;
        int[] res = shuffle(nums, n);
        System.out.println("res = " + Arrays.toString(res));
    }

    private static int[] shuffle(int[] nums, int n) {
        int x = 0;
        int y = n;
        int[] res = new int[nums.length];
        for (int i = 0; i < res.length; i ++) {
            if (i % 2 == 0) {
                res[i] = nums[x];
                x ++;
            } else {
                res[i] = nums[y];
                y ++;
            }
        }
        return res;
    }
}
