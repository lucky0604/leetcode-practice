package com.fastdata.algorithm.medium.sort;

import java.util.Arrays;

/**
 * @Author: Lucky
 * @Description: https://leetcode.com/problems/bag-of-tokens/
 * @Date: created in 2021/4/3 - 20:43
 */
public class BagOfTokens {

    public int bagOfTokensScore(int[] tokens, int P) {
        // last max score
        int ret = 0;
        // current score
        int score = 0;
        // two pointers
        int head = 0, last = tokens.length - 1;

        // sort the tokens
        Arrays.sort(tokens);

        while (head <= last) {
            // exchange power to token
            if (P >= tokens[head]) {
                P -= tokens[head ++];
                score ++;
                ret = Math.max(ret, score);
            } else if (score > 0) {
                // exchange token to power, exchange the token from last to head
                P += tokens[last --];
                score --;
            } else {
                break;
            }
        }
        return ret;
    }
}
