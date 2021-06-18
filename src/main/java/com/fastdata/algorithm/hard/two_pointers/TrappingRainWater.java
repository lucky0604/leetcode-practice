package com.fastdata.algorithm.hard.two_pointers;

/**
 * @Author: lucky
 * @License: (C) Copyright
 * @Contact: lucky_soft@163.com
 * @Date: 5/28/21 1:19 PM
 * @Version: 1.0
 * @Description: https://leetcode.com/problems/trapping-rain-water/
 **/

public class TrappingRainWater {

    public int trap(int[] height) {
        // two pointers
        int left = 0;
        int right = height.length - 1;
        // init left max and right max
        int left_max = 0;
        int right_max = 0;
        // init the ret
        int ret = 0;

        while (left < right) {
            if (height[left] < height[right]) {
                if (height[left] > left_max) {
                    left_max = height[left];
                } else {
                    ret += left_max - height[left];
                }
                left ++;
            } else {
                if (height[right] > right_max) {
                    right_max = height[right];
                } else {
                    ret += right_max - height[right];
                }
                right --;
            }
        }
        return ret;
    }
}
