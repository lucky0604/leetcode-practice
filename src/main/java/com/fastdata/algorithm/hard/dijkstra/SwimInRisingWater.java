package com.fastdata.algorithm.hard.dijkstra;


import java.util.PriorityQueue;

/**
 * @Author: lucky
 * @License: (C) Copyright
 * @Contact: lucky_soft@163.com
 * @Date: 7/23/21 10:48 AM
 * @Version: 1.0
 * @Description: https://leetcode.com/problems/swim-in-rising-water/
 **/

public class SwimInRisingWater {

    public int swimInWater(int[][] grid) {
        // find the shortest path from (0, 0) to (n - 1, n - 1)
        // the total time is the max element on the path

        int n = grid.length;
        int res = 0;
        boolean[][] visited = new boolean[n][n];

        // each time we choose a smallest cell, representing currently reachable cell at time grid[i][j]
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>((k1, k2) -> grid[k1 / n][k1 % n] - grid[k2 / n][k2 % n]);
        pq.offer(0);

        int[][] dir = new int[][]{{-1, 0}, {1, 0}, {0, 1}, {0, -1}};

        while (!pq.isEmpty()) {
            int pos = pq.poll();
            int curX = pos / n;
            int curY = pos % n;
            // the time to reach to this cell grid[curX][curY] is max(original time, current time)
            res = Math.max(res, grid[curX][curY]);

            if (curX == n - 1 && curY == n - 1) {
                return res;
            }

            // do BFS to search all possible cells
            for (int i = 0; i < 4; i ++) {
                int X = curX + dir[i][0];
                int Y = curY + dir[i][1];
                if (X < 0 || X >= n || Y < 0 || Y >= n || visited[X][Y] == true) {
                    continue;
                }
                visited[X][Y] = true;
                pq.offer(X * n + Y);
            }
        }
        return -1;
    }
}
