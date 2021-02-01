package com.fastdata.algorithm.easy.array;

import java.util.Arrays;

/**
 * @Author: Lucky
 * @Description: https://leetcode.com/problems/find-numbers-with-even-number-of-digits/
 * @Date: create in 1/5/21 - 10:56 AM
 */
public class FindNumbersWithEvenNumberOfDigits {
    public static void main(String[] args) {
//        int[] nums = new int[]{555,901,482,1771};
//        int ret = findNumbers(nums);
//        System.out.println("result = " + ret);
        int a = 252;
        System.out.println(String.valueOf(a).length());
    }

    private static int findNumbers(int[] nums) {
        /**
         * 基本思路：
         * 利用String.valueOf方法 将数值转化为字符串，获取长度，取2余数
         */
        int result = 0;
        for (int i = 0; i < nums.length; i ++) {
            if (String.valueOf(nums[i]).length() % 2 == 0) {
                result ++;
            }
        }
        return result;
    }
}
