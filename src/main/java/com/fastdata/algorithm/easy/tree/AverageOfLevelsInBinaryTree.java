package com.fastdata.algorithm.easy.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @Author: Lucky
 * @Description: https://leetcode.com/problems/average-of-levels-in-binary-tree/
 * @Date: create in 1/13/21 - 11:38 AM
 */
public class AverageOfLevelsInBinaryTree {
    /**
     * BFS问题
     * BFS使用队列数据结构，先进先出特性
     * @param root
     * @return
     */

    public List<Double> averageOfLevels(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<Double> result = new ArrayList<>();
        if (root != null) queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            long sum = 0;
            for (int i = 0; i < size; i ++) {
                TreeNode node = queue.poll();
                sum += node.val;
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            result.add((double) sum / size);
        }
        return result;
    }
}
