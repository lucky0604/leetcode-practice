package com.fastdata.algorithm.easy.tree;

/**
 * @Author: Lucky
 * @Description: https://leetcode.com/problems/search-in-a-binary-search-tree/
 * @Tag: BST问题
 * @Date: create in 1/8/21 - 12:56 PM
 */
public class SearchInABinarySearchTree {
    public TreeNode searchBST(TreeNode root, int val) {
        // 若root为空，直接返回root
        if (root == null) return root;
        // 当root的值正好为val时，直接返回root
        if (root.val == val) {
            return root;
        } else if (root.val < val) {
            // 若root的值小于val，根据BST的定义，那么递归找右节点
            return searchBST(root.right, val);
        } else {
            // 否则找左节点
            return searchBST(root.left, val);
        }
    }
}
