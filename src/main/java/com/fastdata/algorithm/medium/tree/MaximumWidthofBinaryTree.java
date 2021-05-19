package com.fastdata.algorithm.medium.tree;

import com.fastdata.algorithm.easy.tree.TreeNode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/**
 * @Author: lucky
 * @License: (C) Copyright
 * @Contact: lucky_soft@163.com
 * @Date: 2021-05-20 7:25 AM
 * @Version: 1.0
 * @description: https://leetcode.com/problems/maximum-width-of-binary-tree/
 **/

public class MaximumWidthofBinaryTree {

    public int widthOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        Map<TreeNode, Integer> map = new HashMap<>();
        map.put(root, 0);
        int min = 0;
        int max = 0;
        int maxWidth = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i ++) {
                TreeNode curr = queue.poll();
                // get the tree most left node
                if (i == 0) {
                    min = map.get(curr);
                }
                // get the tree most right node
                if (i == size - 1) {
                    max = map.get(curr);
                }
                if (curr.left != null) {
                    queue.add(curr.left);
                    map.put(curr.left, 2 * map.get(curr));
                }
                if (curr.right != null) {
                    queue.add(curr.right);
                    map.put(curr.right, 2 * map.get(curr) + 1);
                }
                map.remove(curr);
            }
            maxWidth = Math.max(maxWidth, max - min + 1);
        }
        return maxWidth;
    }
}
