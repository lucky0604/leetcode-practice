package com.fastdata.algorithm.easy.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author: Lucky
 * @Description: https://leetcode.com/problems/kids-with-the-greatest-number-of-candies/
 * @Date: create in 12/28/20 - 11:27 AM
 */
public class KidsWithTheGreatestNumberOfCandies {
    public static void main(String[] args) {
        int[] candies = new int[]{2,3,4,5,1,3};
        int extraCandies = 3;
        List<Boolean> res = kidsWithCandies(candies, extraCandies);
        System.out.println(" res = " + res);
    }

    private static List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int temp = Arrays.stream(candies).max().getAsInt();
        List<Boolean> res = new ArrayList<>();
        for (int i = 0; i < candies.length; i ++) {
            if ((candies[i] + extraCandies) >= temp) {
                res.add(true);
            } else {
                res.add(false);
            }
        }
        return res;
    }
}
