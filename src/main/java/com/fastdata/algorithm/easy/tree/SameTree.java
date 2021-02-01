package com.fastdata.algorithm.easy.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Lucky
 * @Description: https://leetcode.com/problems/same-tree/
 * @Date: create in 1/15/21 - 10:05 AM
 */
public class SameTree {
    /**
     * 基本思路：
     * @param p
     * @param q
     * @return
     */
    boolean flag = true;
    public boolean isSameTree(TreeNode p, TreeNode q) {
        // corner case
        dfs(p, q);
        return flag;
    }

    private void dfs(TreeNode p, TreeNode q) {
        if (p == null && q == null) return;
        if ((p == null && q != null) || (p != null && q == null)) {
            flag = false;
            return;
        }
        if (p.val != q.val) {
            flag = false;
            return;
        }
        dfs(p.left, q.left);
        dfs(p.right, q.right);
    }
}
