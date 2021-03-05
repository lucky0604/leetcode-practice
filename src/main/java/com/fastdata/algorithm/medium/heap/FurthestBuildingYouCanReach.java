package com.fastdata.algorithm.medium.heap;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @Author: Lucky
 * @Description: https://leetcode.com/problems/furthest-building-you-can-reach/
 * @Date: create in 3/5/21 - 10:12 AM
 */
public class FurthestBuildingYouCanReach {

    public int furthestBuilding(int[] heights, int bricks, int ladders) {
        int size = heights.length - 1;
        Queue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < size; i ++) {
            if (heights[i + 1] <= heights[i]) continue;
            int diff = heights[i + 1] - heights[i];
            pq.add(diff);
            if (pq.size() > ladders) {
                bricks -= pq.peek();
                pq.poll();
                if (bricks < 0)
                    return i;
            }
        }
        return size;
    }
}
