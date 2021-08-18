package com.fastdata.algorithm.easy.queue_stack;

import java.util.*;

/**
 * @Author: Lucky
 * @Description: https://leetcode.com/problems/next-greater-element-i/
 * @Date: create in 12/23/20 - 1:21 PM
 */
public class NextGreaterElement {
    public static void main(String[] args) {
        int[] nums1 = new int[]{4,1,2};
        int[] nums2 = new int[]{1,3,4,2};
        nextGreaterElement(nums1, nums2);
    }

    public static int[] nextGreaterElement(int[] nums1, int[] nums2) {
        /**
         * 基本思路：
         * 1，nums1是nums2的子集
         * 2，优先处理nums2，从右向左处理
         */
        int n = nums2.length;
        // 使用Deque，由于Deque是一个interface，速度要比Stack快
        Deque<Integer> stack = new ArrayDeque<>();
        Map<Integer, Integer> map = new HashMap<>();
        int[] res = new int[nums1.length];
        for (int i = n - 1; i >= 0; i --) {
            while (!stack.isEmpty() && nums2[i] > nums2[stack.peek()]) {
                stack.pop();
            }
            map.put(nums2[i], stack.isEmpty() ? -1 : nums2[stack.peek()]);
            stack.push(i);
        }
        for (int i = 0; i < nums1.length; i ++) {
            res[i] = map.get(nums1[i]);
        }
        return res;
    }
}
