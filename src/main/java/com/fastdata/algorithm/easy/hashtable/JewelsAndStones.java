package com.fastdata.algorithm.easy.hashtable;

import java.util.HashSet;

/**
 * @Author: Lucky
 * @Description: https://leetcode.com/problems/jewels-and-stones/
 * @Date: create in 1/15/21 - 11:44 AM
 */
public class JewelsAndStones {
    public int numJewelsInStones(String jewels, String stones) {
        /**
         * 基本思路:
         * 将jewels中的类型存入HashSet中，遍历stones，若HashSet中存在stones中的char，则计数器+1
         */
        HashSet<Character> set = new HashSet<>();
        for (int i = 0; i < jewels.length(); i ++) {
            set.add(jewels.charAt(i));
        }
        int ret = 0;
        for (int i = 0; i < stones.length(); i ++) {
            if (set.contains(stones.charAt(i))) {
                ret ++;
            }
        }
        return ret;
    }
}
