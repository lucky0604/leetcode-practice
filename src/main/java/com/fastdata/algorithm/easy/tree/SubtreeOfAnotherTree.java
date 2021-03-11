package com.fastdata.algorithm.easy.tree;

/**
 * @Author: Lucky
 * @Description: https://leetcode.com/problems/subtree-of-another-tree/
 * @Date: create in 3/11/21 - 11:40 AM
 */
public class SubtreeOfAnotherTree {

    public boolean isSubtree(TreeNode s, TreeNode t) {
        if (s == null && t == null) return true;
        if (s == null || t == null) return false;
        // if t is s or t is s left subtree or t is s right subtree
        return compareTree(s, t) || isSubtree(s.left, t) || isSubtree(s.right, t);
    }

    private static boolean compareTree(TreeNode s, TreeNode t) {
        if (s == null && t == null) return true;
        if (s == null || t == null) return false;
        // if s val equals t val and s left val equals t left val and s right val equals t right val
        return s.val == t.val && compareTree(s.left, t.left) && compareTree(s.right, t.right);
    }

}
