package com.fastdata.algorithm.solutions.ch02.section01;

import java.util.Arrays;

/**
 * @Author: Lucky
 * @Description: Insertion sort without exchanges
 * Develop an implementation of insertion sort
 * that moves larger elements to the right one position with one array access per entry,
 * rather than using exch(). Use SortCompare to evaluate the effectiveness of doing so.
 * @Date: create in 3/31/21 - 12:48 PM
 */
public class Solution_2_1_25 {

    public static void main(String[] args) {
        int[] nums = new int[]{9, 8, 0, 2, 1, 5};
//        insertionSort(nums);
        defaultInsertionSort(nums);
        System.out.println(Arrays.toString(nums));
    }

    private static void insertionSort(int[] nums) {
        for (int i = 1; i < nums.length; i ++) {
            int tmp = nums[i];
            int j = i - 1;
            while (j >= 0 && nums[j] > tmp) {
                nums[j + 1] = nums[j];
                j --;
            }
            nums[j + 1] = tmp;
        }
    }

    private static void defaultInsertionSort(int[] nums) {
        for (int i = 1; i < nums.length; i ++) {
            for (int j = i; j > 0; j --) {
                 if (nums[j - 1] > nums[j]) {
                     int tmp = nums[j];
                     nums[j] = nums[j - 1];
                     nums[j - 1] = tmp;
                 }
            }
        }
    }
}
