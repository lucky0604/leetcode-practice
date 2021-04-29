package com.fastdata.algorithm.medium.sort;


import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @ClassName: MaximumNumberOfEventsThatCanBeAttended
 * @Description: https://leetcode.com/problems/maximum-number-of-events-that-can-be-attended/
 * @Create by: lucky
 * @Date: 4/13/21 10:55 AM
 */

public class MaximumNumberOfEventsThatCanBeAttended {

    public int maxEvents(int[][] events) {
        int i = 0;
        int length = events.length;
        int count = 0;
        Arrays.sort(events, (o1, o2) -> Integer.compare(o1[0], o2[0]));
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int d = 1; d <= 100000; d ++) {
            while (i < length && events[i][0] == d) {
                pq.add(events[i ++][1]);
            }
            while (!pq.isEmpty() && pq.peek() < d) {
                pq.poll();
            }
            if (!pq.isEmpty()) {
                count += 1;
                pq.poll();
            }
        }
        return count;
    }
}
