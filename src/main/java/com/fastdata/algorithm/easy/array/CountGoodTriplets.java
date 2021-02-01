package com.fastdata.algorithm.easy.array;

/**
 * @Author: Lucky
 * @Description: https://leetcode.com/problems/count-good-triplets/
 * @Date: create in 1/4/21 - 12:14 PM
 */
public class CountGoodTriplets {
    public static void main(String[] args) {

    }

    private static int countGoodTriplets(int[] arr, int a,  int b, int c) {
        int result = 0;
        for (int i = 0; i < arr.length; i ++) {
            for (int j = i + 1; j < arr.length; j ++) {
                for (int k = j + 1; k < arr.length; k ++) {
                    if (Math.abs(arr[i] - arr[j]) <= a && Math.abs(arr[j] - arr[k]) <= b && Math.abs(arr[i] - arr[k]) <= c) {
                        result += 1;
                    }
                }
            }
        }
        return result;
    }
}
