package com.fastdata.algorithm.medium.union_find;

/**
 * @Author: lucky
 * @License: (C) Copyright
 * @Contact: lucky_soft@163.com
 * @Date: 2021/7/13 10:06
 * @Version: 1.0
 * @description: https://leetcode.com/problems/number-of-provinces/
 **/

public class NumberOfProvinces {

    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        int m = n;
        UnionFind uf = new UnionFind(n);
        for (int i = 0; i < n; i ++) {
            for (int j = i + 1; j < n; j ++) {
                if (isConnected[i][j] == 1) {
                    int res = uf.union(i, j);
                    m += res;
                }
            }
        }
        return m;
    }

    static class UnionFind {
        int[] parent;
        int[] rank;

        public UnionFind(int n) {
            parent = new int[n];
            rank = new int[n];

            for (int i = 0; i < n; i ++ ) {
                parent[i] = i;
            }
        }

        public int union(int x,  int y) {
            int rootx = find(x);
            int rooty = find(y);

            if (rootx != rooty) {
                if (rank[rootx] > rank[rooty]) {
                    parent[rooty] = rootx;
                    rank[rootx] ++;
                } else {
                    parent[rootx] = rooty;
                    rank[rooty] ++;
                }
                return -1;
            }
            return 0;
        }

        public int find(int n) {
            if (parent[n] == n) {
                return n;
            }
            int root = find(parent[n]);
            parent[n] = root;
            return root;
        }
    }
}
