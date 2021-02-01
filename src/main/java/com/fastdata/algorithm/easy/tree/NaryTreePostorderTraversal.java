package com.fastdata.algorithm.easy.tree;

import java.util.*;

/**
 * @Author: Lucky
 * @Description: https://leetcode.com/problems/n-ary-tree-postorder-traversal/
 * @Date: create in 1/11/21 - 10:18 AM
 */
public class NaryTreePostorderTraversal {

    /**
     * 后序遍历
     * 基本思路：
     * 利用栈结构进行循环遍历
     * @param root
     * @return
     */
    public List<Integer> postorder(Node root) {
        LinkedList<Node> stack = new LinkedList<>();
        LinkedList<Integer> output = new LinkedList<>();
        if (root == null) return output;
        stack.add(root);
        while (!stack.isEmpty()) {
            Node node = stack.pollLast();
            output.addFirst(node.val);
            for (Node item: node.children) {
                if (node != null) {
                    stack.add(item);
                }
            }
        }
        return output;
    }
}
