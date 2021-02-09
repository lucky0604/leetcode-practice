package com.fastdata.algorithm.easy.hashtable;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: Lucky
 * @Description: https://leetcode.com/problems/design-hashset/
 * @Date: create in 2/9/21 - 11:09 AM
 */
public class DesignHashset {

    private Map<Integer, Integer> map = new HashMap<>();
    private int index;

    public DesignHashset() {
        index = 0;
    }

    public void add(int key) {
        if (map.containsKey(key)) {
            map.put(key, index ++);
        } else {
            map.put(key, 1);
        }
    }

    public void remove(int key) {
        map.remove(key);
        index --;
    }

    public boolean contains(int key) {
        if (map.containsKey(key)) return true;
        else return false;
    }
}
