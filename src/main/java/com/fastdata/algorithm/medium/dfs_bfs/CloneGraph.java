package com.fastdata.algorithm.medium.dfs_bfs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @Author: lucky
 * @License: (C) Copyright
 * @Contact: lucky_soft@163.com
 * @Date: 8/23/21 11:31 AM
 * @Version: 1.0
 * @Description: https://leetcode-cn.com/problems/clone-graph/
 **/

public class CloneGraph {

    public Node cloneGraph(Node node) {
        return dfsClone(node, new HashMap<>());
    }

    public Node dfsClone(Node node, HashMap<Integer, Node> visited) {
        if (node == null) {
            return null;
        }
        if (visited.containsKey(node.val)) {
            return visited.get(node.val);
        }
        Node newNode = new Node(node.val, new ArrayList<>());
        visited.put(newNode.val, newNode);
        for (Node neighbor: node.neighbors) {
            newNode.neighbors.add(dfsClone(neighbor, visited));
        }
        return newNode;
    }
}


class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}