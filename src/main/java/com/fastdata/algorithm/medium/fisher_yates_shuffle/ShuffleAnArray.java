package com.fastdata.algorithm.medium.fisher_yates_shuffle;

import java.util.Arrays;
import java.util.Random;

/**
 * @Author: lucky
 * @License: (C) Copyright
 * @Contact: lucky_soft@163.com
 * @Date: 7/21/21 11:00 AM
 * @Version: 1.0
 * @Description: https://leetcode.com/problems/shuffle-an-array/
 **/

public class ShuffleAnArray {

    private int[] nums;
    private Random random;

    public ShuffleAnArray(int[] nums) {
        this.nums = nums;
        random = new Random();
    }

    // resets the array to its original configuration and return it
    public int[] reset() {
        return nums;
    }

    // returns a random shuffling of the array
    public int[] shuffle() {
        int[] randoms = new int[nums.length];
        boolean[] visited = new boolean[nums.length];

        int count = 0;
        while (count < randoms.length) {
            int index = random.nextInt(nums.length);
            if (!visited[index]) {
                randoms[count ++] = nums[index];
                visited[index] = true;
            }
        }
        return randoms;
    }

}
