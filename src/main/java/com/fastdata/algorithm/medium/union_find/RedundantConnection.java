package com.fastdata.algorithm.medium.union_find;

import java.util.Arrays;

/**
 * @Author: lucky
 * @License: (C) Copyright
 * @Contact: lucky_soft@163.com
 * @Date: 7/20/21 10:31 AM
 * @Version: 1.0
 * @Description: https://leetcode.com/problems/redundant-connection
 **/

public class RedundantConnection {

    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        int[] parent = new int[n + 1];

        Arrays.fill(parent, -1);
        for (int[] edge: edges) {
            int p1 = find(edge[0], parent);
            int p2 = find(edge[1], parent);
            if (p1 != p2) {
                union(p1, p2, parent);
            } else {
                return new int[]{edge[0], edge[1]};
            }
        }
        return new int[]{};
    }

    private int find(int vertex, int[] parent) {
        while (parent[vertex] > -1) {
            vertex = parent[vertex];
        }
        return vertex;
    }

    private void union(int p1, int p2, int[] parent) {
        int totalNodes = parent[p2] + parent[p1];
        if (parent[p1] <= parent[p2]) {
            parent[p2] = p1;
            parent[p1] = totalNodes;
        } else {
            parent[p1] = p2;
            parent[p2] = totalNodes;
        }
    }
}
