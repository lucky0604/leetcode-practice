package com.fastdata.algorithm.hard.tree;

import com.fastdata.algorithm.easy.tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: lucky
 * @License: (C) Copyright
 * @Contact: lucky_soft@163.com
 * @Date: 5/8/21 11:07 AM
 * @Version: 1.0
 * @Description: https://leetcode.com/problems/recover-binary-search-tree/
 **/
// TODO: to be understand
public class RecoveryBinarySearchTree {

    TreeNode inOrderPrev = null;
    TreeNode start = null;
    TreeNode end = null;

    public void recoverTree(TreeNode root) {
        dfs(root);
        int tmp = start.val;
        start.val = end.val;
        end.val = tmp;
    }

    // in-order
    private void dfs(TreeNode root) {
        if (root == null) return;
        dfs(root.left);
        // =======================================
        // check valid BST
        if (inOrderPrev != null && root.val < inOrderPrev.val) {
            if (start == null) start = inOrderPrev; // hold invalid startnode to swap
            end = root;
        }
        inOrderPrev = root;
        // =======================================
        dfs(root.right);
    }
}
