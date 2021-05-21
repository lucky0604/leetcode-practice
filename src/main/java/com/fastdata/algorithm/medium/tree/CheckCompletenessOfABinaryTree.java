package com.fastdata.algorithm.medium.tree;

import com.fastdata.algorithm.easy.tree.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author: lucky
 * @License: (C) Copyright
 * @Contact: lucky_soft@163.com
 * @Date: 2021-05-21 7:56 AM
 * @Version: 1.0
 * @description: https://leetcode.com/problems/check-completeness-of-a-binary-tree/
 **/

public class CheckCompletenessOfABinaryTree {

    /*
    check if :
            1. there is a null node before a treenode (i.e. cousin node) at same level.
    OR
			 2. there is a null node on the above level (w.r.t. some treenode).*/

    public boolean isCompleteTree(TreeNode root) {
        if (root == null) {
            return false;
        }
        boolean flag = false;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i ++) {
                TreeNode curr = queue.poll();
                if (curr == null) {
                    flag = true;
                } else if (flag) {
                    return false;
                } else {
                    queue.add(curr.left);
                    queue.add(curr.right);
                }
            }
        }
        return true;
    }
}
