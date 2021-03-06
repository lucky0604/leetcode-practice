package com.fastdata.algorithm.medium.heap;

import java.util.PriorityQueue;

/**
 * @Author: Lucky
 * @Description: https://leetcode.com/problems/super-ugly-number/
 * @Date: create in 3/6/21 - 10:07 AM
 */
public class SuperUglyNumber {

    public int nthSuperUglyNumber(int n, int[] primes) {
        PriorityQueue<Ugly> pq = new PriorityQueue<>();
        int[] uglyArr = new int[n];

        for (int i = 0; i < primes.length; i ++) {
            pq.add(new Ugly(primes[i], 1, primes[i]));
        }
        uglyArr[0] = 1;
        for (int i = 1; i < n; i ++) {
            // here let we have gone till 1,2, this time i = 3 we get min values i.e. 3 out of heap and store uglyArr[2] = 3
            uglyArr[i] = pq.peek().val;
            // taking the while loop because at a time i.e 2 factor = 6 and 3 factor = 6 so we will update respecitively of 2 and 3 factors
            while (pq.peek().val == uglyArr[i]) {
                Ugly rem = pq.remove();
                pq.add(new Ugly(uglyArr[rem.index] * rem.set, rem.index + 1, rem.set));
            }
        }
        return uglyArr[n - 1];
    }
}

class Ugly implements Comparable<Ugly> {
    int val;    // this is for the value
    int index;  // index which will be used for storing next number of primes[i]
    int set;    // this is used for the primes[i] number which will be multiplied with the values

    public Ugly(int val, int index, int set) {
        this.val = val;
        this.index = index;
        this.set = set;
    }

    public int compareTo(Ugly p) {
        return this.val - p.val;
    }
}
