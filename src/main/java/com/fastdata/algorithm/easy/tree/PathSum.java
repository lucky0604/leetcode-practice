package com.fastdata.algorithm.easy.tree;

/**
 * @Author: Lucky
 * @Description: https://leetcode.com/problems/path-sum/
 * @Date: create in 3/13/21 - 10:07 AM
 */
public class PathSum {

    boolean ret = false;

    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) return false;
        dfs(root, targetSum, 0);
        return ret;
    }

    public void dfs(TreeNode root, int sum, int curr) {
        if (ret) return;

        if (root.left == null && root.right == null) {
            curr += root.val;
            if (curr == sum) ret = true;
            return;
        }

        curr += root.val;
        if (root.left != null) dfs(root.left, sum, curr);
        if (root.right != null) dfs(root.right, sum, curr);

    }
}
