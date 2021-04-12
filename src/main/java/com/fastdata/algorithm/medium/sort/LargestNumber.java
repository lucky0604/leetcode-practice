package com.fastdata.algorithm.medium.sort;

import java.util.*;

/**
 * @Author: Lucky
 * @Description: https://leetcode.com/problems/largest-number/
 * @Date: created in 2021/4/10 - 10:39
 */
public class LargestNumber {

    public String largestNumber(int[] nums) {

        String[] stringArr = new String[nums.length];
        for (int i = 0; i < nums.length; i ++) {
            stringArr[i] = Integer.toString(nums[i]);
        }

        Arrays.sort(stringArr, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                String s1 = o1 + o2;
                String s2 = o2 + o1;
                return s2.compareTo(s1);
            }
        });

        if (stringArr[0].equals("0")) return "0";
        StringBuilder sb = new StringBuilder();
        for (String str: stringArr)
            sb.append(str);

        return sb.toString();

    }
}
