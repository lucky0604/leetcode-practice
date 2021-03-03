package com.fastdata.algorithm.medium.heap;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @Author: Lucky
 * @Description: https://leetcode.com/problems/kth-smallest-element-in-a-sorted-matrix/
 * @Date: create in 3/3/21 - 12:27 PM
 */
public class KthSmallestElementInASortedMatrix {
    public int kthSmallest(int[][] matrix, int k) {
        Queue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < matrix.length; i ++) {
            for (int j = 0; j < matrix[i].length; j ++) {
                pq.add(matrix[i][j]);
            }
        }
        while (!pq.isEmpty() && k > 1) {
            pq.poll();
            k --;
        }
        return pq.peek();
    }
}
