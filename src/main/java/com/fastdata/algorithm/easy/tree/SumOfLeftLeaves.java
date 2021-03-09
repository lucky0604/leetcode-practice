package com.fastdata.algorithm.easy.tree;

/**
 * @Author: Lucky
 * @Description: https://leetcode.com/problems/sum-of-left-leaves/
 * @Date: create in 3/9/21 - 11:35 AM
 */
public class SumOfLeftLeaves {

    int ret = 0;

    public int sumOfLeftLeaves(TreeNode root) {

        if (root == null) return 0;
        if (root.left != null && root.left.left == null && root.left.right == null) {
            ret += root.left.val;
        }

        sumOfLeftLeaves(root.left);
        sumOfLeftLeaves(root.right);

        return ret;
    }

}
