package com.fastdata.algorithm.medium.hashmap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * @Author: lucky
 * @License: (C) Copyright
 * @Contact: lucky_soft@163.com
 * @Date: 8/13/21 11:49 AM
 * @Version: 1.0
 * @Description: https://leetcode.com/problems/group-anagrams/
 **/

public class GroupAnagrams {

    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();

        for (int i = 0; i < strs.length; i ++) {
            String s1 = strs[i];
            char[] arr = s1.toCharArray();
            Arrays.sort(arr);
            String str = new String(arr);

            if (map.containsKey(str)) {
                map.get(str).add(s1);
            } else {
                map.put(str, new ArrayList<>());
                map.get(str).add(s1);
            }
        }

        return new ArrayList<>(map.values());
    }
}
