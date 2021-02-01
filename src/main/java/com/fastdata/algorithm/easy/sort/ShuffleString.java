package com.fastdata.algorithm.easy.sort;

import java.util.*;

/**
 * @Author: Lucky
 * @Description: https://leetcode.com/problems/shuffle-string/
 * @Date: create in 12/31/20 - 11:56 AM
 */
public class ShuffleString {

    public static void main(String[] args) {
        String s = "codeleet";
        int[] indices = new int[]{4,5,6,7,0,2,1,3};
        restoreString(s, indices);
    }

    private static String restoreString(String s, int[] indices) {
        // 利用hashMap的特性
        Map<Integer, Character> map = new HashMap<>();
        for (int i = 0; i < indices.length; i ++) {
            map.put(indices[i], s.charAt(i));
        }
//        Arrays.sort(indices);
        String ret = "";
        for (int key: map.keySet()) {
            ret += map.get(key);
        }
        System.out.println("ret = " + ret);
        return ret;
    }
}
