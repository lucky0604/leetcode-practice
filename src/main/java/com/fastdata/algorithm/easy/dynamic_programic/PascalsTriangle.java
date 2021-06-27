package com.fastdata.algorithm.easy.dynamic_programic;

import edu.princeton.cs.algs4.In;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: lucky
 * @License: (C) Copyright
 * @Contact: lucky_soft@163.com
 * @Date: 2021/6/27 13:55
 * @Version: 1.0
 * @description:
 **/

public class PascalsTriangle {

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ret = new ArrayList<>();
        if (numRows == 0) {
            return ret;
        }
        List<Integer> first = new ArrayList<>();
        first.add(1);
        ret.add(first);

        for (int i = 1; i < numRows; i ++) {
            List<Integer> prev = ret.get(i - 1);
            List<Integer> curr = new ArrayList<>();
            curr.add(1);
            for (int j = 1; j < i; j ++) {
                curr.add(prev.get(j - 1) + prev. get(j));
            }
            curr.add(1);
            ret.add(curr);
        }
        return ret;
    }
}
