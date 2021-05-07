package com.fastdata.algorithm.medium.tree;

import com.fastdata.algorithm.easy.tree.TreeNode;

import java.util.Arrays;

/**
 * @Author: lucky
 * @License: (C) Copyright
 * @Contact: lucky_soft@163.com
 * @Date: 5/7/21 11:10 AM
 * @Version: 1.0
 * @Description: https://leetcode.com/problems/construct-binary-search-tree-from-preorder-traversal/
 **/
// TODO: to be understand
public class ConstructBinarySearchTreeFromPreorderTraversal {

    public TreeNode bstFromPreorder(int[] preorder) {
        int[] index = {0};
        // suppose that initial state is the MAX_VALUE
        int max = Integer.MAX_VALUE;
        return buildBST(preorder, index, max);
    }

    private TreeNode buildBST(int[] preorder, int[] index, int max) {

        if (index[0] > preorder.length - 1 || preorder[index[0]] >= max) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[index[0]]);
        index[0] ++;
        // build all left nodes, and determine the max as the root, then build the right nodes
        root.left = buildBST(preorder, index, root.val);
        root.right = buildBST(preorder, index, max);
        return root;
    }
}
