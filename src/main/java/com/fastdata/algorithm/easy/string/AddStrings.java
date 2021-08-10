package com.fastdata.algorithm.easy.string;

/**
 * @Author: lucky
 * @License: (C) Copyright
 * @Contact: lucky_soft@163.com
 * @Date: 8/10/21 10:10 AM
 * @Version: 1.0
 * @Description: https://leetcode.com/problems/add-strings/
 **/

public class AddStrings {

    public String addStrings(String num1, String num2) {
        StringBuilder sb = new StringBuilder();
        final int n = Math.max(num1.length(), num2.length());
        int memory = 0;
        for (int i = 0; i < n; i ++) {
            int curr = memory;
            memory = 0;
            if (i < num1.length()) {
                curr += (int) num1.charAt(num1.length() - i - 1) - 48;
            }
            if (i < num2.length()) {
                curr += (int) num2.charAt(num2.length() - i - 1) - 48;
            }
            if (curr > 9) {
                memory = curr / 10;
                curr %= 10;
            }
            sb.append(curr);
        }
        if (memory > 0) {
            sb.append(memory);
        }
        return sb.reverse().toString();
    }

}
