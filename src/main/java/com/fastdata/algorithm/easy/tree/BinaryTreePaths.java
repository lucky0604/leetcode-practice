package com.fastdata.algorithm.easy.tree;

import java.util.LinkedList;
import java.util.List;

/**
 * @Author: Lucky
 * @Description: https://leetcode.com/problems/binary-tree-paths/
 * @Date: create in 1/15/21 - 11:16 AM
 */
public class BinaryTreePaths {

    List<String> ret = new LinkedList<>();

    public List<String> binaryTreePaths(TreeNode root) {
        // corner case
        if (root == null) return null;
        dfs(root, ret, "");
        return ret;
    }

    private void dfs(TreeNode root, List<String> ret, String curr) {
        if (root == null) return;
        curr += root.val;
        dfs(root.left, ret, curr + "->");
        dfs(root.right, ret, curr + "->");
        if (root.left == null && root.right == null) ret.add(curr);
    }
}
