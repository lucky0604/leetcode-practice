package com.fastdata.algorithm.medium.stack;

/**
 * @Author: Lucky
 * @Description:
 * @Date: create in 1/30/21 - 1:05 PM
 */
public class TreeNode {
    int val;

    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) {
        this.val = val;
    }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
