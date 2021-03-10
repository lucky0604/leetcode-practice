package com.fastdata.algorithm.easy.tree;

/**
 * @Author: Lucky
 * @Description: https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/
 * @Date: create in 3/10/21 - 11:38 AM
 */
public class LowestCommonAncestorOfABinarySearchTree {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // BST:
        // left value < root value < right value
        if (root == null || root == p || root == q) return root;

        int rootVal = root.val;
        int pVal = p.val;
        int qVal = q.val;

        // if p, q in the same side
        // left side
        if (rootVal > pVal && rootVal > qVal) {
            return lowestCommonAncestor(root.left, p, q);
        } else if (rootVal < pVal && rootVal < qVal) {
            // right side
            return lowestCommonAncestor(root.right, p, q);
        } else {
            // p, q in different side
            return root;
        }
    }
}
