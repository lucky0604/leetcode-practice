package com.fastdata.algorithm.utils;

import edu.princeton.cs.algs4.StdDraw;

/**
 * @Author: lucky
 * @License: (C) Copyright
 * @Contact: lucky_soft@163.com
 * @Date: 5/14/21 12:16 PM
 * @Version: 1.0
 * @Description:
 **/

public class StatsUtils
{
    public static void plotBars(double[] values, double halfWidth) {
        for (int i = 0; i < values.length; i ++) {
            StdDraw.filledRectangle(i, values[i] / 2, halfWidth, values[i] / 2);
        }
    }
}
