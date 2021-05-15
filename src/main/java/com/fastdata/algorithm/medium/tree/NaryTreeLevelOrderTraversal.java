package com.fastdata.algorithm.medium.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @Author: Lucky
 * @Description: https://leetcode.com/problems/n-ary-tree-level-order-traversal/
 * @Date: created in 2021/5/15 - 20:27
 */
public class NaryTreeLevelOrderTraversal {

    private class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }

    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> ret = new ArrayList<>();
        if (root == null) {
            return ret;
        }

        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        while (queue.size() > 0) {
            int size = queue.size();
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < size; i ++) {
                Node curr = queue.poll();
                list.add(curr.val);
                queue.addAll(curr.children);
            }
            ret.add(list);
        }
        return ret;
    }
}
