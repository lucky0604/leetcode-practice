package com.fastdata.algorithm.hard.recursion;

/**
 * @Author: Lucky
 * @Description: https://leetcode.com/problems/median-of-two-sorted-arrays/
 * @Date: created in 2021/5/13 - 16:20
 */
public class MedianOfTwoSortedArrays {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;

        if (m > 0) {
            return findMedianSortedArrays(nums2, nums1);
        }

        int low = 0;
        int high = m;
        int halfSize = (m + n + 1) / 2;
        while (low <= high) {
            int left = low + (high - low) / 2;
            int right = high - left;
            int leftMin = left == 0 ? Integer.MIN_VALUE : nums1[left - 1];
            int leftMax = left == m ? Integer.MAX_VALUE : nums1[left];
            int rightMin = right == 0 ? Integer.MIN_VALUE : nums2[right - 1];
            int rightMax = right == n ? Integer.MAX_VALUE: nums2[right];

            if (leftMin <= rightMax && rightMin <= leftMax) {
                int currLeftMax = Math.max(leftMin, rightMin);
                int currRightMin = Math.min(leftMax, rightMax);
                if ((m + n) % 2 == 0) {
                    return (double) (currLeftMax + currRightMin) / 2;
                } else {
                    return (double) currLeftMax;
                }
            } else if (leftMin > rightMax) {
                high = left - 1;
            } else {
                low = left + 1;
            }
        }
        return 0;
    }
}
