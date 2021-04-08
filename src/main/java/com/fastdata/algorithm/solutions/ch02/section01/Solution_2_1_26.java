package com.fastdata.algorithm.solutions.ch02.section01;

import java.util.Arrays;

/**
 * @Author: Lucky
 * @Description:
 * @Date: create in 4/1/21 - 11:53 AM
 */
public class Solution_2_1_26 {

    public static void main(String[] args) {
        int[] nums = new int[]{8,4,2,5};
        defaultInsertionSort(nums);
        System.out.println(Arrays.toString(nums));
    }

    private static void defaultInsertionSort(int[] nums) {
        for (int i = 1; i < nums.length; i ++) {
            for (int j = i; j > 0; j --) {
                if (nums[j] < nums[j - 1]) {
                    int tmp = nums[j];
                    nums[j] = nums[j - 1];
                    nums[j - 1] = tmp;
                }
            }
        }
    }

    private static void insertionSortWithPrimitiveType(Integer[] nums) {
        for (int i = 1; i < nums.length; i ++) {
            for (int j = i; j > 0; j --) {
                if (nums[j] < nums[j - 1]) {
                    int tmp = nums[j];
                    nums[j] = nums[j - 1];
                    nums[j - 1] = tmp;
                }
            }
        }
    }
}
