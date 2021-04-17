package com.fastdata.algorithm.medium.sort.insertion_sort;

import com.fastdata.algorithm.easy.tree.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author lucky
 * @Description
 * @Filename null.java
 * @create 2021-04-17 上午11:24
 */

public class CompleteBinaryTreeInserter {

    private TreeNode root;
    private Queue<TreeNode> queue;

    public CompleteBinaryTreeInserter(TreeNode root) {
        this.root = root;
        queue = new LinkedList<>();
        if (root != null) queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode n = queue.peek();
            if (n.left != null) queue.offer(n.left);
            if (n.right != null) queue.offer(n.right);
            if (n.left != null && n.right != null) {
                queue.poll();
            } else {
                break;
            }
        }
    }

    public int insert(int v) {
        TreeNode n = queue.peek();
        if (n != null) {
            TreeNode newNode = new TreeNode(v);
            if (n.left == null) n.left = newNode;
            else if (n.right == null) n.right = newNode;
            queue.offer(newNode);
            if (n.left != null && n.right != null) queue.poll();
        }
        return n.val;
    }

    public TreeNode get_root() {
        return root;
    }
}
