package com.fastdata.algorithm.easy.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @Author: Lucky
 * @Description: https://leetcode.com/problems/cousins-in-binary-tree/
 * @Date: create in 3/10/21 - 10:13 AM
 */
public class CousinsInBinaryTree {

    public boolean isCousins(TreeNode root, int x, int y) {
        if (root == null) return false;

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        // bfs
        while (q.size() > 0) {
            List<Integer> level = new ArrayList<>();
            int size = q.size();
            for (int i = 0; i < size; i ++) {
                TreeNode temp = q.remove();
                if (temp.left != null && temp.right != null) {
                    if (temp.left.val == x && temp.right.val == y)
                        return false;
                    if (temp.right.val == x && temp.left.val == y)
                        return false;
                }
                level.add(temp.val);

                if (temp.left != null)
                    q.add(temp.left);
                if (temp.right != null)
                    q.add(temp.right);
            }
            if (level.contains(x) && level.contains(y))
                return true;
        }
        return false;
    }
}
