package com.fastdata.algorithm.medium.heap;

import java.util.*;

/**
 * @Author: Lucky
 * @Description: https://leetcode.com/problems/k-closest-points-to-origin/
 * @Date: create in 2/27/21 - 10:14 AM
 */
public class KClosestPointsToOrigin {


    public int[][] kClosest(int[][] points, int K) {
        if (points.length == 0) return new int[0][0];
        int[] distance = new int[points.length];
        for (int i = 0; i < points.length; i++)
            distance[i] = distance(points[i]);

        // Heap
        Queue<IndexHolder> maxHeap = new PriorityQueue<>((n1, n2) -> n2.distance - n1.distance);
        for (int i = 0; i < distance.length; i++) {
            maxHeap.add(new IndexHolder(distance[i], i));
            if (maxHeap.size() > K)
                maxHeap.poll();
        }

        int j = 0;
        int[][] ret = new int[K][2];
        for (IndexHolder i : maxHeap) {
            ret[j++] = points[i.index];
        }
        return ret;
    }

    private static int distance(int[] point) {
        int result = point[0] * point[0] + point[1] * point[1];
        return result;
    }
}

class IndexHolder {
    int distance;
    int index;
    IndexHolder(int distance, int index) {
        this.distance = distance;
        this.index = index;
    }
}
