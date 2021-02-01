package com.fastdata.algorithm.easy.tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @Author: Lucky
 * @Description: https://leetcode.com/problems/n-ary-tree-preorder-traversal/
 * @Date: create in 1/11/21 - 11:35 AM
 */
public class NaryTreePreorderTraversal {
    public List<Integer> preorder(Node root) {
        /**
         * 前序遍历
         * 基本思路：
         * 类似二叉树的层序遍历，使用栈进行辅助，一个节点出栈时，把其子节点倒序入栈，接着重复此过程，可以实现先序遍历
         */
        Deque<Node> stack = new ArrayDeque<>();
        List<Integer> output = new ArrayList<>();
        if (root == null) return output;
        stack.add(root);
        while (!stack.isEmpty()) {
            root = stack.pollLast();
            output.add(root.val);
            // 将子节点入栈，最左边的节点在栈顶
            for (int i = root.children.size(); i >= 0; i --) {
                stack.add(root.children.get(i));
            }
        }
        return output;
    }
}
