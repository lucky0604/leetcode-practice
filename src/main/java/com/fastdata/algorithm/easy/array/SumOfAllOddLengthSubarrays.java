package com.fastdata.algorithm.easy.array;

/**
 * @Author: Lucky
 * @Description: https://leetcode.com/problems/sum-of-all-odd-length-subarrays/
 * @Date: create in 1/4/21 - 11:41 AM
 */
public class SumOfAllOddLengthSubarrays {
    public static void main(String[] args) {

    }

    private static int subOddLengthSubarrays(int[] arr) {
        /**
         * notes: https://leetcode.com/problems/sum-of-all-odd-length-subarrays/discuss/981968/Java-easy-solution-with-proper-explanation.
         */
        int result = 0;
        int n = arr.length;
        for (int i = 0; i < n; i ++) {
            int end = i + 1;
            int start = n - i;
            int total = end * start;
            int odd = total / 2;
            if (total % 2 == 1) {
                odd += 1;
            }
            result += odd * arr[i];
        }
        return result;
    }
}
