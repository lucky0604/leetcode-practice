package com.fastdata.algorithm.medium.tree;

import com.fastdata.algorithm.easy.tree.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author: lucky
 * @License: (C) Copyright
 * @Contact: lucky_soft@163.com
 * @Date: 2021-05-19 1:42 PM
 * @Version: 1.0
 * @description: https://leetcode.com/problems/add-one-row-to-tree/
 **/

public class AddOneRowToTree {

    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        /**
         * If depth == 1 that means there is no depth depth - 1 at all,
         * then create a tree node with value val as the new root of the whole original tree,
         * and the original tree is the new root's left subtree.
         */
        if (depth == 1) {
            TreeNode newRoot = new TreeNode(val);
            newRoot.left = root;
            return newRoot;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int d = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i ++) {
                TreeNode curr = queue.poll();

                // handle the insert position d = depth - 1
                if (d == depth - 1) {
                    // loop the right position
                    TreeNode left = new TreeNode(val);
                    TreeNode right = new TreeNode(val);
                    if (curr.left != null) {
                        // insert the new node
                        left.left = curr.left;
                    }
                    if (curr.right != null) {
                        right.right = curr.right;
                    }
                    // connect the curr with new nodes
                    curr.left = left;
                    curr.right = right;

                    // if d is the right position, we don't need execute the conditions below, so just force to get out the loop;
                    continue;
                }

                if (curr.left != null) {
                    queue.offer(curr.left);
                }
                if (curr.right != null) {
                    queue.offer(curr.right);
                }
            }
            d ++;
        }
        return root;
    }
}
