package com.fastdata.algorithm.medium.stack;

import scala.Char;

import java.util.Collections;
import java.util.LinkedList;

/**
 * @Author: lucky
 * @License: (C) Copyright
 * @Contact: lucky_soft@163.com
 * @Date: 8/25/21 11:00 AM
 * @Version: 1.0
 * @Description: https://leetcode-cn.com/problems/decode-string/
 **/

public class DecodeString {

    int ptr;
    public String decodeString(String s) {
        LinkedList<String> stk = new LinkedList<>();
        ptr = 0;
        while (ptr < s.length()) {
            char cur = s.charAt(ptr);
            if (Character.isDigit(cur)) {
                String digits = getDigit(s);
                stk.addLast(digits);
            } else if (Character.isLetter(cur) || cur == '[') {
                stk.addLast(String.valueOf(s.charAt(ptr ++)));
            } else {
                ++ptr;
                LinkedList<String> sub = new LinkedList<>();
                while (!"[".equals(stk.peekLast())) {
                    sub.addLast(stk.removeLast());
                }
                Collections.reverse(sub);
                stk.removeLast();
                int repTime = Integer.parseInt(stk.removeLast());
                StringBuffer t = new StringBuffer();
                String o = getString(sub);
                while (repTime -- > 0) {
                    t.append(o);
                }
                stk.addLast(t.toString());
            }
        }
        return getString(stk);
    }

    private String getDigit(String s) {
        StringBuffer sb = new StringBuffer();
        while (Character.isDigit(s.charAt(ptr))) {
            sb.append(s.charAt(ptr ++));
        }
        return sb.toString();
    }

    private String getString(LinkedList<String> v) {
        StringBuffer ret = new StringBuffer();
        for (String s: v) {
            ret.append(s);
        }
        return ret.toString();
    }
}
