package com.fastdata.algorithm.easy.array;

/**
 * @Author: Lucky
 * @Description: https://leetcode.com/problems/maximum-product-of-two-elements-in-an-array/
 * @Date: create in 1/27/21 - 11:11 AM
 */
public class MaximumProductOfTwoElementsInAnArray {

    public static void main(String[] args) {
        int[] nums = new int[]{};
    }

    public static int maxProduct(int[] nums) {
        int num;
        for (int i = 1; i < nums.length; i ++) {
            int j = i - 1;
            num = nums[i];
            while (j >= 0 && nums[j] > num) {
                nums[j + 1] = nums[j];
                j --;
            }
            nums[j + 1] = num;
        }
        return (nums[nums.length - 1] - 1) * (nums[nums.length - 2] -1);
    }
}
