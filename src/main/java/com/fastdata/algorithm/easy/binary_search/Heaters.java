package com.fastdata.algorithm.easy.binary_search;

import java.util.Arrays;

/**
 * @Author: lucky
 * @License: (C) Copyright
 * @Contact: lucky_soft@163.com
 * @Date: 2021-05-27 10:37 PM
 * @Version: 1.0
 * @description: https://leetcode.com/problems/heaters/
 **/
// TODO: to be understand
public class Heaters {

    public int findRadius(int[] houses, int[] heaters) {
        Arrays.sort(heaters);
        int minRadius = 0;

        for (int house : houses) {
            // use Arrays binary search function to detect the position
            int index = Arrays.binarySearch(heaters, house);
            int tmpRadius = 0;

            if (index < 0) {
                index = -(index + 1);

                if (index == 0) {
                    tmpRadius = heaters[0] - house;
                } else if (index >= heaters.length) {
                    tmpRadius = house - heaters[heaters.length - 1];
                } else {
                    tmpRadius = Math.min(heaters[index] - house, house - heaters[index - 1]);
                }
            }

            if (tmpRadius > minRadius) { minRadius = tmpRadius; }
        }

        return minRadius;
    }
}
