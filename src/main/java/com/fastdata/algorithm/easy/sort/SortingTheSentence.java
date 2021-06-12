package com.fastdata.algorithm.easy.sort;

import com.sun.org.apache.xerces.internal.impl.xpath.regex.Match;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Author: lucky
 * @License: (C) Copyright
 * @Contact: lucky_soft@163.com
 * @Date: 2021-06-12 11:26 AM
 * @Version: 1.0
 * @description: https://leetcode.com/problems/sorting-the-sentence/
 **/

public class SortingTheSentence {

    public static String sortSentence(String s) {
        String[] sArr = s.split(" ");
        String[] tmp = new String[sArr.length];

        int index = 0;
        for (String str: sArr) {
            index = (int) (str.charAt(str.length() - 1) - '0');
            tmp[index - 1] = str.substring(0, str.length() - 1);
        }

        StringBuilder sb = new StringBuilder();
        for (index = 0; index < tmp.length - 1; index ++) {
            sb.append(tmp[index]).append(" ");
        }
        sb.append(tmp[index]);
        return sb.toString();
    }

}
