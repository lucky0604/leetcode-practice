package com.fastdata.algorithm.easy.array;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Lucky
 * @Description: https://leetcode.com/problems/decompress-run-length-encoded-list/
 * @Date: create in 12/29/20 - 11:00 AM
 */
public class DecompressRunLengthEncodedList {
    public static void main(String[] args) {

    }

    private static int[] decompressRLElist(int[] nums) {
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < nums.length - 1; i += 2) {
            int freq = nums[i];
            int val = nums[i + 1];
            while (freq > 0) {
                res.add(val);
                freq --;
            }
        }
        int[] result = new int[res.size()];
        for (int j = 0; j < res.size(); j ++) {
            result[j] = res.get(j);
        }
        return result;
    }
}
