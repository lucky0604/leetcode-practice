package com.fastdata.algorithm.medium.insertion_sort;

/**
 * @Author: Lucky
 * @Description: https://leetcode.com/problems/insert-into-a-binary-search-tree/
 * @Date: create in 1/25/21 - 10:09 AM
 */
public class InsertIntoABinarySearchTree {
    public TreeNode insertIntoBST(TreeNode root, int val) {
        // create a new node based on val
        TreeNode node = new TreeNode(val);
        // corner case
        if (root == null) return node;

        TreeNode cur = root;
        while (cur != node) {
            // if left bigger than val
            if (cur.val > val) {
                if (cur.left == null) {
                    cur.left = node;
                }
                cur = cur.left;
            } else {
                if (cur.right == null) {
                    cur.right = node;
                }
                cur = cur.right;
            }
        }
        return root;
    }
}
