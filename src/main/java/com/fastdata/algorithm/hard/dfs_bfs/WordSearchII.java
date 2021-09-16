package com.fastdata.algorithm.hard.dfs_bfs;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: lucky
 * @License: (C) Copyright
 * @Contact: lucky_soft@163.com
 * @Date: 2021/9/16 - 10:08
 * @Version: 1.0
 * @description: https://leetcode-cn.com/problems/word-search-ii/
 **/

public class WordSearchII {

    int[][] dirs = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public List<String> findWords(char[][] board, String[] words) {

        List<String> resultList = new ArrayList<>();
        TrieNode root = buildTrie(words);

        int m = board.length;
        int n = board[0].length;
        boolean[][] visited = new boolean[m][n];
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < board.length; i ++) {
            for (int j = 0; j < board[i].length; j ++) {
                dfs(resultList, result, board, i, j, root, root, visited);
            }
        }
        return resultList;

    }

    private void dfs(List<String> resultList, StringBuilder result, char[][] board, int i, int j, TrieNode root, TrieNode node, boolean[][] visited) {
        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length || visited[i][j] || node == null || node.children[board[i][j] - 'a'] == null) {
            return;
        }
        result.append(board[i][j]);

        if (node.children[board[i][j] - 'a'].isEnd) {
            String word = result.toString();
            resultList.add(word);
            deleteWordFromTrie(root, word);
        }

        visited[i][j] = true;

        for (int[] dir: dirs) {
            dfs(resultList, result, board, i + dir[0], j + dir[1], root, node.children[board[i][j] - 'a'], visited);
        }

        visited[i][j] = false;
        result.deleteCharAt(result.length() - 1);
    }

    private void deleteWordFromTrie(TrieNode root, String word) {
        delete(root, word, 0);
    }

    private boolean delete(TrieNode prev, String word, int i) {
        if (i == word.length() - 1) {
            TrieNode curr = prev.children[word.charAt(i) - 'a'];
            if (hasChildren(curr)) {
                curr.isEnd = false;
                return false;
            } else {
                prev.children[word.charAt(i) - 'a'] = null;
                return true;
            }
        } else {
            if (delete(prev.children[word.charAt(i) - 'a'], word, i + 1)
            && !prev.children[word.charAt(i) - 'a'].isEnd
            && !hasChildren(prev.children[word.charAt(i) - 'a'])) {
                prev.children[word.charAt(i) - 'a'] = null;
                return true;
            }
            return false;
        }
    }

    private boolean hasChildren(TrieNode curr) {
        for (TrieNode child: curr.children) {
            if (child != null) {
                return true;
            }
        }
        return false;
    }

    private TrieNode buildTrie(String[] words) {
        TrieNode root = new TrieNode();
        for (String word: words) {
            char[] arr = word.toCharArray();
            TrieNode curr = root;
            for (char c: arr) {
                if (curr.children[c - 'a'] == null) {
                    curr.children[c - 'a'] = new TrieNode();
                }
                curr = curr.children[c - 'a'];
            }
            curr.isEnd = true;
        }
        return root;
    }

    class TrieNode {
        boolean isEnd = false;
        TrieNode[] children = new TrieNode[26];
    }
}
