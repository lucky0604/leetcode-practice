package com.fastdata.algorithm.easy.queue_stack;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: lucky
 * @License: (C) Copyright
 * @Contact: lucky_soft@163.com
 * @Date: 8/18/21 12:02 PM
 * @Version: 1.0
 * @Description: https://leetcode-cn.com/problems/moving-average-from-data-stream/
 **/

public class MovingAverage {

    List<Integer> queue = new ArrayList<>();

    int size;

    public MovingAverage(int size) {
        this.size = size;
    }

    public double next(int val) {
        queue.add(val);
        int windowSum = 0;
        for (int i = Math.max(0, queue.size() - size); i < queue.size();  ++ i) {
            windowSum += queue.get(i);
        }

        return windowSum * 1.0 / Math.min(queue.size(), size);
    }
}
