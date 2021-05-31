package com.fastdata.algorithm.solutions.ch02.section04;

import com.fastdata.algorithm.utils.ArrayUtil;

/**
 * @Author: lucky
 * @License: (C) Copyright
 * @Contact: lucky_soft@163.com
 * @Date: 2021-05-31 9:54 AM
 * @Version: 1.0
 * @description:
 **/

public class Solution2_4_15 {

    public static boolean certification(Comparable[] pq) {
        for (int i = 1; i < pq.length / 2; i ++) {
            // check left child
            if (!ArrayUtil.less(pq[i], pq[i * 2])) {
                return false;
            }

            // check right child
            if (i * 2 + 1 < pq.length && !ArrayUtil.less(pq[i], pq[i * 2 + 1])) {
                return false;
            }
        }
        return true;
    }
}
