package com.fastdata.algorithm.medium.graph;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Lucky
 * @Description: https://leetcode.com/problems/all-paths-from-source-to-target/
 * @Date: create in 3/15/21 - 11:16 AM
 */
public class AllPathsFromSourceToTarget {

    List<List<Integer>> ret = new ArrayList<>();

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        // backtracking and dfs
        List<Integer> path = new ArrayList<>();
        dfs(graph, path, 0);
        return ret;
    }

    private void dfs(int[][] graph, List<Integer> path, int n) {
        // first start with 0
        path.add(n);
        // target is n - 1
        if (n == graph.length - 1) {
            // add a new list
            ret.add(new ArrayList(path));
        } else {
            for (int v: graph[n]) {
                dfs(graph, path, v);
                path.remove(path.size() - 1);
            }
        }
    }
}
