package com.fastdata.algorithm.easy.string;

/**
 * @Author: lucky
 * @License: (C) Copyright
 * @Contact: lucky_soft@163.com
 * @Date: 6/9/21 10:21 AM
 * @Version: 1.0
 * @Description: https://leetcode.com/problems/add-binary/
 **/
// TODO: to be understand
public class AddBinary {

    public String addBinary(String a, String b) {
        StringBuilder ret = new StringBuilder();
        int aIndex = a.length() - 1;
        int bIndex = b.length() - 1;
        int carry = 0;
        while (aIndex >= 0 || bIndex >= 0) {
            int sum = 0;
            if (aIndex >= 0) {
                // change char to int
                sum += a.charAt(aIndex) - '0';
                aIndex --;
            }
            // the same to string b
            if (bIndex >= 0) {
                sum += b.charAt(bIndex) - '0';
                bIndex --;
            }
            sum += carry;
            ret.append(sum % 2);
            carry = sum / 2;
        }
        if (carry > 0) {
            ret.append(carry);
        }
        return ret.reverse().toString();
    }

}
