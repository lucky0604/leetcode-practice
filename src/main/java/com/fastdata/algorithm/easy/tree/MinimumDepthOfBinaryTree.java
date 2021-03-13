package com.fastdata.algorithm.easy.tree;

/**
 * @Author: Lucky
 * @Description: https://leetcode.com/problems/minimum-depth-of-binary-tree/
 * @Date: create in 3/13/21 - 10:23 AM
 */
public class MinimumDepthOfBinaryTree {

    public int minDepth(TreeNode root) {
        if (root == null) return 0;
        return dfs(root, 1);
    }

    public int dfs(TreeNode root, int level) {
        if (root.left == null && root.right == null) return level;

        // if left node is null, recursive the right sub tree
        if (root.left == null)
            return dfs(root.right, level + 1);
        if (root.right == null)
            return dfs(root.left, level + 1);
        return Math.min(dfs(root.left, level + 1), dfs(root.right, level + 1));
    }
}
