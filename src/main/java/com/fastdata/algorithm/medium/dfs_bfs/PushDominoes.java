package com.fastdata.algorithm.medium.dfs_bfs;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author: lucky
 * @License: (C) Copyright
 * @Contact: lucky_soft@163.com
 * @Date: 7/22/21 2:25 PM
 * @Version: 1.0
 * @Description: https://leetcode.com/problems/push-dominoes
 **/

public class PushDominoes {

    public String pushDominoes(String s) {
        Queue<Integer> queue = new LinkedList<>();
        StringBuilder ret = new StringBuilder(s);
        for (int i = 0; i < s.length(); i ++) {
            if (s.charAt(i) != '.') {
                queue.add(i);
            }
        }

        while (queue.size() > 0) {
            int size = queue.size();
            HashSet<Integer> set = new HashSet<>();
            while (size -- > 0) {
                int i = queue.poll();

                if (ret.charAt(i) == 'L') {
                    if (i - 1 >= 0 && ret.charAt(i - 1) == '.') {
                        ret.setCharAt(i - 1, 'L');
                        set.add(i - 1);
                        queue.add(i - 1);
                    } else if (i - 1 >= 0 && ret.charAt(i - 1) == 'R') {
                        if (set.contains(i - 1)) {
                            ret.setCharAt(i - 1, '.');
                        }
                    }
                } else if (ret.charAt(i) == 'R') {
                    if (i + 1 < ret.length() && ret.charAt(i + 1) == '.') {
                        ret.setCharAt(i + 1, 'R');
                        set.add(i + 1);
                        queue.add(i + 1);
                    } else if (i + 1 < ret.length() && ret.charAt(i + 1) == 'L') {
                        if (set.contains(i + 1)) {
                            ret.setCharAt(i + 1, '.');
                        }
                    }
                }
            }

        }
        return ret.toString();
    }
}
