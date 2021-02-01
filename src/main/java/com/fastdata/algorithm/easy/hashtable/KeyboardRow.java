package com.fastdata.algorithm.easy.hashtable;

import java.util.*;

/**
 * @Author: Lucky
 * @Description: https://leetcode.com/problems/keyboard-row/
 * @Date: create in 1/18/21 - 10:56 AM
 */
public class KeyboardRow {
    public static void main(String[] args) {
        String[] words = new String[]{"Hello","Alaska","Dad","Peace"};
        findWords(words);
//        Character a = 'A';
//        System.out.println(" a = " + a.toString().toLowerCase());
    }

    public static String[] findWords(String[] words) {
        char[] row1 = new char[]{'q', 'w', 'e', 'r', 't', 'y', 'u', 'i', 'o', 'p'};
        char[] row2 = new char[]{'a', 's', 'd', 'f', 'g', 'h', 'j', 'k', 'l'};
        char[] row3 = new char[]{'z', 'x', 'c', 'v', 'b', 'n', 'm'};
        Map<String, Integer> map1 =  charToMap(row1);
        Map<String, Integer> map2 = charToMap(row2);
        Map<String, Integer> map3 = charToMap(row3);
        List<String> ret = new ArrayList<>();
        for (int i = 0; i < words.length; i ++) {
            char[] charArr = words[i].toCharArray();
            boolean isRow1 = true;
            boolean isRow2 = true;
            boolean isRow3 = true;
            for (char c: charArr) {
                if (!map1.containsKey(Character.toString(c).toLowerCase())) {
                    isRow1 = false;
                }
                if (!map2.containsKey(Character.toString(c).toLowerCase())) {
                    isRow2 = false;
                }
                if (!map3.containsKey(Character.toString(c).toLowerCase())) {
                    isRow3 = false;
                }

            }
            if (isRow1 || isRow2 || isRow3) {
                ret.add(words[i]);
            }
        }
        System.out.println("ret = " + ret);
        String[] res = new String[ret.size()];
        for (int i = 0; i < ret.size(); i ++) {
            res[i] = ret.get(i);
        }
        return res;
    }

    private static Map<String, Integer> charToMap(char[] charArr) {
        Map<String, Integer> ret = new HashMap<>();
        for (int i = 0; i < charArr.length; i ++) {
            ret.put(Character.toString(charArr[i]), i);
        }
        return ret;
    }
}
