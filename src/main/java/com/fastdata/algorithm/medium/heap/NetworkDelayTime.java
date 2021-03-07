package com.fastdata.algorithm.medium.heap;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * @Author: Lucky
 * @Description: https://leetcode.com/problems/network-delay-time/
 * @Date: created in 2021/3/7 - 17:59
 */
// TODO: to be understand
public class NetworkDelayTime {

    public int networkDelayTime(int[][] times, int n, int k) {
        Map<Integer, Map<Integer, Integer>> map = new HashMap<>();
        for (int[] time: times) {
            int source = time[0];
            int dest = time[1];
            int duration = time[2];
            map.putIfAbsent(source, new HashMap<>());
            map.get(source).put(dest, duration);
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((p, q) -> p[0] - q[0]);
        pq.add(new int[] {0, k});

        boolean[] visited = new boolean[n + 1];
        int result = 0;
        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int distance = curr[0];
            int node = curr[1];

            if (visited[node]) continue;
            visited[node] = true;
            result = distance;
            n --;

            if (map.containsKey(node)) {
                for (int next: map.get(node).keySet()) {
                    pq.add(new int[]{distance + map.get(node).get(next), next});
                }
            }
        }

        return n == 0 ? result: -1;
    }
}
