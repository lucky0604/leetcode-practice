package com.fastdata.algorithm.hard.dynamic_programmic;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * @Author: lucky
 * @License: (C) Copyright
 * @Contact: lucky_soft@163.com
 * @Date: 2021 11:12 PM
 * @Version: 1.0
 * @description: https://leetcode.com/problems/making-a-large-island/
 **/

public class MakingALargeIsland {

    private HashMap<Integer, Integer> isIslandSizes;
    private int n;

    public int largestIsland(int[][] grid) {
        n = grid.length;
        isIslandSizes = new HashMap<>();

        int islandTag = 2;
        for (int row = 0; row < n; row ++) {
            for (int col = 0; col < n; col ++) {
                if (grid[row][col] == 1) {
                    isIslandSizes.put(islandTag, sizeOfIsland(row, col, grid, islandTag ++));
                }
            }
        }
        int max = 1;
        for (Integer i : isIslandSizes.values()) {
            max = Math.max(max, i);
        }
        for (int row = 0; row < n; row ++) {
            for (int col = 0; col < n; col ++) {
                if (grid[row][col] == 0) {
                    max = Math.max(max, maxNeighborValue(row, col, grid));
                }
            }
        }
        return max;
    }

    private int sizeOfIsland(int row, int col, int[][] grid, int islandTag) {
        if (row >= n || col >= n || col < 0 || row < 0) {
            return 0;
        } else if (grid[row][col] != 1) {
            return 0;
        } else {
            grid[row][col] = islandTag;
            return 1 + sizeOfIsland(row + 1, col, grid, islandTag) + sizeOfIsland(row - 1, col, grid, islandTag)
                    + sizeOfIsland(row, col + 1, grid, islandTag) + sizeOfIsland(row, col - 1, grid, islandTag);
        }
    }

    private int maxNeighborValue(int row, int col, int[][] grid) {
        Set<Integer> neighbors = new HashSet<>();
        if (col + 1 < n) {
            neighbors.add(grid[row][col + 1]);
        }
        if (col - 1 >= 0) {
            neighbors.add(grid[row][col - 1]);
        }
        if (row + 1 < n) {
            neighbors.add(grid[row + 1][col]);
        }
        if (row - 1 >= 0) {
            neighbors.add(grid[row - 1][col]);
        }
        int sum = 1;
        for (Integer neighbor: neighbors) {
            sum += isIslandSizes.getOrDefault(neighbor, 0);
        }
        return sum;
    }
}
