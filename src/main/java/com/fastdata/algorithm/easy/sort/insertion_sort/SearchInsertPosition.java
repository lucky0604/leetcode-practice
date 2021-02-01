package com.fastdata.algorithm.easy.sort.insertion_sort;

import java.util.Arrays;

/**
 * @Author: Lucky
 * @Description: https://leetcode.com/problems/search-insert-position/
 * @Date: create in 1/21/21 - 12:22 PM
 */
public class SearchInsertPosition {

    public static void main(String[] args) {
        int[] nums = new int[]{1,3,5,6};
        int target = 5;
        int ret = searchInsert(nums, target);
        System.out.println("ret = " + ret);
    }

    public static int searchInsert(int[] nums, int target) {
        // search target if it is in nums
        int index = 0;
        if (nums.length <= 1) {
            if (target > nums[0]) {
                index = 1;
            } else {
                index = 0;
            }
        }
        for (int i = 1; i < nums.length; i ++) {
            int j = i - 1;
            if (nums[j] == target) {
                index = j;
            } else if (target > nums[nums.length - 1]){
                index = nums.length;
            } else {
                while (j >= 0 && nums[j] >= target) {
                    nums[j + 1] = nums[j];
                    j --;
                }
//                nums[i + 1] = target;
                index = j + 1;
            }
        }
        return index;
    }
}
