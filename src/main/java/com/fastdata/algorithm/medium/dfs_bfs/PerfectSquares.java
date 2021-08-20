package com.fastdata.algorithm.medium.dfs_bfs;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * @Author: lucky
 * @License: (C) Copyright
 * @Contact: lucky_soft@163.com
 * @Date: 8/20/21 10:55 AM
 * @Version: 1.0
 * @Description: https://leetcode-cn.com/problems/perfect-squares/
 **/

public class PerfectSquares {

    public int numSquares(int n) {
        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> set = new HashSet<>();
        queue.offer(0);
        set.add(0);

        int level = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            level ++;
            for (int i = 0; i < size; i ++) {
                int curr = queue.poll();
                for (int j = 1; j <= n; j ++) {
                    int nodeVal = curr + j * j;
                    if (nodeVal == n) {
                        return level;
                    }
                    if (nodeVal > n) {
                        break;
                    }
                    if (!set.contains(nodeVal)) {
                        queue.offer(nodeVal);
                        set.add(nodeVal);
                    }
                }
            }
        }
        return level;
    }
}
