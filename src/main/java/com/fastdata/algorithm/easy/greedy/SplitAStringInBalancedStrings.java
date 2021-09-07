package com.fastdata.algorithm.easy.greedy;

/**
 * @Author: lucky
 * @License: (C) Copyright
 * @Contact: lucky_soft@163.com
 * @Date: 9/7/21 10:19 PM
 * @Version: 1.0
 * @Description: https://leetcode-cn.com/problems/split-a-string-in-balanced-strings/
 **/

public class SplitAStringInBalancedStrings {

    public int balancedStringSplit(String s) {
        int ret = 0;
        int n = 0;
        for (int i = 0; i < s.length(); i ++) {
            char c = s.charAt(i);
            if (c == 'L') {
                n ++;
            } else {
                n --;
            }
            if (n == 0) {
                ret ++;
            }
        }
        return ret;
    }
}
