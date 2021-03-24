package com.fastdata.algorithm.medium.sort;

import java.util.PriorityQueue;

/**
 * @Author: Lucky
 * @Description: https://leetcode.com/problems/largest-submatrix-with-rearrangements/
 * @Date: create in 3/24/21 - 11:44 AM
 */
public class LargestSubmatrixWithRearrangements {

    public int largestSubmatrix(int[][] matrix) {
        // start from row 1
        for (int i = 1; i < matrix.length; i ++) {
            for (int j = 0; j < matrix[i].length; j ++) {
                if (matrix[i][j] == 0) continue;
                else matrix[i][j] = matrix[i - 1][j] + 1;
            }
        }

        int maxSize = 0;
        for (int i = 0; i < matrix.length; i ++) {
            PriorityQueue<Integer> pq = new PriorityQueue<>();  // minheap
            for (int j = 0; j < matrix[i].length; j ++) {
                if (matrix[i][j] > 0) pq.add(matrix[i][j]);
            }
            int size = 0;
            int curr = 0;
            while (!pq.isEmpty()) {
                curr = pq.peek();
                size = curr * pq.size();
                maxSize = Math.max(maxSize, size);
                pq.poll();
            }
        }
        return maxSize;
    }
}
