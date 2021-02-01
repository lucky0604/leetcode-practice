package com.fastdata.algorithm.easy.sort.merge_sort;

/**
 * @Author: Lucky
 * @Description: https://leetcode.com/problems/remove-duplicates-from-sorted-array/
 * @Date: create in 1/23/21 - 1:09 PM
 */
public class RemoveDuplicatesFromSortedArray {
    public int removeDuplicates(int[] nums) {
        // corner case:
        if (nums.length == 0) return 0;

        // 记录重复元素的位置索引
        int index = 0;
        for (int i = 0; i < nums.length; i ++) {
            if (nums[i] != nums[index]) {
                // 先让index递增，否则排序为递减排序
                index ++;
                nums[index] = nums[i];
            }
        }
        // 由于index是0开始, +1为最后得到的长度
        index += 1;
        return index;
    }
}
