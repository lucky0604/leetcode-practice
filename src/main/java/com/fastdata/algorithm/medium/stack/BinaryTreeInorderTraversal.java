package com.fastdata.algorithm.medium.stack;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Lucky
 * @Description: https://leetcode.com/problems/binary-tree-inorder-traversal/
 * @Date: create in 1/30/21 - 1:23 PM
 */
public class BinaryTreeInorderTraversal {

    List<Integer> list = new ArrayList<>();

    public List<Integer> inorderTraversal(TreeNode root) {
        if (root == null) return null;
        dfs(root);
        return list;
    }

    private void dfs(TreeNode root) {
        if (root == null) return;
        dfs(root.left);
        list.add(root.val);
        dfs(root.right);
    }

}
