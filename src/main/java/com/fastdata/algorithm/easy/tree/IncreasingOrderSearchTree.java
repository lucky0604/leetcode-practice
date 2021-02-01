package com.fastdata.algorithm.easy.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Lucky
 * @Description: https://leetcode.com/problems/increasing-order-search-tree/
 * @Tag: DFS问题
 * @Date: create in 1/8/21 - 12:15 PM
 */
public class IncreasingOrderSearchTree {
    public TreeNode increasingBST(TreeNode root) {
        /**
         * 基本思路：
         * 使用中序遍历 - 先左节点，再根节点，再右节点
         */
        // 利用一个list先存储各节点的值
        List<Integer> list = new ArrayList<>();
        // 利用dfs来遍历整棵树，将值存入list
        dfs(root, list);
        // 初始化构造一棵新树, 并赋值root为0
        TreeNode newTree = new TreeNode(0);
        // 创建一个下标, 记录当前位置
        TreeNode cur = newTree;
        // 遍历list，将存入list的值全部放到新树的右节点
        for (Integer val: list) {
            // 因为需要都放在右节点，因此将值都放在右节点上
            cur.right = new TreeNode(val);
            cur = cur.right;
        }
        // 由于初始化第一个节点是0， 因此返回应从新树的right节点返回
        return newTree.right;
    }

    private void dfs(TreeNode root, List<Integer> list) {
        // 递归截止条件
        if (root == null) return;
        // 中序遍历，从左节点走到头, 循环完毕，此时root为最左子节点
        dfs(root.left, list);
        // 当走到头的时候将最左节点的值存到list中
        list.add(root.val);
        // 再循环右节点
        dfs(root.right, list);
    }
}
