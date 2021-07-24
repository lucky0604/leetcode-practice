package com.fastdata.algorithm.medium.tree;

import com.fastdata.algorithm.easy.tree.TreeNode;

/**
 * @Author: lucky
 * @License: (C) Copyright
 * @Contact: lucky_soft@163.com
 * @Date: 7/24/21 9:58 AM
 * @Version: 1.0
 * @Description: https://leetcode.com/problems/binary-tree-pruning/
 **/

public class BinaryTreePruning {

    public TreeNode prunneTree(TreeNode root) {
        return dfs(root) ? root : null;
    }

    private boolean dfs(TreeNode root) {
        if (root == null) {
            return false;
        }

        boolean leftNode = dfs(root.left);
        boolean rightNode = dfs(root.right);

        if (!leftNode) {
            root.left = null;
        }
        if (!rightNode) {
            root.right = null;
        }

        return root.val == 1 || leftNode || rightNode;
    }
}
