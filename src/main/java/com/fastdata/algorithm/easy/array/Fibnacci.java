package com.fastdata.algorithm.easy.array;

/**
 * @Author: lucky
 * @License: (C) Copyright
 * @Contact: lucky_soft@163.com
 * @Date: 9/4/21 11:07 PM
 * @Version: 1.0
 * @Description: https://leetcode-cn.com/problems/fei-bo-na-qi-shu-lie-lcof/
 **/

public class Fibnacci {

    static final int MOD = 1000000007;

    public int fib(int n) {
        if (n < 2) {
            return n;
        }

        int[][] q = {{1, 1}, {1, 0}};
        int[][] ret = pow(q, n - 1);
        return ret[0][0];
    }

    public int[][] pow(int[][] a, int n) {
        int[][] ret = {{1, 0},  {0, 1}};
        while (n > 0) {
            if ((n & 1) == 1) {
                ret = mutiply(ret, a);
            }
            n >>= 1;
            a = mutiply(a, a);
        }
        return ret;
    }

    public int[][] mutiply(int[][] a, int[][] b) {
        int[][] c = new int[2][2];
        for (int i = 0; i < 2; i ++) {
            for (int j = 0; j < 2; j ++) {
                c[i][j] = (int)(((long) a[i][0] * b[0][j] + (long) a[i][1] * b[1][j]) % MOD);
            }
        }
        return c;
    }
}
