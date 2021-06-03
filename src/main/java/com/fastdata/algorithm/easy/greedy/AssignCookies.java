package com.fastdata.algorithm.easy.greedy;

import java.util.Arrays;

/**
 * @Author: lucky
 * @License: (C) Copyright
 * @Contact: lucky_soft@163.com
 * @Date: 2021-06-03 10:32 AM
 * @Version: 1.0
 * @description: https://leetcode.com/problems/assign-cookies/
 **/

public class AssignCookies {

    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int ret = 0;
        int i = 0;
        int j = 0;
        while (i < g.length && j < s.length) {
            if (g[i] <= s[j]) {
                ret ++;
                i ++;
            }
            j ++;
        }
        return ret;
    }
}
