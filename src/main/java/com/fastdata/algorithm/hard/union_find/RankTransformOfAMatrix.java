package com.fastdata.algorithm.hard.union_find;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.TreeMap;

/**
 * @Author: lucky
 * @License: (C) Copyright
 * @Contact: lucky_soft@163.com
 * @Date: 8/8/21 10:57 PM
 * @Version: 1.0
 * @Description: https://leetcode.com/problems/rank-transform-of-a-matrix/
 **/

public class RankTransformOfAMatrix {

    int[] parent;

    public int[][] matrixRankTransform(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] ret = new int[m][n];

        // group by matrix val -> {X, Y}
        TreeMap<Integer, List<int[]>> map = new TreeMap<>();
        for (int i = 0; i < m; i ++) {
            for (int j = 0; j < n; j ++) {
                int[] xy = {i, j};
                int val = matrix[i][j];
                if (map.get(val) == null) {
                    map.put(val, new ArrayList<>());
                }
                map.get(val).add(xy);
            }
        }

        // initialize min-rank Array for every COL/ROW
        int[] minX = new int[m];
        int[] minY = new int[n];
        for (Integer key: map.keySet()) {
            List<int[]> list = map.get(key);

            // split to groups using union find for vals in same COL/ROW
            int lSize = list.size();
            parent = new int[lSize];
            for (int i = 0; i < lSize; i ++) {
                parent[i] = i;
            }

            // group the xy by col and row then union by row & by col
            HashMap<Integer, List<Integer>> xMap = new HashMap<>();
            HashMap<Integer, List<Integer>> yMap = new HashMap<>();
            for (int i = 0; i < lSize; i ++) {
                int[] xy = list.get(i);
                int x = xy[0];
                int y = xy[1];

                if (xMap.get(x) == null) {
                    xMap.put(x, new ArrayList<>());
                }
                if (yMap.get(y) == null) {
                    yMap.put(y, new ArrayList<>());
                }
                xMap.get(x).add(i);
                yMap.get(y).add(i);
            }

            // union by X
            for (Integer xKey: xMap.keySet()) {
                List<Integer> xList = xMap.get(xKey);
                for (int i = 1; i < xList.size(); i ++) {
                    union(xList.get(i - 1), xList.get(i));
                }
            }

            // union by Y
            for (Integer yKey: yMap.keySet()) {
                List<Integer> yList = yMap.get(yKey);
                for (int i = 1; i < yList.size(); i ++) {
                    union(yList.get(i - 1), yList.get(i));
                }
            }

            HashMap<Integer, List<int[]>> group = new HashMap<>();
            for (int i = 0; i < lSize; i ++) {
                int grp = find(i);
                if (group.get(grp) == null) {
                    group.put(grp, new ArrayList<>());
                }
                group.get(grp).add(list.get(i));
            }

            // set ret for each group
            for (Integer grpKey: group.keySet()) {
                int max = 1;
                List<int[]> sublist = group.get(grpKey);

                // find max-rank for this group
                for (int[] xy: sublist) {
                    int x = xy[0];
                    int y = xy[1];

                    max = Math.max(max, Math.max(minX[x], minY[y]));
                }

                // update ret = MAX-RANK and set new min-rank for row/col = max-rank + 1
                for (int[] xy: sublist) {
                    int x = xy[0];
                    int y = xy[1];
                    ret[x][y] = max;
                    minX[x] = max + 1;
                    minY[y] = max + 1;
                }
            }
        }

        return ret;
    }

    private void union(int a, int b) {
        int pa = find(a);
        int pb = find(b);
        parent[pb] = pa;
    }

    private int find(int a) {
        int pa = parent[a];
        if (pa != a) {
            parent[a] = find(pa);
            return parent[a];
        } else {
            return a;
        }
    }
}
