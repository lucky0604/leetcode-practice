package com.fastdata.algorithm.hard.greedy;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: lucky
 * @License: (C) Copyright
 * @Contact: lucky_soft@163.com
 * @Date: 9/9/21 10:13 AM
 * @Version: 1.0
 * @Description: https://leetcode-cn.com/problems/text-justification/
 **/

public class TextJustification {
    List<String> ret;

    public List<String> fullJusitify(String[] words, int maxWidth) {
        ret = new ArrayList<>();
        int left = 0;
        int right = 0;
        int n = words.length;
        while (true) {
            left = right;
            int sumLen = 0;
            while (right < n && sumLen + words[right].length() + right - left <= maxWidth) {
                sumLen += words[right++].length();
            }
            if (right == n) {
                StringBuffer sb = new StringBuffer();
                sb.append(appendString(words, left, right, " "));
                sb.append(appendSpace(maxWidth - sb.length()));
                ret.add(sb.toString());
                return ret;
            }
            int numWords = right - left;
            int blankSpace = maxWidth - sumLen;
            if (numWords == 1) {
                StringBuffer sb = new StringBuffer(words[left]);
                sb.append(appendSpace(maxWidth - sb.length()));
                ret.add(sb.toString());
                continue;
            }
            int avgSpace = blankSpace / (numWords - 1);
            int extraSpace = blankSpace % (numWords - 1);
            StringBuffer sb = new StringBuffer();
            sb.append(appendString(words, left, left + extraSpace + 1, appendSpace(avgSpace + 1)));
            sb.append(appendSpace(avgSpace));
            sb.append(appendString(words, left + extraSpace + 1, right, appendSpace(avgSpace)));
            ret.add(sb.toString());
        }
    }

    private String appendSpace(int n) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < n; i ++) {
            sb.append(' ');
        }

        return sb.toString();
    }

    private String appendString(String[] words, int left, int right, String str) {
        StringBuffer sb = new StringBuffer(words[left]);
        for (int i = left + 1; i < right; i ++) {
            sb.append(str);
            sb.append(words[i]);
        }
        return sb.toString();
    }
}
