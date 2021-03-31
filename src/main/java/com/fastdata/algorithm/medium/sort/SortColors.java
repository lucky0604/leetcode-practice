package com.fastdata.algorithm.medium.sort;

import java.util.Arrays;

/**
 * @Author: Lucky
 * @Description: https://leetcode.com/problems/sort-colors/
 * @Date: create in 3/31/21 - 9:55 AM
 */
public class SortColors {

    public static void main(String[] args) {
        int[] nums = new int[]{0, 8, 4, 2};
        sortColors(nums);
    }

    public static void sortColors(int[] nums) {
        int min = minMax(nums)[0];
        int max = minMax(nums)[1];
        int k = max - min + 1;
        int[] count = new int[k];
        // count the item's frequncy
        for (int i = 0; i < nums.length; i ++) {
            int dataInCountIndex = nums[i] - min;
            count[dataInCountIndex] += 1;
        }
        int j = 0;
        for (int i = 0; i < k; i ++) {
            int originalData = i + min;
            while (count[i] > 0) {
                nums[j] = originalData;
                count[i] --;
                j ++;
            }
        }
    }

    // find the min and max value in nums
    private static int[] minMax(int[] nums) {
        // suppose that
        int min = nums[0];
        int max = nums[0];
        for (int i = 1; i < nums.length; i ++) {
            if (min > nums[i]) {
                min = nums[i];
            }
            if (max < nums[i]) {
                max = nums[i];
            }
        }
        int[] ret = new int[]{min, max};
        return ret;
    }
}
