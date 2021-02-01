package com.fastdata.algorithm.easy.tree;

/**
 * @Author: Lucky
 * @Description: https://leetcode.com/problems/merge-two-binary-trees/
 * @Date: create in 1/8/21 - 11:55 AM
 */
public class MergeTwoBinaryTree {

    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        // 若t1是null, 直接返回t2
        if (t1 == null) {
            return t2;
        }
        // 若t2是null, 直接返回t1
        if (t2 == null) {
            return t1;
        }
        // 若t1, t2都是TreeNode，则创建mergeTree
        TreeNode newNode = new TreeNode(t1.val + t2.val);
        newNode.left = mergeTrees(t1.left, t2.left);
        newNode.right = mergeTrees(t1.right, t2.right);
        return newNode;
    }
}
