package com.fastdata.algorithm.medium.binary_search;

/**
 * @Author: lucky
 * @License: (C) Copyright
 * @Contact: lucky_soft@163.com
 * @Date: 2021/9/10 - 10:12
 * @Version: 1.0
 * @description: https://leetcode-cn.com/problems/find-the-student-that-will-replace-the-chalk/
 **/

public class FindTheStudentThatWillReplaceTheChalk {

    public int chalkReplacer(int[] chalk, int k) {
        int n = chalk.length;
        if (chalk[0] > k) {
            return 0;
        }
        for (int i = 1; i < n; i ++) {
            chalk[i] += chalk[i - 1];
            if (chalk[i] > k) {
                return i;
            }
        }
        k %= chalk[n - 1];
        return binarySearch(chalk, k);
    }

    private int binarySearch(int[] arr, int target) {
        int low = 0;
        int high = arr.length - 1;
        while (low < high) {
            int mid = (high - low) / 2 + low;
            if (arr[mid] <= target) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }
}
