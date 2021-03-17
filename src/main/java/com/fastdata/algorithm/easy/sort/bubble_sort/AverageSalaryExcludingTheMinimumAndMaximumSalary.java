package com.fastdata.algorithm.easy.sort.bubble_sort;

import java.text.DecimalFormat;

/**
 * @Author: Lucky
 * @Description: https://leetcode.com/problems/average-salary-excluding-the-minimum-and-maximum-salary/
 * @Date: create in 3/17/21 - 2:01 PM
 */
public class AverageSalaryExcludingTheMinimumAndMaximumSalary {

    public double average(int[] salary) {
        int length = salary.length;
        for (int i = 0; i < length - 1; i ++) {
            for (int j = 0; j < length - 1 - i; j ++) {
                if (salary[j] < salary[j + 1]) {
                    int temp = salary[j];
                    salary[j] = salary[j + 1];
                    salary[j + 1] = temp;
                }
            }
        }
        double sum = 0;
        for (int i = 1; i < length - 1; i ++) {
            sum += salary[i];
        }
        return sum / (length - 2);
    }
}
