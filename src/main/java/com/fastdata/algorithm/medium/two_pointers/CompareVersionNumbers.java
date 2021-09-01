package com.fastdata.algorithm.medium.two_pointers;

/**
 * @Author: lucky
 * @License: (C) Copyright
 * @Contact: lucky_soft@163.com
 * @Date: 9/1/21 10:58 PM
 * @Version: 1.0
 * @Description: https://leetcode-cn.com/problems/compare-version-numbers/
 **/

public class CompareVersionNumbers {

    public int compareVersion(String version1, String version2) {
        int m = version1.length();
        int n = version2.length();
        int i = 0;
        int j = 0;
        while (i < m || j < n) {
            int x = 0;
            for (; i < m && version1.charAt(i) != '.'; i ++) {
                x = x * 10 + version1.charAt(i) - '0';
            }
            i ++;
            int y = 0;
            for (; j < n && version2.charAt(j) != '.'; j ++) {
                y = y * 10 + version2.charAt(j) - '0';
            }
            j ++;
            if (x != y) {
                return x > y ? 1: -1;
            }
        }
        return 0;
    }
}
