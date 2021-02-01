package com.fastdata.algorithm.easy.array;

import java.util.Arrays;

/**
 * @Author: Lucky
 * @Description: https://leetcode.com/problems/richest-customer-wealth/
 * @Date: create in 12/28/20 - 10:16 AM
 */
public class RichestCustomeerWealth {
    public static void main(String[] args) {
        int[][] accounts = new int[][]{{1,2,3}, {2,3,4}, {4,4,6}};
        int res = maximumWealth(accounts);
        System.out.println("res = " + res);
    }

    public static int maximumWealth(int[][] accounts) {
        int[] temp = new int[accounts.length];
        for (int i = 0; i < accounts.length; i ++) {
            int sum = 0;
            for (int j = 0; j < accounts[i].length; j++) {
                sum += accounts[i][j];
            }
            temp[i] = sum;
        }
        System.out.println("temp = " + Arrays.toString(temp));
        int res = Arrays.stream(temp).max().getAsInt();
        return res;
    }
}
