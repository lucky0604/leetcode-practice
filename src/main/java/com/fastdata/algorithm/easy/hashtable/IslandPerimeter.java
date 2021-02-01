package com.fastdata.algorithm.easy.hashtable;

/**
 * @Author: Lucky
 * @Description: https://leetcode.com/problems/island-perimeter/
 * @Date: create in 1/18/21 - 10:09 AM
 */
// TODO: to be understand
public class IslandPerimeter {
    public int islandPerimeter(int[][] grid) {
        if (grid.length == 0 && grid[0].length == 0) return 0;
        // 定义island
        int land = 0;
        // 多少次重合
        int overlap = 0;
        // 遍历二维数组
        for (int i = 0; i < grid.length; i ++) {
            for (int j = 0; j < grid[i].length; j ++) {
                // 如果是land
                if (grid[i][j] == 1) {
                    land ++;
                    // 判断当前land下一行是否是land，是的话则重合
                    if (i < grid.length - 1 && grid[i][j] == grid[i + 1][j]) {
                        overlap ++;
                    }
                    // 判断右边元素是否是land, 是的话则重合
                    if (j < grid[i].length - 1 && grid[i][j] == grid[i][j + 1]) {
                        overlap ++;
                    }
                }
            }
        }
        // 一个land有四条边，一次重合是2条边
        return 4 * land - 2 * overlap;
    }
}
