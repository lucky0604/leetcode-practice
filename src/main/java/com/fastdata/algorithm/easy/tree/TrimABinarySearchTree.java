package com.fastdata.algorithm.easy.tree;

/**
 * @Author: Lucky
 * @Description: https://leetcode.com/problems/trim-a-binary-search-tree/
 * @Date: create in 1/13/21 - 12:47 PM
 */
public class TrimABinarySearchTree {
    public TreeNode trimBST(TreeNode root, int low, int high) {
        // base case
        if (root == null) return null;
        /**
         * 根据BST的定义，左子树小于右子树
         */
        if (root.val < low) return trimBST(root.right, low, high);
        if (root.val > high) return trimBST(root.left, low, high);
        root.left = trimBST(root.left, low, high);
        root.right = trimBST(root.right, low, high);
        return root;
    }
}
