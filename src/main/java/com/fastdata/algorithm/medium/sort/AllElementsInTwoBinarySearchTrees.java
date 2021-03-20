package com.fastdata.algorithm.medium.sort;

import com.fastdata.algorithm.easy.tree.TreeNode;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * @Author: Lucky
 * @Description: https://leetcode.com/problems/all-elements-in-two-binary-search-trees/
 * @Date: create in 3/20/21 - 9:48 AM
 */
public class AllElementsInTwoBinarySearchTrees {

    List<Integer> merge = new ArrayList<>();

    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        dfs(root1);
        dfs(root2);
        Collections.sort(merge);
        return merge;
    }

    private void dfs(TreeNode root) {
        if (root == null) return;
        dfs(root.left);
        dfs(root.right);
        merge.add(root.val);
    }
}
