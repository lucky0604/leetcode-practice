package com.fastdata.algorithm.easy.tree;

import java.util.List;

/**
 * @Author: Lucky
 * @Description: for n-ary tree
 * @Date: create in 1/11/21 - 10:19 AM
 */
public class Node {
    public int val;
    public List<Node> children;

    public Node() {};

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
}
