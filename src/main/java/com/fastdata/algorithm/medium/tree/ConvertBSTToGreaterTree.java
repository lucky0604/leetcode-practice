package com.fastdata.algorithm.medium.tree;

import com.fastdata.algorithm.easy.tree.TreeNode;

/**
 * @Author: lucky
 * @License: (C) Copyright
 * @Contact: lucky_soft@163.com
 * @Date: 5/6/21 10:52 AM
 * @Version: 1.0
 * @Description: https://leetcode.com/problems/convert-bst-to-greater-tree/
 **/

public class ConvertBSTToGreaterTree {
    private int sum = 0;

    public TreeNode convertBST(TreeNode root) {
        if (root == null) return null;
        dfs(root);
        return root;
    }

    private void dfs(TreeNode root) {
        if (root == null) {
            return;
        }
        // in-order iterate the tree, and start from the right side
        dfs(root.right);
        sum += root.val;
        root.val = sum;
        dfs(root.left);
    }
}
