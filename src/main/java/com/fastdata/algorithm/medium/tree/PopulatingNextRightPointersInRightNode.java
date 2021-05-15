package com.fastdata.algorithm.medium.tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author: lucky
 * @License: (C) Copyright
 * @Contact: lucky_soft@163.com
 * @Date: 5/14/21 10:19 AM
 * @Version: 1.0
 * @description: https://leetcode.com/problems/populating-next-right-pointers-in-each-node/
 **/

public class PopulatingNextRightPointersInRightNode {

    private class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;
        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }

    public Node connect(Node root) {
        if (root == null) {
            return null;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (queue.size() > 0) {
            int size = queue.size();
            for (int i = 0; i < size; i ++) {
                Node curr = queue.poll();
                if (i == size - 1) {
                    curr.next = null;
                } else {
                    curr.next = queue.peek();
                }

                if (curr.left != null) {
                    queue.add(curr.left);
                }
                if (curr.right != null) {
                    queue.add(curr.right);
                }
            }
        }
        return root;
    }
}
