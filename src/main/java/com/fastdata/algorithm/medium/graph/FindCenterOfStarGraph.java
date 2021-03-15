package com.fastdata.algorithm.medium.graph;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: Lucky
 * @Description: https://leetcode.com/problems/find-center-of-star-graph/
 * @Date: create in 3/15/21 - 10:22 AM
 */
public class FindCenterOfStarGraph {

    public int findCenter(int[][] edges) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < edges.length; i ++) {
            for (int j = 0; j < edges[i].length; j ++) {
                map.put(edges[i][j], map.getOrDefault(edges[i][j], 0) + 1);
            }
        }
        for (Integer i: map.keySet()) {
            if (map.get(i).equals(edges.length)) {
                return i;
            }
        }
        return 0;
    }
}
