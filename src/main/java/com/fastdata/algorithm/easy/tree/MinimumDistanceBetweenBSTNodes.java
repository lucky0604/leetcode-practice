package com.fastdata.algorithm.easy.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Lucky
 * @Description: https://leetcode.com/problems/minimum-distance-between-bst-nodes/
 * @Date: create in 1/15/21 - 10:43 AM
 */
public class MinimumDistanceBetweenBSTNodes {

    List<Integer> ret = new ArrayList<>();
    int min = Integer.MAX_VALUE;

    public int minDiffInBST(TreeNode root) {
        if (root == null) return 0;
        dfs(root);
        int size = ret.size();
        if (size == 1) return 0;
        for (int i = 1; i < size; i ++) {
            int distance = ret.get(i) - ret.get(i - 1);
            min = Math.min(distance, min);
        }
        return min;
    }

    private void dfs(TreeNode root) {
        // 使用中序遍历，中序遍历BST可以得到一个有序数组
        if (root.left != null) {
            dfs(root.left);
        }
        ret.add(root.val);
        if (root.right != null) {
            dfs(root.right);
        }
    }
}
