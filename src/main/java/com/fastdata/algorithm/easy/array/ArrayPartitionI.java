package com.fastdata.algorithm.easy.array;

/**
 * @Author: Lucky
 * @Description: https://leetcode.com/problems/array-partition-i/
 * @Date: create in 1/28/21 - 10:44 AM
 */
public class ArrayPartitionI {

    public static void main(String[] args) {

    }

    public int arrayPairSum(int[] nums) {
        // sort array first, and it's sure that odd number is min in pairs and sum result is the largest
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
        int sum = 0;
        for (int i = 0; i < nums.length; i ++) {
            if (i % 2 == 0) {
                sum += nums[i];
            }
        }
        return sum;
    }
}
