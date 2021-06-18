package com.fastdata.algorithm.easy.array;

/**
 * @Author: lucky
 * @License: (C) Copyright
 * @Contact: lucky_soft@163.com
 * @Date: 6/1/21 10:37 AM
 * @Version: 1.0
 * @Description: https://leetcode.com/problems/can-place-flowers/
 **/

public class CanPlaceFlowers {

    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        // corner case for n = 0
        if (n == 0) {
            return true;
        }
        int ret = 0;
        int length = flowerbed.length;
        if (length == 1) {
            return flowerbed[0] == 0;
        }
        // loop the array
        for (int i = 0; i < length; i ++) {
            // find the place that can be placed
            if (flowerbed[i] == 0) {
                // handle the first and the end condition
                if (i == 0) {
                    if (flowerbed[i + 1] == 0) {
                        ret ++;
                        flowerbed[0] = 1;
                    }
                } else if (i == length - 1) {
                    if (flowerbed[length - 2] == 0) {
                        ret ++;
                        flowerbed[length - 1] = 1;
                    }
                } else if (flowerbed[i - 1] == 0 && flowerbed[i + 1] == 0) {
                    ret ++;
                    flowerbed[i] = 1;
                }
            }

        }
        return ret >= n;
    }
}
