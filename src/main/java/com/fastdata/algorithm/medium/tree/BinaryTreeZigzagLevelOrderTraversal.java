package com.fastdata.algorithm.medium.tree;

import com.fastdata.algorithm.easy.tree.TreeNode;

import java.util.*;

/**
 * @Author: Lucky
 * @Description: https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/
 * @Date: created in 2021/5/11 - 22:04
 */
public class BinaryTreeZigzagLevelOrderTraversal {

    List<List<Integer>> list = new ArrayList<>();
    boolean oddIteration = false;

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if (root == null)
            return list;
        levelOrderTraversal(root);
        return list;
    }

    private void levelOrderTraversal(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (queue.size() > 0) {
            int size = queue.size();
            List<Integer> currList = new ArrayList<>();
            for (int i = 0; i < size; i ++) {
                TreeNode curr = queue.poll();
                currList.add(curr.val);
                if (curr.left != null) queue.add(curr.left);
                if (curr.right != null) queue.add(curr.right);
            }

            if (oddIteration == true)
                Collections.reverse(currList);
            list.add(currList);
            oddIteration = oddIteration == false ? true: false;
        }
    }
}
