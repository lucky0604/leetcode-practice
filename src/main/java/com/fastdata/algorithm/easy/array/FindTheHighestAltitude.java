package com.fastdata.algorithm.easy.array;

import java.util.Arrays;

/**
 * @Author: Lucky
 * @Description: https://leetcode.com/problems/find-the-highest-altitude/
 * @Date: create in 1/27/21 - 10:01 AM
 */
public class FindTheHighestAltitude {
    public static void main(String[] args) {
        int[] gain = new int[]{-5,1,5,0,-7};
        int ret = largestAltitude(gain);
    }

    public static int largestAltitude(int[] gain) {
        int ret = 0;
        int[] ans = new int[gain.length + 1];
        ans[0] = 0;
        for (int i = 0; i < gain.length; i ++) {
            ret += gain[i];
            ans[i + 1] = ret;
        }
        int num;
        for (int i = 1; i < ans.length; i ++) {
            num = ans[i];
            int j = i - 1;
            while (j >= 0 && ans[j] > num) {
                ans[j + 1] = ans[j];
                j --;
            }
            ans[j + 1] = num;
        }
        System.out.println("ans = " + Arrays.toString(ans));
        return ans[-1];
    }
}
