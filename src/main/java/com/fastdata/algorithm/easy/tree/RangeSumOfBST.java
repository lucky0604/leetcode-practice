package com.fastdata.algorithm.easy.tree;

/**
 * @Author: Lucky
 * @Description: https://leetcode.com/problems/range-sum-of-bst/
 * @Date: create in 1/8/21 - 11:26 AM
 */
public class RangeSumOfBST {

    int sum = 0;
    int low = 0;
    int high = 0;
    private int rangeSumBST(TreeNode root, int low, int high) {
        /**
         * 基本思路：
         * BST的遍历
         */
        this.low = low;
        this.high = high;
        traverse(root);
        return sum;
    }

    private void traverse(TreeNode root) {
        if (root == null) return;
        addValue(root.val);
        traverse(root.left);
        traverse(root.right);
    }

    private void addValue(int val) {
        if (val <= high && val >= low) {
            sum += val;
        }
    }
}
