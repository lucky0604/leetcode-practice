package com.fastdata.algorithm.medium.two_pointers;

/**
 * @Author: lucky
 * @License: (C) Copyright
 * @Contact: lucky_soft@163.com
 * @Date: 2021-05-24 4:09 PM
 * @Version: 1.0
 * @description: https://leetcode.com/problems/container-with-most-water/
 **/

public class ContainerWithMostWater {
    
    public int maxArea(int[] height) {
        int ret = 0;
        int left = 0;
        int right = height.length - 1;
        while (true) {
            if (left > right) {
                break;
            }
            // move the short pointer
            ret = Math.max(ret, Math.min(height[left], height[right]) * (right - left));
            if (height[left] < height[right]) {
                left ++;
            } else {
                right --;
            }
        }
        return ret;
    }
}
