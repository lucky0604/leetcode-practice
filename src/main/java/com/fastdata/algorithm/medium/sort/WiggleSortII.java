package com.fastdata.algorithm.medium.sort;

import java.util.Arrays;

/**
 * @Author: Lucky
 * @Description: https://leetcode.com/problems/wiggle-sort-ii/
 * @Date: created in 2021/4/11 - 20:44
 */
public class WiggleSortII {

    public void wiggleSort(int[] nums) {
        Arrays.sort(nums);

        int mid = (nums.length - 1) / 2;
        int right = nums.length - 1;

        int[] aux = new int[nums.length];
        int auxIndex = 0;
        while (mid >=0 || right > (nums.length - 1) / 2) {
            if (auxIndex % 2 == 0) {
                aux[auxIndex] = nums[mid];
                mid --;
            } else {
                aux[auxIndex] = nums[right];
                right --;
            }
            auxIndex ++;
        }

        for (int i = 0; i < nums.length; i ++) {
            nums[i] = aux[i];
        }
    }
}
