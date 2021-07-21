package com.fastdata.algorithm.medium.dynamic_programmic;

/**
 * @Author: lucky
 * @License: (C) Copyright
 * @Contact: lucky_soft@163.com
 * @Date: 7/21/21 11:25 AM
 * @Version: 1.0
 * @Description: https://leetcode.com/problems/count-servers-that-communicate/
 **/

public class CountServersThatCommunicate {

    public int countServers(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[] dx = new int[m];
        int[] dy = new int[n];
        for (int i = 0; i < m; i ++) {
            for (int j = 0; j < n; j ++) {
                dx[i] += grid[i][j];
            }
        }
        for (int j = 0; j < n; j ++) {
            for (int i = 0; i < m; i ++) {
                dy[j] += grid[i][j];
            }
        }

        // no is number of servers not connected, s is the sum of all servers
        int no = 0;
        int s = 0;
        for (int i = 0; i < m; i ++) {
            s += dx[i];
            if (dx[i] == 1) {    // this line has only one server, test whether it is the only server on this column
                for (int j = 0; j < n; j ++) {
                    if (grid[i][j] == 1 && dy[j] == 1) {
                        no ++;
                    }
                }
            }
        }

        return s - no;
    }
}
