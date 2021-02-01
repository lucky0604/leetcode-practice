package com.fastdata.algorithm.easy.tree;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @Author: Lucky
 * @Description: https://leetcode.com/problems/univalued-binary-tree/
 * @Date: create in 1/12/21 - 12:59 PM
 */
public class UnivaluedBinaryTree {

    /**
     * 基本思路：
     * 1，遍历tree，添加到list中
     * 2，判断list中是否有不同元素
     */
    List<Integer> nodeList = new ArrayList<>();

    public boolean isUnivalTree(TreeNode root) {
        if (root == null) return false;
        if (root.left == null && root.right == null) return true;
        dfs(root);
        Set<Integer> uniSet = new HashSet<>(nodeList);
        System.out.println(uniSet.size());
        System.out.println(nodeList.size());
        System.out.println("============================");
        if (uniSet.size() > 1) {
            return false;
        } else {
            return true;
        }
    }

    private void dfs(TreeNode root) {
        if (root == null) return;
        dfs(root.left);
        dfs(root.right);
        nodeList.add(root.val);
    }
}
