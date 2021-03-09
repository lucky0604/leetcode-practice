package com.fastdata.algorithm.medium.heap;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * @Author: Lucky
 * @Description: https://leetcode.com/problems/distant-barcodes/
 * @Date: create in 3/9/21 - 10:13 AM
 */
public class DistantBarcodes {

    public int[] rearrangeBarcodes(int[] barcodes) {
        /**
         * 基本思路：
         * 1，优先处理出现次数最多的数字，因此先统计出现次数最多的数字（Map）
         * 2，使用MaxHeap存放出现的次数
         * 3，因为需要相邻两个数字不同，因此每次从maxHeap中poll两个数字
         */
        int n = barcodes.length;
        Map<Integer, Integer> map = new HashMap<>();
        for (int b: barcodes) {
            map.put(b, map.getOrDefault(b, 0) + 1);
        }

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((p, q) -> map.get(q) - map.get(p));        // 倒序
        maxHeap.addAll(map.keySet());
        int[] ret = new int[n];
        int index = 0;
        while (maxHeap.size() > 0) {
            int curr = maxHeap.poll();
            ret[index ++] = curr;

            if (maxHeap.size() == 0) break;
            int next = maxHeap.poll();
            ret[index ++] = next;
            update(map, maxHeap, curr);
            update(map, maxHeap, next);
        }
        return ret;
    }

    private void update(Map<Integer, Integer> map, PriorityQueue<Integer> maxHeap, int a) {
        if (map.get(a) == 1) {
            map.remove(a);
        } else {
            map.put(a, map.get(a) - 1);
            maxHeap.offer(a);
        }
    }
}
