package com.fastdata.algorithm.easy.hashtable;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: Lucky
 * @Description: https://leetcode.com/problems/check-array-formation-through-concatenation/
 * @Date: created in 2021/2/11 - 11:49
 */
public class CheckArrayFormationThroughConcatenation {
    public boolean canFormArray(int[] arr, int[][] pieces) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i ++) {
            map.put(arr[i], i);
        }
        for (int[] piece: pieces) {
            if (!map.containsKey(piece[0])) return false;
            for (int i = 1; i < piece.length; i ++) {
                if (!map.containsKey(piece[i])) return false;
                if (map.get(piece[i]) - map.get(piece[i - 1]) != 1) return false;
            }
        }
        return true;
    }
}
