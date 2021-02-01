package com.fastdata.algorithm.easy.tree;

import java.util.*;

/**
 * @Author: Lucky
 * @Description: https://leetcode.com/problems/binary-tree-level-order-traversal-ii/
 * @Date: create in 1/14/21 - 11:57 AM
 */
public class BinaryTreeLevelOrderTraversalII {

    /**
     * BFS层级遍历
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        // 定义队列
        Queue<TreeNode> node = new LinkedList<>();
        // 利用栈存储每层节点列表
        Stack<List<Integer>> levels = new Stack<>();
        if (root != null) {
            node.add(root);
        }
        while (!node.isEmpty()) {
            int size = node.size();
            // 定义当前层级元素存储变量
            List<Integer> level = new ArrayList<>();
            for (int i = 0; i < size; i ++) {
                // 当前节点变量
                TreeNode currNode = node.poll();
                level.add(currNode.val);
                if (currNode.left != null) node.offer(currNode.left);
                if (currNode.right != null) node.offer(currNode.right);
            }
            levels.push(level);
        }
        // 定义返回列表
        List<List<Integer>> ret = new ArrayList<>();
        while (!levels.isEmpty()) {
            ret.add(levels.pop());
        }
        return ret;
    }
}
