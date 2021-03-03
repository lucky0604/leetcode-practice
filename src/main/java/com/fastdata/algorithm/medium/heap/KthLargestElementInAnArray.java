package com.fastdata.algorithm.medium.heap;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @Author: Lucky
 * @Description: https://leetcode.com/problems/kth-largest-element-in-an-array/
 * @Date: create in 3/3/21 - 10:28 AM
 */
public class KthLargestElementInAnArray {

    public int findKthLargest(int[] nums, int k) {
        Queue<Integer> pq = new PriorityQueue<>((p, q) -> q - p);
        for (int i = 0; i < nums.length; i ++) {
            pq.add(nums[i]);
        }
        while (!pq.isEmpty() && k > 1) {
            pq.poll();
            k --;
        }
        return pq.peek();
    }
}