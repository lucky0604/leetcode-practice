package com.fastdata.algorithm.easy.binary_search.find_positive_integer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author: Lucky
 * @Description:
 * @Date: create in 12/18/20 - 10:18 AM
 */
public class FindPositiveInteger {
    public static void main(String[] args) {
    }

    public static List<List<Integer>> findPositive(CustomFunction customFunction, int z) {
        List<List<Integer>> result = new ArrayList<>();
        int x = 1;
        int y = 1000;
        int fxy = 0;
        while (x <= 1000 && y >= 1) {
            fxy = customFunction.f(x, y);
            if (fxy > z) {
                y = y - 1;
            } else if (fxy < z) {
                x = x + 1;
            } else {
                result.add(Arrays.asList(x, y));
                x = x + 1;
            }
        }
        return result;
    }
}
