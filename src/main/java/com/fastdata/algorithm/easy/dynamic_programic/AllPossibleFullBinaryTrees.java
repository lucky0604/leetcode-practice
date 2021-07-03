package com.fastdata.algorithm.easy.dynamic_programic;

import com.fastdata.algorithm.easy.tree.Node;
import com.fastdata.algorithm.easy.tree.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: lucky
 * @License: (C) Copyright
 * @Contact: lucky_soft@163.com
 * @Date: 2021/7/3 12:26
 * @Version: 1.0
 * @description: https://leetcode.com/problems/all-possible-full-binary-trees/
 **/

public class AllPossibleFullBinaryTrees {

    public List<TreeNode> allPossibleFBT(int n) {
        return helper(n, new HashMap<>());
    }

    private List<TreeNode> helper(int n, Map<Integer, List<TreeNode>> map) {
        // if result in map, no need for recalculation
        if (map.containsKey(n)) {
            return map.get(n);
        }

        List<TreeNode> trees = new ArrayList<>();

        if (n - 1 == 0) {
            trees.add(new TreeNode(0));
        } else if (n % 2 != 0) {
            int target = n - 1;
            Map<Integer, List<TreeNode>> possibleSubtrees = new HashMap<>();

            // less than n because root is already minus one
            for (int i = 1; i < target; i += 2) {
                possibleSubtrees.put(i, helper(i, map));
            }

            for (int i = 1; i < target; i += 2) {
                List<TreeNode> leftRoots = possibleSubtrees.get(i);
                List<TreeNode> rightRoots = possibleSubtrees.get(target - i);

                for (TreeNode leftRoot: leftRoots) {
                    for (TreeNode rightRoot: rightRoots) {
                        trees.add(new TreeNode(0, leftRoot, rightRoot));
                    }
                }
            }
        }

        map.put(n, trees);
        return trees;
    }
}
