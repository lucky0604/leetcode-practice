package com.fastdata.algorithm.easy.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: lucky
 * @License: (C) Copyright
 * @Contact: lucky_soft@163.com
 * @Date: 6/15/21 10:29 AM
 * @Version: 1.0
 * @Description: https://leetcode.com/problems/binary-watch/
 **/

public class BinaryWatch {

    public List<String> readBinaryWatch(int turnedOn) {
        List<String> ret = new ArrayList<>();
        int[] arr = new int[]{1,2,4,8,1,2,4,8,16,32};

        backtracking(arr, 0, 0, 0, turnedOn, ret);
        return ret;
    }

    private void backtracking(int[] arr, int pos, int hour, int minute, int led, List<String> ret) {
        if (led == 0) {
            // if led is 0, return directly, but we should check the hour and minute first
            if (hour <= 11 && minute <= 59) {
                StringBuilder sb = new StringBuilder();
                sb.append(hour).append(":").append(minute <= 9 ? "0" + minute: minute);
                ret.add(sb.toString());
            }
            return;
        }

        // standard backtracking code
        for (int i = pos; i < arr.length; i ++) {
            // add new value
            if (isHour(i)) {
                hour += arr[i];
            } else {
                minute += arr[i];
            }

            // do recursion
            backtracking(arr, i + 1, hour, minute, led - 1, ret);

            // then remove it
            if (isHour(i)) {
                hour -= arr[i];
            } else {
                minute -= arr[i];
            }
        }
    }

    private boolean isHour(int pos) {
        return pos >= 0 && pos <= 3;
    }

}
