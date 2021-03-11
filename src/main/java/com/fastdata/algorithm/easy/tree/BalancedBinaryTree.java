package com.fastdata.algorithm.easy.tree;

/**
 * @Author: Lucky
 * @Description: https://leetcode.com/problems/balanced-binary-tree/
 * @Date: create in 3/11/21 - 11:14 AM
 */
public class BalancedBinaryTree {

    public boolean isBalanced(TreeNode root) {
        if (root == null) return true;
        int leftHeight = isHeight(root.left);
        int rightHeight = isHeight(root.right);
        // if the left height and right height different than 1, then is not balanced
        if (Math.abs(leftHeight - rightHeight) > 1) return false;
        return isBalanced(root.left) && isBalanced(root.right);
    }

    public static int isHeight(TreeNode root) {
        // if root is null, height is 0
        if (root == null) return 0;
        // compute left height
        int leftHeight = isHeight(root.left);
        // compute right height
        int rightHeigt = isHeight(root.right);
        //return the tree height, the bigger one plus 1 is the tree's height
        return Math.max(leftHeight, rightHeigt) + 1;
    }
}
