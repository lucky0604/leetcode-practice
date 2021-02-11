package com.fastdata.algorithm.easy.hashtable;

import java.util.HashSet;

/**
 * @Author: Lucky
 * @Description: https://leetcode.com/problems/distribute-candies/
 * @Date: created in 2021/2/11 - 10:53
 */
public class DistributeCandies {

    public static void main(String[] args) {
        System.out.println(3 % 2);
    }

    public int distributeCandies(int[] candyType) {
        HashSet<Integer> typeSet = new HashSet<>();
        for (int i = 0; i < candyType.length; i ++) {
            typeSet.add(candyType[i]);
        }
        return Math.min(typeSet.size(), candyType.length / 2);
    }
}
