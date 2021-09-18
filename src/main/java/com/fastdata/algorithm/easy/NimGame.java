package com.fastdata.algorithm.easy;

/**
 * @Author: lucky
 * @License: (C) Copyright
 * @Contact: lucky_soft@163.com
 * @Date: 2021/9/18 - 10:04
 * @Version: 1.0
 * @description: https://leetcode-cn.com/problems/nim-game/
 **/

public class NimGame {

    public boolean canWinNim(int n) {
        return n % 4 != 0;
    }
}
