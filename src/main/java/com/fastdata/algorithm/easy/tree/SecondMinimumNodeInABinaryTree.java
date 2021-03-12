package com.fastdata.algorithm.easy.tree;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @Author: Lucky
 * @Description: https://leetcode.com/problems/second-minimum-node-in-a-binary-tree/
 * @Date: create in 3/12/21 - 11:12 AM
 */
public class SecondMinimumNodeInABinaryTree {


    public int findSecondMinimumValue(TreeNode root) {
        if (root == null) return -1;
        int secondMin = dfs(root, root.val);
        return secondMin == root.val ? -1 : secondMin;
    }

    private int dfs(TreeNode root, int val) {
        if (root.left == null) return root.val;
        int left = root.left.val != val ? root.left.val : dfs(root.left, val);
        int right = root.right.val != val ? root.right.val : dfs(root.right, val);
        if (left == val) return right;
        if (right == val) return left;
        return Math.min(left, right);
    }
}
