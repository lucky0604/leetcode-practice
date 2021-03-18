package com.fastdata.algorithm.easy.sort.bubble_sort;

/**
 * @Author: Lucky
 * @Description: https://leetcode.com/problems/largest-perimeter-triangle/
 * @Date: create in 3/18/21 - 12:11 PM
 */
public class LargestPerimeterTriangle {

    public int largestPerimeter(int[] nums) {
        // 1, sort the array
        int length = nums.length;
        for (int i = 0; i < length; i ++) {
            for (int j = 0; j < length - 1 - i; j ++) {
                if (nums[j] < nums[j + 1]) {
                    int temp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = temp;
                }
            }
        }
        // 2, check if it is a valid triangle
        for (int i = 0; i < length - 2; i ++) {
            if (check(nums[i], nums[i + 1],  nums[i + 2])) {
                return nums[i] + nums[i + 1] + nums[i + 2];
            }
        }
        return 0;
    }

    private static boolean check(int o1, int o2, int o3) {
        if ((o1 + o2 > o3) && (o1 + o3 > o2) && (o2 + o3) > o1) {
            return true;
        } else {
            return false;
        }
    }

}
