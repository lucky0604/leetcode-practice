package com.fastdata.algorithm.medium.insertion_sort;

/**
 * @Author: Lucky
 * @Description:
 * @Date: create in 1/25/21 - 10:09 AM
 */
public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {};
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
