package com.fastdata.algorithm.easy.tree;

/**
 * @Author: Lucky
 * @Description:
 * @Date: create in 1/8/21 - 11:27 AM
 */
public class TreeNode {
    public int val;

    public TreeNode left;

    public TreeNode right;

    TreeNode() {};

    public TreeNode(int val) {
        this.val = val;
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
