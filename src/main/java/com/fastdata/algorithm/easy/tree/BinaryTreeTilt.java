package com.fastdata.algorithm.easy.tree;

/**
 * @Author: Lucky
 * @Description: https://leetcode.com/problems/binary-tree-tilt/
 * @Date: create in 3/9/21 - 11:21 AM
 */
public class BinaryTreeTilt {

    int res;

    public int findTilt(TreeNode root) {
        res = 0;
        dfs(root);
        return res;
    }

    private int dfs(TreeNode root) {
        if (root == null) return 0;
        int l = dfs(root.left);
        int r = dfs(root.right);
        res += Math.abs(l - r);
        return l + r + root.val;
    }
}
