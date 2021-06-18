package com.fastdata.algorithm.medium.array;

/**
 * @Author: lucky
 * @License: (C) Copyright
 * @Contact: lucky_soft@163.com
 * @Date: 6/2/21 10:40 AM
 * @Version: 1.0
 * @Description: https://leetcode.com/problems/rotate-array/
 **/

public class RotateArray {

    public void rotate(int[] nums, int k) {
        int length = nums.length;
        k %= length;

        reverse(nums, 0, length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, length - 1);
    }

    private void reverse(int[] nums, int left, int right) {
        int tmp;
        while (left < right) {
            tmp = nums[left];
            nums[left] = nums[right];
            nums[right] = tmp;
            left ++;
            right --;
        }
    }
}
