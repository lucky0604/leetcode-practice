package com.fastdata.algorithm.easy.binary_search;

import java.util.Arrays;

/**
 * @Author: Lucky
 * @Description: https://leetcode.com/problems/binary-search/
 * @Date: create in 12/21/20 - 11:09 AM
 */
public class BinarySearch {
    public static void main(String[] args) {
        int result = search(new int[]{-1,0,3,5,9,12}, 9);
        System.out.println("resutl = " + result);
    }

    public static int search(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        if (nums.length == 1 && nums[start] == target) return start;
        while (start <= end) {
            int mid = Math.round((start + end) / 2);
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                start ++;
            } else {
                end --;
            }
        }
        return -1;
    }
}
