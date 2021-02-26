package com.fastdata.algorithm.easy.hashtable;

import java.util.Arrays;

/**
 * @Author: Lucky
 * @Description: https://leetcode.com/problems/count-primes/
 * @Date: create in 2/26/21 - 11:24 AM
 */
public class CountPrimes {

    public int countPrimes(int n) {
        if (n <= 2) return 0;
        boolean[] prime = new boolean[n];
        Arrays.fill(prime, true);
        int count = n - 2;
        for (int i = 2; i * i < n; i ++) {
            for (int j = i; j * i < n; j ++) {
                if (prime[i * j]) {
                    prime[i * j] = false;
                    count --;
                }
            }
        }
        return count;
    }
}
