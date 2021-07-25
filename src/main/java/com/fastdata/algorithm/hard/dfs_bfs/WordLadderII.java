package com.fastdata.algorithm.hard.dfs_bfs;

import java.util.*;

/**
 * @Author: lucky
 * @License: (C) Copyright
 * @Contact: lucky_soft@163.com
 * @Date: 2021 7:53 PM
 * @Version: 1.0
 * @description: https://leetcode.com/problems/word-ladder-ii/
 **/

public class WordLadderII {

    private Set<String> set;
    private Queue<Node> q;

    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> ret = new ArrayList<>();

        set = new HashSet<>();
        q = new LinkedList<>();

        for (String s: wordList) {
            set.add(s);
        }

        if (!set.contains(endWord)) {
            return ret;
        }

        q.add(new Node(beginWord));

        while (!q.isEmpty()) {
            int size = q.size();
            Set<String> removeSet = new HashSet<>();
            for (int i = 0; i < size; i ++) {
                Node cur = q.poll();
                if (cur.name.equals(endWord)) {
                    ret.add(cur.path);
                } else {
                    List<String> neighbours = getNeighbours(cur.name);
                    for (String n: neighbours) {
                        q.add(new Node(n, cur.path));
                        removeSet.add(n);
                    }
                }
            }
            set.removeAll(removeSet);
        }

        return ret;
    }

    private List<String> getNeighbours(String word) {
        char[] ch = word.toCharArray();
        List<String> words = new ArrayList<>();
        for (int i = 0; i < ch.length; i ++) {
            char tmp = ch[i];
            for (char j = 'a'; j <= 'z'; j ++) {
                ch[i] = j;
                String newWord = new String(ch);
                if (set.contains(newWord)) {
                    words.add(newWord);
                }
            }
            ch[i] = tmp;
        }
        return words;
    }


}

// Node class to contain the String word & traversal path
class Node {
    String name;
    LinkedList<String> path;

    public Node(String name) {
        this.name = name;
        this.path = new LinkedList<>();
        this.path.add(name);
    }

    public Node(String name, LinkedList<String> path) {
        this.name = name;
        this.path = new LinkedList<>();
        this.path.addAll(path);
        this.path.add(name);
    }
}
