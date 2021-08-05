package com.fastdata.algorithm.medium.dfs_bfs;

import com.fastdata.algorithm.easy.tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: lucky
 * @License: (C) Copyright
 * @Contact: lucky_soft@163.com
 * @Date: 8/5/21 2:12 PM
 * @Version: 1.0
 * @Description: https://leetcode.com/problems/path-sum-ii/
 **/

public class PathSumII {

    List<List<Integer>> ret = new ArrayList<>();

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        dfs(root, new ArrayList<>(), 0, targetSum);
        return ret;
    }

    private void dfs(TreeNode root, List<Integer> list, int sum, int target) {
        if (root == null) {
            return;
        }
        list.add(root.val);
        if (root.left == null && root.right == null && sum + root.val == target) {
            ret.add(list);
            return;
        }
        dfs(root.left, new ArrayList<>(list), sum + root.val, target);
        dfs(root.right, new ArrayList<>(list), sum + root.val, target);
    }



}
