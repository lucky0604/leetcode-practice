package com.fastdata.algorithm.easy.dfs_bfs;

/**
 * @Author: lucky
 * @License: (C) Copyright
 * @Contact: lucky_soft@163.com
 * @Date: 8/26/21 10:14 AM
 * @Version: 1.0
 * @Description: https://leetcode-cn.com/problems/flood-fill/
 **/

public class FloodFill {
    /**
     * 将上下左右移动作为两个数组，左右平移为1，0，0，-1，上下平移为0，1，-1，0
     */
    int[] dx = {1, 0, 0, -1};
    int[] dy = {0, 1, -1, 0};

    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int currColor = image[sr][sc];
        if (currColor != newColor) {
            dfs(image, sr, sc, currColor, newColor);
        }
        return image;
    }

    private void dfs(int[][] image, int x, int y, int color, int newColor) {
        if (image[x][y] == color) {
            image[x][y] = newColor;
            for (int i = 0; i < 4; i ++) {
                int mx = x + dx[i];
                int my = y + dy[i];
                if (mx >= 0 && mx < image.length && my >= 0 && my < image[0].length) {
                    dfs(image, mx, my, color, newColor);
                }
            }
        }
    }
}