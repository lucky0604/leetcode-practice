package com.fastdata.algorithm.medium.dfs_bfs;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @Author: lucky
 * @License: (C) Copyright
 * @Contact: lucky_soft@163.com
 * @Date: 8/27/21 10:10 AM
 * @Version: 1.0
 * @Description: https://leetcode-cn.com/problems/keys-and-rooms/
 **/

public class KeysAndRooms {

    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int n = rooms.size();
        int num = 0;
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[n];
        visited[0] = true;
        queue.offer(0);
        while (!queue.isEmpty()) {
            int x = queue.poll();
            num ++;
            for (int i: rooms.get(x)) {
                if (!visited[i]) {
                    visited[i] = true;
                    queue.offer(i);
                }
            }
        }
        return num == n;
    }
}
