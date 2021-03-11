package com.fastdata.algorithm.easy.tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author: Lucky
 * @Description: https://leetcode.com/problems/symmetric-tree/
 * @Date: create in 3/11/21 - 10:03 AM
 */
public class SymmetricTree {

    public boolean isSymmetric(TreeNode root) {
        if (root == null || (root.left == null && root.right == null)) return true;
        if (root.left == null || root.right == null) return false;
        return checkSymmetric(root);
    }

    public static boolean checkSymmetric(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root.left);
        queue.add(root.right);
        while (!queue.isEmpty()) {
            for (int i = 0; i < queue.size() / 2; i ++) {
                TreeNode node1 = queue.poll();
                TreeNode node2 = queue.poll();

                if (!compareNodes(node1, node2)) return false;

                if (node1.left != null) {
                    queue.add(node1.left);
                    queue.add(node2.right);
                }
                if (node1.right != null) {
                    queue.add(node1.right);
                    queue.add(node2.left);
                }
            }
        }
        return true;
    }

    public static boolean compareNodes(TreeNode node1, TreeNode node2) {
        if (node1.val != node2.val) return false;
        if (node1.left != null && node2.right == null ||
            node2.right != null && node1.left == null ||
            node1.right != null && node2.left == null ||
            node2.left != null && node1.right == null) return false;
        return true;
    }
}
