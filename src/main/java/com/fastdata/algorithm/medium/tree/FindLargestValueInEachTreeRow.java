package com.fastdata.algorithm.medium.tree;

import com.fastdata.algorithm.easy.tree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @Author: lucky
 * @License: (C) Copyright
 * @Contact: lucky_soft@163.com
 * @Date: 5/18/21 10:23 AM
 * @Version: 1.0
 * @Description: https://leetcode.com/problems/find-largest-value-in-each-tree-row/
 **/

public class FindLargestValueInEachTreeRow {

    public List<Integer> largestValue(TreeNode root) {
        List<Integer> ret = new ArrayList<>();

        if (root == null) {
            return ret;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int max = Integer.MIN_VALUE;
        while (!queue.isEmpty()) {
            // need to init max for negative value
            max = Integer.MIN_VALUE;
            int size = queue.size();
            for (int i = 0; i < size; i ++) {
                TreeNode curr = queue.poll();
                max = Math.max(max, curr.val);

                if (curr.left != null) {
                    queue.add(curr.left);
                }
                if (curr.right != null) {
                    queue.add(curr.right);
                }
            }
            ret.add(max);
        }
        return ret;
    }


}
