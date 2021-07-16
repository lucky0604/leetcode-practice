package com.fastdata.algorithm.medium.union_find;

/**
 * @Author: lucky
 * @License: (C) Copyright
 * @Contact: lucky_soft@163.com
 * @Date: 2021/7/12 9:36
 * @Version: 1.0
 * @description: https://leetcode.com/problems/number-of-closed-islands/
 **/

public class NumberOfClosedIslands {

    int[][] g;

    public int closedIsland(int[][] grid) {
        g = grid;
        int rows = grid.length;
        int cols = grid[0].length;
        // mark edge land cells as water cells
        for (int r = 0; r < rows; r ++) {
            dfs(r, 0);
            dfs(r, cols - 1);
        }
        for (int c = 1; c < cols - 1; c ++) {
            dfs(0, c);
            dfs(rows - 1, c);
        }

        // init UF, now count the rest of islands without limit for the edge cells
        UnionFind uf = new UnionFind(g);
        // skip 0 and last row and column
        for (int r = 1; r < rows - 1; r ++) {
            for (int c = 1; c < cols - 1; c ++) {
                if (g[r][c] == 0) {
                    g[r][c] = 1;
                    int coord = r * cols + c;
                    if (r - 1 > 0 && g[r - 1][c] ==0) {
                        uf.union(coord, coord - cols);
                    }
                    if (c - 1 > 0 && g[r][c - 1] == 0) {
                        uf.union(coord, coord - 1);
                    }
                    if (r + 1 < rows - 1 && g[r + 1][c] == 0) {
                        uf.union(coord, coord + cols);
                    }
                    if (c + 1 < cols - 1 && g[r][c + 1] == 0) {
                        uf.union(coord, coord + 1);
                    }
                }
            }
        }
        return uf.count;
    }

    void dfs(int r,  int c) {
        if (g[r][c] == 0) {
            g[r][c] = 1;
            if (r > 0) {
                dfs(r - 1, c);
            }
            if (c > 0) {
                dfs(r, c - 1);
            }
            if (r < g.length - 1) {
                dfs(r + 1, c);
            }
            if (c < g[0].length - 1) {
                dfs(r, c + 1);
            }
        }
    }
}

class UnionFind {
    int[] parent;
    int count = 0;
    int[] ranks;

    UnionFind(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        parent = new int[rows * cols];
        for (int r = 0; r < rows; r ++) {
            for (int c = 0; c < cols; c ++) {
                if (grid[r][c] == 0) {
                    int i = (r * cols) + c;
                    parent[i] = i;
                    count ++;
                }
            }
        }

        ranks = new int[rows * cols];
    }

    int find(int n) {
        if (n != parent[n]) {
            parent[n] = find(parent[n]);
        }
        return parent[n];
    }

    void union(int a, int b) {
        int rootA = find(a);
        int rootB = find(b);

        if (rootA != rootB) {
            if (ranks[rootA] > ranks[rootB]) {
                parent[rootB] = rootA;
            } else if (ranks[rootB] > ranks[rootA]) {
                parent[rootA] = rootB;
            } else {
                parent[rootA] = rootB;
                ranks[rootB] ++;
            }
            count --;
        }
    }
}
