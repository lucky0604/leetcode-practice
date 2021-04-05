package com.fastdata.algorithm.medium.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * @Author: Lucky
 * @Description: https://leetcode.com/problems/car-fleet/
 * @Date: created in 2021/4/5 - 11:53
 */
// TODO: to be understand
public class CarFleet {

    public int carFleet(int target, int[] position, int[] speed) {
        int length = position.length;
        // calculate each car left from target
        int[] dist = new int[length];
        double[] timeArr = new double[length];
        HashMap<Integer, Double> map = new HashMap<>();
        for (int i = 0; i < length; i ++) {
            dist[i] = target - position[i];
            timeArr[i] = (double) dist[i] / (double) speed[i];
            map.put(dist[i], timeArr[i]);
        }
        // the cars with larger distance left & smaller time needed will chase up the car before
        Arrays.sort(dist);
        List<Double> rTimeL = new ArrayList<>();
        for (int i = 0; i < length; i ++) {
            Double time = map.get(dist[i]);
            int m = rTimeL.size();
            if (m == 0 || time > rTimeL.get(m - 1)) {
                rTimeL.add(time);       // new fleet is created
            }
        }
        return rTimeL.size();

    }
}
