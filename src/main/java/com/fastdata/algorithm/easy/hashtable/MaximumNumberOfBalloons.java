package com.fastdata.algorithm.easy.hashtable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author: Lucky
 * @Description: https://leetcode.com/problems/maximum-number-of-balloons/
 * @Date: created in 2021/2/11 - 11:21
 */
public class MaximumNumberOfBalloons {

    public int maxNumberOfBalloons(String text) {
        Map<Character, Integer> map = new HashMap<>();
        ArrayList<Character> balloon = new ArrayList<>();
        int ret = 0;
        balloon.add('b');
        balloon.add('a');
        balloon.add('l');
        balloon.add('l');
        balloon.add('o');
        balloon.add('o');
        balloon.add('n');
        char[] textArr = text.toCharArray();
        for (int i = 0; i < textArr.length; i ++) {
            map.put(textArr[i], map.getOrDefault(textArr[i], 0) + 1);
        }
        int posBal = textArr.length / balloon.size();
        while (posBal > 0) {
            for (Character c: balloon) {
                if (map.get(c) != null) {
                    map.replace(c, map.get(c) - 1);
                    if (map.get(c) <= 0) {
                        map.replace(c, null);
                    }
                } else {
                    posBal --;
                    break;
                }
                if (c == 'n') {
                    ret ++;
                    posBal --;
                }
            }
        }
        return ret;
    }
}
