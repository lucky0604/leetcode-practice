package com.fastdata.algorithm.medium.tree;

import com.fastdata.algorithm.easy.tree.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @Author: Lucky
 * @Description: https://leetcode.com/problems/kth-smallest-element-in-a-bst/
 * @Date: created in 2021/5/5 - 14:47
 */
public class KthSmallestElementInABST {

    List<Integer> list = new ArrayList<>();

    public int kthSmallest(TreeNode root, int k) {
        if (root == null) return -1;
        treeToList(root);
        Collections.sort(list);
        for (int i = 0; i < k; i ++) {
            if (i >= k) {
                return -1;
            } else if (i == (k - 1)) {
                return list.get(i);
            }
        }
        return -1;
    }

    private void treeToList(TreeNode root) {
        if (root == null) return;
        treeToList(root.left);
        list.add(root.val);
        treeToList(root.right);
    }
}
