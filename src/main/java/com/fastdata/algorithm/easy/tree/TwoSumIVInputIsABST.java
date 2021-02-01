package com.fastdata.algorithm.easy.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Lucky
 * @Description: https://leetcode.com/problems/two-sum-iv-input-is-a-bst/
 * @Date: create in 1/14/21 - 11:21 AM
 */
public class TwoSumIVInputIsABST {

    /**
     * 基本思路：
     * 1, flat BST，转化为一个列表
     * 2, 循环列表找到是否有值两个值相加等于k
     * @param root
     * @param k
     * @return
     */
    List<Integer> nodeList = new ArrayList<>();
    public boolean findTarget(TreeNode root, int k) {
        if (root == null) return false;
        dfs(root);
        int end = nodeList.size() - 1;
        for (int i = 0; i < end; i ++) {
            for (int j = i + 1; j < end + 1; j ++) {
                if ((nodeList.get(i) + nodeList.get(j)) == k) {
                    return true;
                }
            }
        }
        return false;
    }

    public void dfs(TreeNode root) {
        if (root == null) return;
        dfs(root.left);
        dfs(root.right);
        nodeList.add(root.val);
    }


}
