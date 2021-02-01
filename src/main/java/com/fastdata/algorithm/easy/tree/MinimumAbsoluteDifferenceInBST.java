package com.fastdata.algorithm.easy.tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @Author: Lucky
 * @Description: https://leetcode.com/problems/minimum-absolute-difference-in-bst/
 * @Date: create in 1/14/21 - 1:09 PM
 */
// TODO: to understand
public class MinimumAbsoluteDifferenceInBST {
    // 定义返回变量
    private int ret = Integer.MAX_VALUE;
    public int getMinimumDifference(TreeNode root) {
        // corner case
        if (root == null) {
            return 0;
        }
        dfs(root);
        return ret;
    }

    private int[] dfs(TreeNode root) {
        if (root.left == null && root.right == null) {
            return new int[]{root.val, root.val};
        }
        int min = root.val;
        int max = root.val;
        if (root.left != null) {
            int[] l = dfs(root.left);
            ret = Math.min(ret, Math.abs(root.val - l[1]));
            min = Math.min(min, l[0]);
        }

        if (root.right != null) {
            int[] r = dfs(root.right);
            ret = Math.min(ret, Math.abs(root.val - r[0]));
            max = Math.max(max, r[1]);
        }

        return new int[]{min, max};
    }
}
