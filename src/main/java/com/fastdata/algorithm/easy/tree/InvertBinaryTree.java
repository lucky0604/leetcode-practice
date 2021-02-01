package com.fastdata.algorithm.easy.tree;

/**
 * @Author: Lucky
 * @Description: https://leetcode.com/problems/invert-binary-tree/
 * @Date: create in 1/13/21 - 9:50 AM
 */
public class InvertBinaryTree {
    public TreeNode invertTree(TreeNode root) {
        /**
         * 基本思路，类似反转swap操作
         */
        if (root == null) return null;
        // 先将当前root的left节点存到变量中
        TreeNode left = root.left;
        root.left = invertTree(root.right);
        root.right = invertTree(left);
        return root;
    }
}
