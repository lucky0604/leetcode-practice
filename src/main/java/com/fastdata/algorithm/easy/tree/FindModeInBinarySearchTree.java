package com.fastdata.algorithm.easy.tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: Lucky
 * @Description: https://leetcode.com/problems/find-mode-in-binary-search-tree/
 * @Date: create in 3/12/21 - 10:18 AM
 */
public class FindModeInBinarySearchTree {

    public int[] findMode(TreeNode root) {
        Map<Integer, Integer> map = new HashMap<>();
        dfs(root, map);

        int frequency = 1;
        List<Integer> modeList = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry: map.entrySet()) {
            int key = entry.getKey();
            int value = entry.getValue();
            if (frequency < value) {
                modeList = new ArrayList<>();
                frequency = value;
            }
            if (frequency == value) {
                modeList.add(key);
            }
        }

        int[] ret = new int[modeList.size()];
        for (int i = 0; i < ret.length; i ++) {
            ret[i] = modeList.get(i);
        }
        return ret;
    }

    private void dfs(TreeNode root, Map<Integer, Integer> map) {
        if (root == null) return;
        map.put(root.val, map.get(root.val)  == null ? 1 : map.get(root.val) + 1);
        dfs(root.left, map);
        dfs(root.right, map);
    }
}
