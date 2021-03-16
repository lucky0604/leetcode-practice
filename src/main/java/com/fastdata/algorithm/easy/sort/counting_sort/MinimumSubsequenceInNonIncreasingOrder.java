package com.fastdata.algorithm.easy.sort.counting_sort;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Lucky
 * @Description: https://leetcode.com/problems/minimum-subsequence-in-non-increasing-order/
 * @Date: create in 1/4/21 - 11:33 AM
 */
// TODO: to be understand
public class MinimumSubsequenceInNonIncreasingOrder {
    public static void main(String[] args) {

    }

    private static List<Integer> minSubsequence(int[] nums) {
        // n < 100
        int[] count = new int[101];
        int sum = 0;
        // counting the frequency of each of the elements
        for (int i = 0; i < nums.length; i ++) {
            sum += nums[i];
            count[nums[i]] ++;
        }

        // if odd then add 1 to the offset
        int offset = sum % 2 == 0 ? sum / 2 : (sum / 2) + 1;
        List<Integer> ret = new ArrayList<>();
        for (int i = count.length - 1; i >= 0; i --) {
            // if the element more than once then run upto the frequency to account that
            while (count[i] > 0) {
                ret.add(i);
                sum -= i;
                if (sum < offset) {
                    i = 0;
                    break;
                }
                count[i] --;
            }
        }
        return ret;
    }
}
