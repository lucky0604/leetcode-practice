package com.fastdata.algorithm.medium.string;

import java.util.Arrays;

/**
 * @Author: lucky
 * @License: (C) Copyright
 * @Contact: lucky_soft@163.com
 * @Date: 2021-06-10 10:37 AM
 * @Version: 1.0
 * @description: https://leetcode.com/problems/string-compression/
 **/

public class StringCompression {

    public static int compress(char[] chars) {

        int length = chars.length;
        if (length == 1) {
            return length;
        }
        // i for in-place change
        int i = 0;
        int left = 0;
        int right = 0;
        while (right < length) {
            int count = 0;
            char c = chars[left];
            while (right < chars.length && chars[right] == c) {
                count ++;
                right ++;
            }
            chars[i] = c;
            i ++;

            if (count > 1) {
                for (char character: Integer.toString(count).toCharArray()) {
                    chars[i] = character;
                    i ++;
                }
            }
            left = right;
        }

        return i;
    }

}
