package com.fastdata.algorithm.easy.tree;

/**
 * @Author: Lucky
 * @Description: https://leetcode.com/problems/sum-of-root-to-leaf-binary-numbers/
 * @Date: create in 1/11/21 - 12:02 PM
 */
public class SumOfRootToLeafBinaryNumbers {

    /**
     * 基本思路：
     * 运用dfs
     *
     * Root to Leaf Paths - 1 0 1 = 1 * (2^2) + 0 * (2^1) + 1 * (2^0) = 4 + 0 + 1 = 5,
     * Similarly for 1 0 0 and 1 1.
     *
     * For Path -> 1 0 1
     * At Level 0, curr = 0 + 1 = 1
     * At Level 1, curr = (0 + 1) * 2 + 0 = 2
     * At Level 2, curr = ((0 + 1) * 2 + 0) * 2 + 1 = 2 * 2 + 1 = 5
     */
    int sum = 0;
    public int sumRootToLeaf(TreeNode root) {
        if (root == null) return 0;
        dfs(root, 0);
        return sum;
    }

    private void dfs(TreeNode root, int curr) {
        if (root == null) return;
        curr = curr * 2 + root.val;
        if (root.left == null && root.right == null) {
            sum += curr;
        }
        dfs(root.left, curr);
        dfs(root.right, curr);
    }
}
