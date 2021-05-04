package com.fastdata.algorithm.medium.tree;

import com.fastdata.algorithm.easy.tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Lucky
 * @Description: https://leetcode.com/problems/validate-binary-search-tree/
 * @Date: created in 2021/5/4 - 12:20
 */
public class ValidateBinarySearchTree {

    private static List<Integer> list = new ArrayList<>();

    public boolean isValidBST(TreeNode root) {
        if (root == null) return true;
        checkBST(root);
        for (int i = 0; i < list.size() - 1; i ++) {
            if (list.get(i) >= list.get(i + 1)) {
                return false;
            }
        }
        return true;
    }

    private static void checkBST(TreeNode root) {
        if (root == null) return;
        checkBST(root.left);

        list.add(root.val);

        checkBST(root.right);
    }
}
