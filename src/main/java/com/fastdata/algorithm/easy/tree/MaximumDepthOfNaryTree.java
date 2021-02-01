package com.fastdata.algorithm.easy.tree;

/**
 * @Author: Lucky
 * @Description: https://leetcode.com/problems/maximum-depth-of-n-ary-tree/
 * @Date: create in 1/12/21 - 10:09 AM
 */
public class MaximumDepthOfNaryTree {

    public int maxDepth(Node root) {
        /**
         * iteration
         */
//        if (root == null) return 0;
//        int count = 0;
//        for (int i = 0; i < root.children.size(); i ++) {
//            int step = maxDepth(root.children.get(i));
//            count = count > step ? count: step;
//        }
//        return count + 1;
        /**
         * DFS
         */
        if (root == null) return 0;
        // if root is not null, initial depth is 1
        int depth = 1;
        for (Node item: root.children) {
            depth = Math.max(depth, 1 + maxDepth(item));    // 1 + maxDepth(item) will calculate depth recursively
        }
        return depth;
    }

}
