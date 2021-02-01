package com.fastdata.algorithm.easy.array;

import java.util.LinkedList;
import java.util.List;

/**
 * @Author: Lucky
 * @Description: https://leetcode.com/problems/design-an-ordered-stream/
 * @Date: create in 12/29/20 - 12:14 PM
 */

/**
 * TODO: 理解此题思路
 */
public class OrderedStream {
    private String[] stream;
    private int ptr;

    public static void main(String[] args) {

    }

    public OrderedStream(int n) {
        this.stream = new String[n + 1];
        this.ptr = 1;
    }

    public List<String> insert(int id, String value) {
        stream[id] = value;
        List<String> list = new LinkedList<>();
        while (ptr < stream.length && stream[ptr] != null) {
            list.add(stream[ptr ++]);
        }
        return list;
    }

}
