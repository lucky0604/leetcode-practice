package com.fastdata.algorithm.medium.sort;


import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * @ClassName: SellDiminishingValuedColoredBalls
 * @Description: TODO: to be understand
 * @Create by: lucky
 * @Date: 4/12/21 11:14 AM
 */

public class SellDiminishingValuedColoredBalls {

    private long mod = 1000000007L;

    public int maxProfit(int[] inventory, int order) {

        PriorityQueue<Long> pq = new PriorityQueue<>((a, b) -> Long.compare(b, a));
        pq.offer(0L);

        // use map count the balls
        Map<Long, Long> map = new HashMap<>();
        map.put(0L, 0L);

        for (int j : inventory) {
            long i = (long) j;
            if (map.containsKey(i)) {
                map.put(i, map.get(i) + 1);
            } else {
                pq.offer(i);
                map.put(i, 1L);
            }
        }

        long res = 0;
        while (order > 0) {
            long ball = pq.poll();
            long nextBall = pq.peek();
            long times = map.get(ball);
            long diff = Math.min(ball - nextBall, order / times);
            if (diff == 0) {
                res = (res + order * ball) % mod;
                break;
            }
            long sum = (ball * 2 + 1 - diff) * diff / 2 * times;
            res = (res + sum) % mod;
            order -= diff * times;

            if (!map.containsKey(ball - diff)) {
                map.put(ball - diff, map.get(ball));
                pq.offer(ball - diff);
            } else {
                map.put(ball - diff, map.get(ball - diff) + map.get(ball));
            }
            map.remove(ball);
        }
        return (int)res;
    }
}
