package com.fastdata.algorithm.medium.dfs_bfs;

import com.fastdata.algorithm.easy.tree.TreeNode;

/**
 * @Author: lucky
 * @License: (C) Copyright
 * @Contact: lucky_soft@163.com
 * @Date: 8/17/21 7:10 PM
 * @Version: 1.0
 * @Description: https://leetcode.com/problems/count-good-nodes-in-binary-tree/
 **/

public class CountGoodNodesInBinaryTree {

    int goods = 0;

    public int goodNodes(TreeNode root) {
        dfs(root, Integer.MIN_VALUE);
        return goods;
    }

    private void dfs(TreeNode root, int max) {
        if (root == null) {
            return;
        }
        if (root.val >= max) {
            goods += 1;
            max = root.val;
        }
        dfs(root.left, max);
        dfs(root.right, max);
    }
}
