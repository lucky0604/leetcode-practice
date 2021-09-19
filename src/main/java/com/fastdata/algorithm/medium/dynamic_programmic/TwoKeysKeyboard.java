package com.fastdata.algorithm.medium.dynamic_programmic;

/**
 * @Author: lucky
 * @License: (C) Copyright
 * @Contact: lucky_soft@163.com
 * @Date: 2021/9/19 - 22:34
 * @Version: 1.0
 * @description: https://leetcode-cn.com/problems/2-keys-keyboard/
 **/

public class TwoKeysKeyboard {

    public int minSteps(int n) {
        int[] f = new int[n +1];
        for (int i = 2; i <= n; i ++) {
            f[i] = Integer.MAX_VALUE;
            for (int j = 1; j * j <= i; j ++) {
                if (i % j == 0) {
                    f[i] = Math.min(f[i], f[j] + i / j);
                    f[i] = Math.min(f[i], f[i / j] + j);
                }
            }
        }
        return f[n];
    }
}
