package com.fastdata.algorithm.easy.tree;

/**
 * @Author: Lucky
 * @Description: https://leetcode.com/problems/maximum-depth-of-binary-tree/
 * @Date: create in 1/12/21 - 12:22 PM
 */
public class MaximumDepthOfBinaryTree {

    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        return Math.max(1 + maxDepth(root.left), 1 + maxDepth(root.right));
    }

}
