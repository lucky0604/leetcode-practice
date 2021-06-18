package com.fastdata.algorithm.medium.tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @Author: lucky
 * @License: (C) Copyright
 * @Contact: lucky_soft@163.com
 * @Date: 5/29/21 11:43 AM
 * @Version: 1.0
 * @Description: https://leetcode.com/problems/path-in-zigzag-labelled-binary-tree/
 **/
// TODO: to be understand
public class PathInZigzagLabelledBinaryTree {

    public List<Integer> pathInZigZagTree(int label) {
        List<Integer> ret = new ArrayList<>();
        if (label == 1) {
            ret.add(label);
            return ret;
        }
        int i = 2;
        int rowCount = 1;
        while (i <= label) {
            i *= 2;
            rowCount ++;
        }
        // the row before this label's row
        int end = i / 2 - 1;
        int start = i / 4;

        // add the final value into the list
        ret.add(label);
        label /= 2;
        // find the next
        int next = start + Math.abs(label - end);
        ret.add(next);

        int tmp = 1;
        while (label > 1 && next > 1) {
            label /= 2;
            next /= 2;
            if (tmp % 2 == 0) {
                // if it is even row
                ret.add(next);
            } else {
                ret.add(label);
            }
            tmp ++;
        }
        Collections.reverse(ret);
        return ret;
    }
}
