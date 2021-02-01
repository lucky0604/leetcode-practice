package com.fastdata.algorithm.easy.sort.insertion_sort;

import java.util.Arrays;

/**
 * @Author: Lucky
 * @Description: https://leetcode.com/problems/merge-sorted-array/
 * @Date: create in 1/21/21 - 12:56 PM
 */
public class MergeSortedArray {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int count = 0;
        for (int i = m; i < (m + n); i ++) {
            nums1[i] = nums2[count];
            count ++;
        }
        Arrays.sort(nums1);
    }
}
