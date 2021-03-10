package com.fastdata.algorithm.easy.tree;

/**
 * @Author: Lucky
 * @Description: https://leetcode.com/problems/diameter-of-binary-tree/
 * @Date: create in 3/10/21 - 11:59 AM
 */
public class DiameterOfBinaryTree {

    int ret = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null) return 0;
        dfs(root);
        return ret;
    }

    private int dfs(TreeNode root) {
        if (root == null) return 0;
        int leftHeight = dfs(root.left);
        int rightHeight = dfs(root.right);
        ret = Math.max(ret, leftHeight + rightHeight);
        return 1 + Math.max(leftHeight, rightHeight);
    }
}
