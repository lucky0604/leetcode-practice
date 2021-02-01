package com.fastdata.algorithm.easy.tree;

/**
 * @Author: Lucky
 * @Description: https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/
 * @Date: create in 1/14/21 - 9:55 AM
 */
public class ConvertSortedArrayToBinarySearchTree {
    /**
     * 基本思路：
     * 利用二分法将数组依次拆分
     * @param nums
     * @return
     */
    public TreeNode sortedArrayToBST(int[] nums) {
        return build(nums, 0, nums.length - 1);
    }

    public TreeNode build(int[] nums, int start, int end) {
        if (start > end) return null;
        int mid = start + (end - start) / 2;        // 等价于(start + end) / 2，但是防止溢出
        TreeNode root = new TreeNode(nums[mid]);
        root.left = build(nums, start, mid - 1);
        root.right = build(nums, mid + 1, end);
        return root;
    }
}
