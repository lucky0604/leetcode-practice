package com.fastdata.algorithm.easy.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Lucky
 * @Description: https://leetcode.com/problems/leaf-similar-trees/
 * @Date: create in 1/13/21 - 10:12 AM
 */
public class LeafSimilarTrees {
    /**
     * 基本思路：
     * 1, 遍历整棵树，若节点的左右子节点都为null，则为leaf value
     * 2, 将对比的两棵树的leaf value存入两个list
     * 3, 利用equals判断是否相等
     */

    List<Integer> rootList1 = new ArrayList<>();
    List<Integer> rootList2 = new ArrayList<>();

    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        dfs(root1, rootList1);
        dfs(root2, rootList2);

//        if (rootList1.equals(rootList2)) {
//            return true;
//        } else {
//            return false;
//        }
        return rootList1.equals(rootList2) == true ? true : false;
    }

    private void dfs(TreeNode root, List<Integer> rootList) {
        if (root == null) return;
        dfs(root.left, rootList);
        dfs(root.right, rootList);
        if (root.left == null && root.right == null) {
            rootList.add(root.val);
        }
    }

}
