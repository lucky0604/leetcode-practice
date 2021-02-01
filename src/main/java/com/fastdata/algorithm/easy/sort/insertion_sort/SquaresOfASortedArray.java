package com.fastdata.algorithm.easy.sort.insertion_sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @Author: Lucky
 * @Description: https://leetcode.com/problems/squares-of-a-sorted-array/
 * @Date: create in 1/20/21 - 12:35 PM
 */
public class SquaresOfASortedArray {

    public static void main(String[] args) {
//        int[] nums = new int[]{-4,-1,0,3,10};
        int[] nums = new int[]{-7};
        int[] ret = sortedSquares(nums);
        System.out.println("ret = " + Arrays.toString(ret));
//        int i = -4;
//        int j = abs(i);
//        System.out.println("j = " + j);
    }

    public static int[] sortedSquares(int[] nums) {
        // insertion sort solution

        // corner case:
        if (nums == null || nums.length < 1) return nums;

        // nums length
        int length = nums.length;

        // the insertion number
        int insertNum;

        for (int i = 1; i < length; i ++) {
            insertNum = abs(nums[i]);
            // the sorted number counts
            int j = i - 1;
            while (j >= 0 && abs(nums[j]) > abs(insertNum)) {
                nums[j + 1] = abs(nums[j]);
                j --;
            }
            nums[j + 1] = abs(insertNum);
        }
        for (int i = 0; i < length; i ++) {
            nums[i] = nums[i] * nums[i];
        }
        return nums;
    }

    private static int abs(int i) {
        if (i >= 0) return i;
        else return -i;
    }
}
