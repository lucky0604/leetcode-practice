package com.fastdata.algorithm.medium.union_find;

/**
 * @Author: lucky
 * @License: (C) Copyright
 * @Contact: lucky_soft@163.com
 * @Date: 2021/7/11 15:34
 * @Version: 1.0
 * @description: https://leetcode.com/problems/regions-cut-by-slashes/
 **/

public class RegionsCutBySlashes {

    private int[] parent;
    private int[] rank;
    private int regions;

    public int regionsBySlashes(String[] grid) {
        int points = grid.length + 1;
        regions = 1;
        parent = new int[points * points];
        rank = new int[points * points];

        for (int i = 0; i < parent.length; i ++) {
            parent[i] = i;
            rank[i] = 1;
        }

        for (int i = 0; i < points; i ++) {
            for (int j = 0; j < points; j ++) {
                if (i == 0 || j == 0 || i == points - 1 || j == points - 1) {
                    int cellno = i * points + j;
                    // perform union except for 0
                    if (cellno != 0) {
                        union(cellno, 0);
                    }
                }
            }
        }

        // traverse the array over / \ and call union operation
        for (int i = 0; i < grid.length; i ++) {
            String str = grid[i];
            for (int j = 0; j < str.length(); j ++) {
                if (str.charAt(j) == '\\') {
                    // merge i, j and i + 1, j + 1 cells
                    int cellno1 = i * points + j;
                    int cellno2 = (i + 1) * points + j + 1;
                    union(cellno1, cellno2);
                } else if (str.charAt(j) == '/') {
                    // merge i + 1, j and i, j + 1 cells
                    int cellno1 = (i + 1) * points + j;
                    int cellno2 = i * points + j + 1;
                    union(cellno1, cellno2);
                }
            }
        }
        return regions;
    }

    private int find(int n) {
        if (parent[n] == n) {
            return n;
        }

        int tmp = find(parent[n]);
        parent[n] = tmp;
        return tmp;
    }

    private void union(int x, int y) {
        int lx = find(x);
        int ly = find(y);

        if (lx == ly) {
            // circle found
            regions ++;
        } else {
            if (rank[lx] > rank[y]) {
                parent[ly] = lx;
            } else if (rank[lx] < rank[ly]) {
                parent[lx] = ly;
            } else {
                parent[lx] = ly;
                rank[ly] ++;
            }
        }
    }
}
